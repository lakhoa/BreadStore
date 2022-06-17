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
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;

    @Column(name = "created_date",updatable = false)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("date")
    private LocalDateTime createdDate;

    @Column(name = "amounts")
    private double total_price;

    public Orders() {

    }

    public Orders(Long id, LocalDateTime createdDate, double total_price) {
        this.id = id;
        this.createdDate = createdDate;
        this.total_price = total_price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "OrderItemDetail",
            joinColumns = { @JoinColumn(name = "orderId") },
            inverseJoinColumns = { @JoinColumn(name = "orderItemId") })
    private List<OrderItemDetail> orderItems = new ArrayList<>();

    public List<OrderItemDetail> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDetail> orderItems) {
        this.orderItems = orderItems;
    }
}

