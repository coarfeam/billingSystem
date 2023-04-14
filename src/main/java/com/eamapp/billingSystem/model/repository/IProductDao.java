package com.eamapp.billingSystem.model.repository;

import com.eamapp.billingSystem.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductDao extends JpaRepository<Product, Long> {
    //findByName
    @Query("select p from Product p where p.name like %?1%")
    public Product findByName(String name);
}
