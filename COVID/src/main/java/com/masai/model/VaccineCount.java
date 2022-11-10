package com.masai.model;

public class VaccineCount {

    private Integer quantity;
    private Double price;


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public VaccineCount(Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }


    public VaccineCount() {
    }

    @Override
    public String toString() {
        return "VaccineCount{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
