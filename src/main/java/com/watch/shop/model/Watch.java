package com.watch.shop.model;

import java.time.LocalDate;

public class Watch {
    private long barCode;
    private LocalDate receiptDate;
    private double price;
    private String brand;
    private String modelName;
    private String color;
    private double caseDepthApprox;
    private double caseWidthApprox;
    private String primaryMaterial;
    private String movement;
    private Type type;

    public Watch(long barCode, LocalDate receiptDate, double price, String brand, String modelName, String color,
                 double caseDepthApprox, double caseWidthApprox, String primaryMaterial, String movement, Type type) {
        this.barCode = barCode;
        this.receiptDate = receiptDate;
        this.price = price;
        this.brand = brand;
        this.modelName = modelName;
        this.color = color;
        this.caseDepthApprox = caseDepthApprox;
        this.caseWidthApprox = caseWidthApprox;
        this.primaryMaterial = primaryMaterial;
        this.movement = movement;
        this.type = type;
    }

    public long getBarCode() {
        return barCode;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getCaseDepthApprox() {
        return caseDepthApprox;
    }

    public void setCaseDepthApprox(double caseDepthApprox) {
        this.caseDepthApprox = caseDepthApprox;
    }

    public double getCaseWidthApprox() {
        return caseWidthApprox;
    }

    public void setCaseWidthApprox(double caseWidthApprox) {
        this.caseWidthApprox = caseWidthApprox;
    }

    public String getPrimaryMaterial() {
        return primaryMaterial;
    }

    public void setPrimaryMaterial(String primaryMaterial) {
        this.primaryMaterial = primaryMaterial;
    }

    public String getMovement() {
        return movement;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
