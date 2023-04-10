package com.eamapp.billingSystem.model.service;

import com.eamapp.billingSystem.model.entity.Customer;
import com.eamapp.billingSystem.model.repository.ICustomerDao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{

    private ICustomerDao customerDao;

    public CustomerServiceImpl (ICustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> listCustomers() {
        return customerDao.findAll();
    }
}
