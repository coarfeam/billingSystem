package com.eamapp.billingSystem.model.repository;

import com.eamapp.billingSystem.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerDao extends JpaRepository<Customer, Long> {

}
