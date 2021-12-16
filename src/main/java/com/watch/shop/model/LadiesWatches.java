package com.watch.shop.model;

import java.time.LocalDate;

public class LadiesWatches extends Watch {
    private boolean diamonds;

    public LadiesWatches(long barCode, LocalDate receiptDate, double price, String brand, String modelName,
                         String color, double caseDepthApprox, double caseWidthApprox, String primaryMaterial,
                         String movement, Type type, boolean diamonds) {
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
}
