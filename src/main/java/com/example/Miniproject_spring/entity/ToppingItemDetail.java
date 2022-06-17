package com.example.Miniproject_spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ToppingItemDetail")
public class ToppingItemDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Topping",
            joinColumns = { @JoinColumn(name = "toppingItemId") },
            inverseJoinColumns = { @JoinColumn(name = "toppingId") })
    private Topping toppings = new Topping();

    public Topping getToppings() {
        return toppings;
    }

    public void setToppings(Topping toppings) {
        this.toppings = toppings;
    }

    public void setQuantityTopping(int quantityTopping) {
        this.quantityTopping = quantityTopping;
    }

    public void setPriceUnit(double priceUnit) {
        this.priceUnit = priceUnit;
    }

    @Column(name = "quantity")
    private int quantityTopping;

    @Column(name = "priceUnit")
    private double priceUnit;

    public ToppingItemDetail() {
    }

    public ToppingItemDetail(Long id, Topping toppings, int quantityTopping, double priceUnit) {
        this.id = id;
        this.toppings = toppings;
        this.quantityTopping = quantityTopping;
        this.priceUnit = priceUnit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantityTopping() {
        return quantityTopping;
    }

    public double getPriceUnit() {
        return priceUnit;
    }
}



