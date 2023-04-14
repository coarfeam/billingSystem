package com.eamapp.billingSystem.model.repository;

import com.eamapp.billingSystem.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerDao extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c left join fetch c.invoices f where c.id = ?1")
    public  Customer customerWithInvoice(Long id);
}
