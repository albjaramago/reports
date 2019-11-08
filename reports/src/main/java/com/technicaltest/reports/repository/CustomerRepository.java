package com.technicaltest.reports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.technicaltest.reports.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
