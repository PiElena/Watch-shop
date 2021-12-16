package com.watch.shop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SportWatches extends Watch {
    private int waterResistanceMeters;

    public SportWatches(long barCode, LocalDate receiptDate, BigDecimal price, Brand brand, String modelName, Color color,
                        double caseDepthApprox, double caseWidthApprox, String primaryMaterial, Movement movement,
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

    @Override
    public String toString() {
        return super.toString() + String.format("Category: sport, water resistance: %d meters \n",
                getWaterResistanceMeters());
    }
}
