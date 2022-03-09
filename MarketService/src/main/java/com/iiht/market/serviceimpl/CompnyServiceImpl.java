package com.iiht.market.serviceimpl;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iiht.market.exceoptions.CompnyNotFound;
import com.iiht.market.exceoptions.TurnOverCheckException;
import com.iiht.market.model.Compny;
import com.iiht.market.model.CompnyDetails;
import com.iiht.market.model.CompnyStocks;
import com.iiht.market.model.StockDetails;
import com.iiht.market.repos.CompnyRepo;
import com.iiht.market.service.ICompnyService;

@Service
public class CompnyServiceImpl implements ICompnyService {
	@Autowired
	public CompnyRepo compnyRepo;
	@Autowired
	public RestTemplate restTemplate;

	@Override
	public String saveCompny(Compny compny) throws TurnOverCheckException {
		// TODO Auto-generated method stub
		String result = "";
		if (compny.getTurnOver() <= 100000000) {
			throw new TurnOverCheckException("Turn Over must be greater that 10cr");
		}
		Compny company = compnyRepo.save(compny);
		if (compny != null) {
			result = "Compny details added successfuly with Compny Id " + company.getCompnyCode();
		} else {
			result = "Unable to add Compny details";
		}
		return result;
	}

	@Override
	public CompnyDetails viewCompnyDetails(int compnyCode) throws CompnyNotFound {
		// TODO Auto-generated method stub
		CompnyDetails details = new CompnyDetails();
		Compny cmpny = new Compny();
		StockDetails stock = null;

		Optional<Compny> opt = compnyRepo.findById(compnyCode);

		if (opt.isPresent()) {
			System.out.println("there");
			cmpny = opt.get();
			System.out.println(cmpny.getCompnyCode());
			String url = "http://localhost:9091/api/v1.0/market/stock/get/" + compnyCode;
			System.out.println("cancel uri->" + url);
			ResponseEntity<StockDetails> res = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<StockDetails>() {
					});
			stock = res.getBody();
			
		} else {
			throw new CompnyNotFound("Compny details not there for compny code " + compnyCode);
		}
		if (cmpny != null ) {
			details.setCompnyCode(cmpny.getCompnyCode());
			details.setCompnyCeo(cmpny.getCompnyCeo());
			details.setCompnyName(cmpny.getCompnyName());
			details.setStock(cmpny.getStock());
			details.setStock(cmpny.getStock());
			details.setTurnOver(cmpny.getTurnOver());
			details.setWebsite(cmpny.getWebsite());
			details.setWebsite(cmpny.getWebsite());
			
			
		}
		if(stock!=null) {
		
			details.setStockValue(stock.getStockValue());
			details.setDate(stock.getStockDate());
		}
		return details;
	}

	@Override
	public String deleteCompny(int compnyCode) {
		// TODO Auto-generated method stub
		String msg = "";
		try {
			Optional opt = compnyRepo.findById(compnyCode);
			if (opt.isPresent()) {
				compnyRepo.deleteById(compnyCode);
				String url = "http://localhost:9091/api/v1.0/market/stock/delete/" + compnyCode;
				System.out.println("cancel uri->" + url);
				ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.DELETE, null,
						new ParameterizedTypeReference<String>() {
						});
				String msgStock = res.getBody();
				System.out.println(msgStock);
				msg = "Successfully deleted Compny details with compny code " + compnyCode + " " + msgStock;
			} else {
				msg = "Compny details not availbele.....";
			}
		} catch (Exception e) {
			System.out.println(e);
			msg = "Unable to delete compny details...Something wrong!!!";
		}

		return msg;
	}

	@Override
	public List<CompnyDetails> getAll() {
		List<CompnyDetails> listCompnies = new ArrayList();
		List<Compny> compnies = compnyRepo.findAll();
		StockDetails stock = new StockDetails();
		if (compnies != null) {

			for (Compny compny : compnies) {
				String url = "http://localhost:9091/api/v1.0/market/stock/get/" + compny.getCompnyCode();
				System.out.println("cancel uri->" + url);
				ResponseEntity<StockDetails> res = restTemplate.exchange(url, HttpMethod.GET, null,
						new ParameterizedTypeReference<StockDetails>() {
						});
				stock = res.getBody();
				CompnyDetails details = new CompnyDetails();
				if (stock != null) {
					details.setStockValue(stock.getStockValue());
					details.setDate(stock.getStockDate());
				}
				details.setCompnyCode(compny.getCompnyCode());
				details.setCompnyCeo(compny.getCompnyCeo());
				details.setCompnyName(compny.getCompnyName());
				details.setWebsite(compny.getWebsite());
				details.setStock(compny.getStock());
				details.setTurnOver(compny.getTurnOver());

				listCompnies.add(details);
			}
		}
		return listCompnies;

	}

	public static String covDate(String date) throws ParseException {

		DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

		String inputText = "2012-11-17T00:00:00.000-05:00";
		java.util.Date cdate = inputFormat.parse(date);
		String outputText = outputFormat.format(cdate);
		return outputText;
	}

	@Override
	public CompnyStocks getStockDetailsByDate(int compnyCode, String startDate, String endDate) throws ParseException {

		String cSdate =covDate(startDate);
		String cEndate = covDate(endDate);
		System.out.println(cSdate +" "+ cEndate);
		 
		// TODO Auto-generated method stub
		Timestamp timestamp1 = Timestamp.valueOf(cSdate);
		Timestamp timestamp2 = Timestamp.valueOf(cEndate);
		CompnyStocks compnyStock = new CompnyStocks();
		System.out.println(startDate);
		System.out.println(endDate);
		Compny compny = compnyRepo.getById(compnyCode);
		String url = "http://localhost:9091/api/v1.0/market/stock/get/" + compny.getCompnyCode() + "/" + startDate + "/"
				+ endDate;
		System.out.println("cancel uri->" + url);
		ResponseEntity<List<StockDetails>> res = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<StockDetails>>() {
				});
		List<StockDetails> stock = res.getBody();
		if (stock != null && !stock.isEmpty()) {
			stock.sort((s1, s2) -> Double.compare(s1.getStockValue(), s2.getStockValue()));
			compnyStock.setStocks(stock);
			compnyStock.setMaxStock(stock.get(stock.size() - 1).getStockValue());
			compnyStock.setAvgStock(getAverage(stock));
			
			compnyStock.setMinStock(stock.get(0).getStockValue());
		}

		compnyStock.setCompnyCode(compny.getCompnyCode());
		compnyStock.setCompnyCeo(compny.getCompnyCeo());
		compnyStock.setCompnyName(compny.getCompnyName());
		compnyStock.setStock(compny.getStock());

		compnyStock.setTurnOver(compny.getTurnOver());
		compnyStock.setStock(compny.getStock());
		compnyStock.setWebsite(compny.getWebsite());

		// List<StockDetails> stocks = stockRepo.findByStockDate(timestamp1,
		// timestamp2);
		System.out.println(compnyStock);
		return compnyStock;
		
	}

	public double getAverage(List<StockDetails> stocks) {
		int size = stocks.size();
		double avaeage;
		double sum = 0.0;
		for (StockDetails s : stocks) {

			sum += s.getStockValue();
		}
		avaeage = sum / (size);
		return avaeage;

	}

	@Override
	public List<Compny> getCompnies() throws CompnyNotFound {
		// TODO Auto-generated method stub
		List<Compny> compnies = compnyRepo.findAll();
		if (compnies.size() == 0 || compnies.isEmpty() || compnies == null) {
			throw new CompnyNotFound("No Compnies available");
		}

		return compnies;
	}

	@Override
	public CompnyStocks getStockDetailsByDate(String startDate, String endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
