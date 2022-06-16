package com.example.Miniproject_spring.service.DTO;

public class RequestDto <T>{
    long idAdd;
    T item;

    public long getIdAdd() {
        return idAdd;
    }

    public void setIdAdd(long idAdd) {
        this.idAdd = idAdd;
    }

    int quantity;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public RequestDto(long idAdd, T item, int quantity) {
        this.idAdd = idAdd;
        this.item = item;
        this.quantity = quantity;
    }
}
