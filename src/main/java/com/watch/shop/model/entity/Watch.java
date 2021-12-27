package com.watch.shop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Watch {
    protected long barCode;
    protected LocalDate receiptDate;
    protected BigDecimal price;
    protected Brand brand;
    protected String modelName;
    protected Color color;
    protected double caseDepthApprox;
    protected double caseWidthApprox;
    protected String primaryMaterial;
    protected Movement movement;
    protected Type type;

    public Watch(long barCode, LocalDate receiptDate, BigDecimal price, Brand brand, String modelName, Color color,
                 double caseDepthApprox, double caseWidthApprox, String primaryMaterial, Movement movement, Type type) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
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

    public Movement getMovement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Watch %d Brand %s, model %s, price %,.2f,\n" +
                        "movement: %s, analog/digital: %s, color: %s, primary material: %s, case depth: %.2f, case width: %.2f\n" +
                        "receipt date: %s\n",
                getBarCode(), getBrand(), getModelName(), getPrice(), getMovement(), getType(), getColor(),
                getPrimaryMaterial(), getCaseDepthApprox(), getCaseWidthApprox(), getReceiptDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Watch watch)) {
            return false;
        }
        return getBarCode() == watch.getBarCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBarCode());
    }
}
