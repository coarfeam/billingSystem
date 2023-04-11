package com.eamapp.billingSystem.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "product",
        indexes = @Index(name = "index_name", columnList = "name", unique = true))
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double price;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_at")
    private Date createAt;
    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }


    @Serial
    private static final long serialVersionUID = -2635048908380552448L;
}
