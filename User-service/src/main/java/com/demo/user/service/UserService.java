package com.demo.user.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.exception.handle.DataNotFoundException;
import com.demo.user.model.User;
import com.demo.user.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	public User create(User user) {
		return userRepository.save(user);
	}
	@Transactional
	public User deleteTicket(String pnr) {
		// TODO Auto-generated method stub
		User u1=userRepository.findByPnr(pnr);
		
		userRepository.deleteByPnr(pnr);
		return u1;
	}
	@Cacheable(key="#pnr",value="user")
	public User viewTicket(String pnr) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Local time:"+LocalDateTime.now());
		User userdetails=userRepository.findByPnr(pnr);
		if(userdetails!=null)
		return userdetails;
		else
			throw new DataNotFoundException("Invalid Pnr number");
	}
}
