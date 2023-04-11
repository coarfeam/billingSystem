package com.eamapp.billingSystem.model.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "item_invoice")
public class ItemInvoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    public Double calculateAmount(){

        return quantity * product.getPrice();
    }

    @Serial
    private static final long serialVersionUID = 6145042566727901778L;
}
