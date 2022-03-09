package com.iiht.market.service;

import java.text.ParseException;
import java.util.List;

import com.iiht.market.exceoptions.CompnyNotFound;
import com.iiht.market.exceoptions.TurnOverCheckException;
import com.iiht.market.model.Compny;
import com.iiht.market.model.CompnyDetails;
import com.iiht.market.model.CompnyStocks;

public interface ICompnyService {
	public String saveCompny(Compny compny) throws TurnOverCheckException;
	public CompnyDetails viewCompnyDetails(int compnyCode) throws CompnyNotFound;

	public String deleteCompny(int compnyCode);
	public List<CompnyDetails> getAll();
	public CompnyStocks getStockDetailsByDate(String startDate, String endDate);
	public CompnyStocks getStockDetailsByDate(int compnyCode, String startDate, String endDate) throws ParseException;
	public List<Compny> getCompnies() throws CompnyNotFound;
	

}
