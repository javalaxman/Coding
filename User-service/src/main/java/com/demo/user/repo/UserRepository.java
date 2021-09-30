package com.demo.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByPnr(String pnr);

	void deleteByPnr(String pnr);

}
