package com.example.Miniproject_spring.models;

import java.util.List;

public class RequestOrderForm {

    List<OrderItem> orderItems;
    String note;

    public RequestOrderForm(List<OrderItem> orderItemAll, String note) {
        this.orderItems = orderItemAll;
        this.note = note;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}


