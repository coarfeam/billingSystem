package com.eamapp.billingSystem.model.service;

import com.eamapp.billingSystem.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
public List<Customer> listCustomers();
public void saveCustomer(Customer customer);
public Customer getCustomerById(Long id);
public Customer updateCustomer(Customer customer);
public void deleteCustomer(Long id);
}
