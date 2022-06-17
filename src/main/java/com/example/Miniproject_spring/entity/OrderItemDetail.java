package com.example.Miniproject_spring.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OrderItemDetail")
public class OrderItemDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "Product",
            joinColumns = { @JoinColumn(name = "orderItemId") },
            inverseJoinColumns = { @JoinColumn(name = "productId") })
    private Product products = new Product();


    @Column(name = "quantity")
    private int quantity;

    @Column(name = "priceItem")
    private double price;


    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public OrderItemDetail() {
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public OrderItemDetail(Long id, Product products, int quantity, double price, List<ToppingItemDetail> toppingItemDetails) {
        this.id = id;
        this.products = products;
        this.quantity = quantity;
        this.price = price;
        this.toppingItemDetails = toppingItemDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ToppingItemDetail",
            joinColumns = { @JoinColumn(name = "itemId") },
            inverseJoinColumns = { @JoinColumn(name = "toppingItemId") })
    private List<ToppingItemDetail> toppingItemDetails = new ArrayList<>();

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ToppingItemDetail> getToppingItemDetails() {
        return toppingItemDetails;
    }

    public void setToppingItemDetails(List<ToppingItemDetail> toppingItemDetails) {
        this.toppingItemDetails = toppingItemDetails;
    }
}
