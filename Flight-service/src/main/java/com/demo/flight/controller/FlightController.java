package com.demo.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.flight.model.Flight;
import com.demo.flight.model.User;
import com.demo.flight.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@PostMapping("/bookFlight")
	//@ResponseBody
	public User bookFlight(@RequestBody User user) {
		return flightService.bookTicket(user);
	}
	
	@GetMapping("/search/{startDate}/{endDate}")
	public List<Flight> search(@PathVariable String startDate,@PathVariable String endDate){
		return flightService.searchFlight(startDate,endDate);
	}
}
