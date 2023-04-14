package com.eamapp.billingSystem.model.service;

import com.eamapp.billingSystem.model.entity.Customer;
import com.eamapp.billingSystem.model.repository.ICustomerDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService{

    private ICustomerDao customerDao;

    public CustomerServiceImpl (ICustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> listCustomers() {
        return customerDao.findAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerDao.findById(id).orElse(null);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerDao.deleteById(id);
    }
}
