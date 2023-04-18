package com.monocept.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.monocept.entity.*;

public interface BankRepository extends JpaRepository<Bank, Integer> {

//	@Query("select u from Bank u")
//	List<Bank> findAll();
}
