package com.demo.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.admin.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	@Query("SELECT COUNT(*) FROM Admin WHERE username=:username AND password=:password")
	public int validateAdmin(@Param("username") String username,@Param("password") String password);
}
