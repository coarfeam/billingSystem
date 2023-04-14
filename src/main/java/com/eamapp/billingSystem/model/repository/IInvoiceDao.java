package com.eamapp.billingSystem.model.repository;

import com.eamapp.billingSystem.model.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IInvoiceDao extends JpaRepository<Invoice, Long> {
    @Query("select f from Invoice f join fetch f.customer c join fetch f.itemInvoices i join fetch i.product where f.id = ?1")
    public Invoice findByALL(Long id);
}
