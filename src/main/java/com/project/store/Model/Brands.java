package com.project.store.Model;

import javax.persistence.*;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
@Table(name="BRANDS")
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brands_id")
    private int brandsId;

    @Column(name = "name")
    private String name;
}
