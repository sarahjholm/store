package com.project.store.Model;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@Table(name="PRICES")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_list")
    private int priceList;

    @Column(name = "base_price")
    private int basePrice;

    @Column(name = "start_date", columnDefinition = "DATETIME")
    private LocalDateTime startDate;

    @Column(name = "end_date", columnDefinition = "DATETIME")
    private LocalDateTime endDate;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "priority")
    private int priority;

    @Column(name = "price")
    private double price;

    @Column(name = "curr")
    private String curr;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="brands_id")
    private Brands brands;
    
}
