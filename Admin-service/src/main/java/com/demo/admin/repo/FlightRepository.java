package com.demo.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.admin.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
	/*
	 * @Modifying
	 * 
	 * @Query("update flight f set f.status=:status where f.flightNo=:flightNo")
	 * public int updateFlightStatus(@Param("flightNo")String
	 * flightNo,@Param("status")String status);
	 */

	public Flight findByFlightNo(int flightNo);

	public int deleteByFlightNo(int flightNo);

}
