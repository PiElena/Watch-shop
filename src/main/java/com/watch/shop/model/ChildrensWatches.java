package com.watch.shop.model;

import java.time.LocalDate;

public class ChildrensWatches extends Watch {
    private boolean waterResistance;

    public ChildrensWatches(long barCode, LocalDate receiptDate, double price, String brand, String modelName,
                            String color, double caseDepthApprox, double caseWidthApprox, String primaryMaterial,
                            String movement, Type type, boolean waterResistance) {
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
}
