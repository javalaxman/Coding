package com.demo.admin.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.admin.model.Coupon;
import com.demo.admin.model.Flight;
import com.demo.admin.repo.AdminRepository;
import com.demo.admin.repo.CouponRepository;
import com.demo.admin.repo.FlightRepository;

@Service
public class AdminService {
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	CouponRepository couponRepository;
	
	public String login(String name,String pwd) {
		if(adminRepository.validateAdmin(name,pwd)!=0) {
			return "Login Successfully";
		}
		return "Invalid Credential";
	}
	public Flight addNewFlight(Flight flight) {
		return flightRepository.save(flight);
	}
	
	public List<Flight> getFlights(){
		System.out.println("Local time:"+LocalDateTime.now());
		return flightRepository.findAll();
	}
	public String updateFlightStatus(int flightNo,String status) {
		Flight existingFlight=flightRepository.findByFlightNo(flightNo);
		existingFlight.setStatus(status);
		if(flightRepository.save(existingFlight)!=null)
			return "Flight status updated to :"+status;
		else
			return "Flight not updated";
	}
	public Flight updateFlight(Flight flight) throws Exception {
		Flight existingFlight=flightRepository.findByFlightNo(flight.getFlightNo());
//		existingFlight.setStartDate(flight.getStartDate());
//		existingFlight.setEndDate(flight.getEndDate());
		existingFlight=flight;
		flightRepository.save(existingFlight);
		return existingFlight;
	}
	@Transactional
	public String delete(int flightNo) {
		if(flightRepository.deleteByFlightNo(flightNo)!=0)
			return "Flight Deleted success fully";
		else
			return "Flight details not deleted";
	}
	public Coupon addNewCoupon(Coupon coupon) {
		
		return couponRepository.save(coupon);
	}
	public Coupon updateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		Coupon c=couponRepository.getById(coupon.getId());
		c=coupon;
		couponRepository.save(c);
		return coupon;
	}
	public List<Coupon> getAllCoupon() {
		// TODO Auto-generated method stub
		return couponRepository.findAll();
	}
	public Coupon deleteCoupon(int id) {
		Coupon c=couponRepository.getById(id);
		couponRepository.deleteById(id);
		return c;
	}
}
