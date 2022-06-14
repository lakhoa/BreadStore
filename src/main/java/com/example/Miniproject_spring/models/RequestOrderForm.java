package com.example.Miniproject_spring.models;

import java.util.List;

public class RequestOrderForm {

    List<OrderItem> orderItemAll;
    String note;

    public RequestOrderForm(List<OrderItem> orderItemAll, String note) {
        this.orderItemAll = orderItemAll;
        this.note = note;
    }

    public List<OrderItem> getOrderItemAll() {
        return orderItemAll;
    }

    public void setOrderItemAll(List<OrderItem> orderItemAll) {
        this.orderItemAll = orderItemAll;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}


