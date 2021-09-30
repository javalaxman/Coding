package com.demo.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.admin.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

	

}
