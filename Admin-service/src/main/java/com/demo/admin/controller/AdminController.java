package com.demo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.admin.model.Coupon;
import com.demo.admin.model.Flight;
import com.demo.admin.service.AdminService;

@RestController
public class AdminController {
	@Autowired
	AdminService adminService;

	/*
	 * @GetMapping("/hello") public String greet() { return "Admin controller"; }
	 */

	@GetMapping("/login/{name}/{pwd}")
	public String login(@PathVariable String name, @PathVariable String pwd) {
		System.out.println(name + " =" + pwd);
		return adminService.login(name, pwd);
	}

	@PostMapping("/create")
	public Flight addNewFlight(@RequestBody Flight flight) {
		return adminService.addNewFlight(flight);
	}

	@GetMapping("/")
	public List<Flight> getAllFlights() {
		return adminService.getFlights();
	}

	@PutMapping("/updateStatus/{flightNo}/{status}")
	public String update(@PathVariable int flightNo, @PathVariable String status) {
		return adminService.updateFlightStatus(flightNo, status);
	}

	@PutMapping("/updateFlight")
	@ResponseBody
	public Flight update(@RequestBody Flight flight) throws Exception {
		return adminService.updateFlight(flight);
	}

	@DeleteMapping("/deleteFlight/{flightNo}")
	public String delete(@PathVariable int flightNo) throws Exception {
		return adminService.delete(flightNo);
	}

	// create coupon
	@PostMapping("/addCoupon")
	public Coupon addCoupon(@RequestBody Coupon coupon) {
		return adminService.addNewCoupon(coupon);
	}

	// update coupon
	@PutMapping("/updateCoupon")
	public Coupon updateCoupon(@RequestBody Coupon coupon) {
		return adminService.updateCoupon(coupon);
	}

	// update coupon
	@GetMapping("/getAllCoupon")
	public List<Coupon> viewCoupon() {
		return adminService.getAllCoupon();
	}
	
	@DeleteMapping("/deleteCoupon/{id}")
	public Coupon deleteCoupon(@PathVariable int id) {
		return adminService.deleteCoupon(id);
	}
}
