package com.watch.shop.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MensWatches extends Watch {
    private String glass;
    private boolean luminescentHands;

    public MensWatches(long barCode, LocalDate receiptDate, BigDecimal price, Brand brand, String modelName, Color color,
                       double caseDepthApprox, double caseWidthApprox, String primaryMaterial, Movement movement,
                       Type type, String glass, boolean luminescentHands) {
        super(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox, caseWidthApprox, primaryMaterial,
                movement, type);
        this.glass = glass;
        this.luminescentHands = luminescentHands;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public boolean isLuminescentHands() {
        return luminescentHands;
    }

    public void setLuminescentHands(boolean luminescentHands) {
        this.luminescentHands = luminescentHands;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Category: for him, glass: %s, luminescent hands: %s \n",
                getGlass(), isLuminescentHands() ? "yes" : "no");
    }
}
