package com.demo.flight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.flight.model.User;

public interface FlightRepo extends JpaRepository<User, Integer> {

}
