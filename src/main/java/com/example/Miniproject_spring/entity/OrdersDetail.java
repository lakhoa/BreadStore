package com.example.Miniproject_spring.entity;

import javax.persistence.*;

@Entity
@Table(name = "Orders_detail")
public class OrdersDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "quantity")
    private int quantity;


    @ManyToOne
    @JoinColumn(name = "Orders_Id")
    Orders orders;

    @ManyToOne
    @JoinColumn(name = "productId")
    Product product;

    public OrdersDetail() {
    }

    public OrdersDetail(Long id, Orders orders, Product product) {
        this.id = id;
        this.orders = orders;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
