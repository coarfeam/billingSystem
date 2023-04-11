package com.eamapp.billingSystem.model.service;

import com.eamapp.billingSystem.model.entity.Customer;
import com.eamapp.billingSystem.model.repository.ICustomerDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{

    private final ICustomerDao customerDao;

    public CustomerServiceImpl (ICustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> listCustomers() {
        return customerDao.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }
}
