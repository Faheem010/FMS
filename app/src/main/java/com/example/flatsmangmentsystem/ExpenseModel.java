package com.example.flatsmangmentsystem;

public class ExpenseModel {

    private String price;
    private String TypeExpnse;

    public ExpenseModel(String typeExpnse, String price) {
        this.TypeExpnse = typeExpnse;
        this.price = price;
    }


    public String getTypeExpnse() {
        return TypeExpnse;
    }

    public void setTypeExpnse(String typeExpnse) {
        TypeExpnse = typeExpnse;
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
                "price='" + price + '\'' +
                ", TypeExpnse='" + TypeExpnse + '\'' +
                '}';
    }
}
