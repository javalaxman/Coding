package com.demo.flight.service;

import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.flight.model.Flight;
import com.demo.flight.model.User;
import com.demo.flight.repo.FlightRepo;
import com.demo.flight.repo.FlightRepository;

@Service
public class FlightService {

	@Autowired
	FlightRepo flightRepo; 
	
	@Autowired
	FlightRepository flightRepository;
	public User bookTicket(User user) {
		// TODO Auto-generated method stub
		SecureRandom random = new SecureRandom();
		int num = random.nextInt(100000);
		String pnr = String.format("%05d", num);
		user.setPnr(pnr);
		return flightRepo.save(user);
	}
	public List<Flight> searchFlight(String startDate, String endDate) {
		
		return flightRepository.findByDate(startDate,endDate);
	}

	
}
