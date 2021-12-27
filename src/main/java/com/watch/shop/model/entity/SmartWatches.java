package com.watch.shop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SmartWatches extends Watch {
    private double weight;

    public SmartWatches() {}

    public SmartWatches(long barCode, LocalDate receiptDate, BigDecimal price, Brand brand, String modelName, Color color,
                        double caseDepthApprox, double caseWidthApprox, String primaryMaterial, Movement movement,
                        Type type, double weight) {
        super(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox, caseWidthApprox, primaryMaterial,
                movement, type);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Category: smart, weight: %.2f \n", getWeight());
    }
}
