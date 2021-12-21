package com.watch.shop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LadiesWatches extends Watch {
    private boolean diamonds;

    public LadiesWatches(long barCode, LocalDate receiptDate, BigDecimal price, Brand brand, String modelName,
                         Color color, double caseDepthApprox, double caseWidthApprox, String primaryMaterial,
                         Movement movement, Type type, boolean diamonds) {
        super(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox, caseWidthApprox, primaryMaterial,
                movement, type);
        this.diamonds = diamonds;
    }

    public boolean isDiamonds() {
        return diamonds;
    }

    public void setDiamonds(boolean diamonds) {
        this.diamonds = diamonds;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Category: for her, diamonds: %s \n",
                isDiamonds() ? "yes" : "no");
    }
}
