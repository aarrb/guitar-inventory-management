package edu.iu.aurabaza.Homework2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "guitars_inventory", name = "guitars")
public class Guitar {
    // Local variables
    @Id
    private String serialNumber;
    private String model;
    private double price;
    private Builder builder;
    private Type type;
    private Wood backWood, topWood;

    public Guitar() {
    }

    // Constructor
    public Guitar(String serialNumber, double price, Builder builder, String model, Type type, Wood backWood, Wood topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }

    // Getters
    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }

    // Setters
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setBackWood(Wood backWood) {
        this.backWood = backWood;
    }

    public void setTopWood(Wood topWood) {
        this.topWood = topWood;
    }
}