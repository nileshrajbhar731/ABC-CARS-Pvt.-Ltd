package com.lithan.ABC_Cars_Pte_Ltd.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lithan.ABC_Cars_Pte_Ltd.dto.Car;
import com.lithan.ABC_Cars_Pte_Ltd.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByMailid(String name);

	Optional<User> findByUserName(String username);

	@Query("SELECT p FROM User p WHERE CONCAT(p.userName) LIKE %?1%")
	public User search(String keyword);

	

	
	
}
