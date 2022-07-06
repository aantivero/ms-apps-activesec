package com.aantivero.kafka.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Stock extends PanacheEntity {

    public String code;
    public int price;
}
