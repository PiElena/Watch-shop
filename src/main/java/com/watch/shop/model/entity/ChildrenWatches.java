package com.watch.shop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ChildrenWatches extends Watch {
    private boolean waterResistance;

    public ChildrenWatches(long barCode, LocalDate receiptDate, BigDecimal price, Brand brand, String modelName,
                           Color color, double caseDepthApprox, double caseWidthApprox, String primaryMaterial,
                           Movement movement, Type type, boolean waterResistance) {
        super(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox, caseWidthApprox, primaryMaterial,
                movement, type);
        this.waterResistance = waterResistance;
    }

    public boolean isWaterResistance() {
        return waterResistance;
    }

    public void setWaterResistance(boolean waterResistance) {
        this.waterResistance = waterResistance;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Category: for kids, water resistance: %s \n",
                isWaterResistance() ? "yes" : "no");
    }
}
