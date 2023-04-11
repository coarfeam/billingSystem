package com.eamapp.billingSystem.model.service;

import com.eamapp.billingSystem.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
public List<Customer> listCustomers();
public void saveCustomer(Customer customer);
}
