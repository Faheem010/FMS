package com.example.flatsmangmentsystem;

public class ExpenseModel {
    private String typeExpanse;
    private String price;

    public ExpenseModel(String typeExpanse, String price) {
        this.typeExpanse = typeExpanse;
        this.price = price;
    }

    public String getTypeExpanse() {
        return typeExpanse;
    }

    public void setTypeExpanse(String typeExpanse) {
        this.typeExpanse = typeExpanse;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ExpenseModel{" +
                "typeExpanse='" + typeExpanse + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
