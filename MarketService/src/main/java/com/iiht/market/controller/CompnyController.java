package com.iiht.market.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.market.exceoptions.CompnyNotFound;
import com.iiht.market.exceoptions.TurnOverCheckException;
import com.iiht.market.model.Compny;
import com.iiht.market.model.CompnyDetails;
import com.iiht.market.model.CompnyStocks;
import com.iiht.market.model.Successresponse;
import com.iiht.market.service.ICompnyService;

import io.swagger.annotations.Api;

@RestController
@Api
@RequestMapping
public class CompnyController {
	public Successresponse response=new Successresponse();
	@Autowired
	public ICompnyService service;
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome To STOCK MARKET";
	}
	
	
	@GetMapping("/")
	public String getMessage() {
		return "welcome";
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	public ResponseEntity<Successresponse> addCompny(@RequestBody Compny compny) throws TurnOverCheckException {
		String msg = "";
		System.out.println("aaaa");
		msg = service.saveCompny(compny);
		ResponseEntity<Successresponse> res = new ResponseEntity<Successresponse>(new Successresponse(msg, 200),
				HttpStatus.OK);
		return res;

	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/info/{compnycode}")
	public ResponseEntity<CompnyDetails> getCompnyDeatils(@PathVariable int compnycode) throws CompnyNotFound{
		CompnyDetails details = service.viewCompnyDetails(compnycode);
		System.out.println(details);
		return new ResponseEntity<CompnyDetails>(details, HttpStatus.OK);
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{compnycode}")
	public ResponseEntity<Successresponse> deleteCompny(@PathVariable  int compnycode) {
		String msg = service.deleteCompny(compnycode);
		ResponseEntity<Successresponse> res = new ResponseEntity<Successresponse>(new Successresponse(msg, 200),
				HttpStatus.OK);
		return res;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getall")
	public ResponseEntity<List<CompnyDetails>> viewAll(){
		List<CompnyDetails> all = service.getAll();
		return new ResponseEntity(all,HttpStatus.OK);
		
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get/{compnycode}/{startdate}/{enddate}")
	public ResponseEntity<CompnyStocks> getStockByDate(@PathVariable int compnycode,@PathVariable String startdate,@PathVariable String enddate) throws ParseException {
		System.out.println("startdate->"+startdate);
		System.out.println("enddate->"+enddate);
		CompnyStocks stocks = service.getStockDetailsByDate(compnycode,startdate, enddate);
		
		return new ResponseEntity<>(stocks,HttpStatus.OK);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get")
	public ResponseEntity<List<Compny>>getCompnyDetails() throws ParseException, CompnyNotFound {
		List<Compny> stocks = service.getCompnies();
		return new ResponseEntity<>(stocks,HttpStatus.OK);
		
	}
	
		


	

}
