package com.watch.shop.model;

import java.time.LocalDate;

public class SportWatches extends Watch {
    private int waterResistanceMeters;

    public SportWatches(long barCode, LocalDate receiptDate, double price, String brand, String modelName, String color,
                        double caseDepthApprox, double caseWidthApprox, String primaryMaterial, String movement,
                        Type type, int waterResistanceMeters) {
        super(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox, caseWidthApprox, primaryMaterial,
                movement, type);
        this.waterResistanceMeters = waterResistanceMeters;
    }

    public int getWaterResistanceMeters() {
        return waterResistanceMeters;
    }

    public void setWaterResistanceMeters(int waterResistanceMeters) {
        this.waterResistanceMeters = waterResistanceMeters;
    }
}
