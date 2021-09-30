package com.demo.flight.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.flight.model.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("select f from Flight f where f.startDate>=:startDate AND f.endDate<=:endDate")
	List<Flight> findByDate(String startDate, String endDate);

}
