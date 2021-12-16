package com.watch.shop.model;

import java.time.LocalDate;

public class SmartWatches extends Watch {
    private double weight;

    public SmartWatches(long barCode, LocalDate receiptDate, double price, String brand, String modelName, String color,
                        double caseDepthApprox, double caseWidthApprox, String primaryMaterial, String movement,
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
}
