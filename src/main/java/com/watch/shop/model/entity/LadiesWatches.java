package com.watch.shop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LadiesWatches extends Watch {
    private boolean hasDiamonds;

    public LadiesWatches() {}

    public LadiesWatches(long barCode, LocalDate receiptDate, BigDecimal price, Brand brand, String modelName,
                         Color color, double caseDepthApprox, double caseWidthApprox, String primaryMaterial,
                         Movement movement, Type type, boolean diamonds) {
        super(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox, caseWidthApprox, primaryMaterial,
                movement, type);
        this.hasDiamonds = diamonds;
    }

    public boolean isHasDiamonds() {
        return hasDiamonds;
    }

    public void setHasDiamonds(boolean hasDiamonds) {
        this.hasDiamonds = hasDiamonds;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Category: for her, diamonds: %s \n",
                isHasDiamonds() ? "yes" : "no");
    }
}
