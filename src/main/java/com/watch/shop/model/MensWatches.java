package com.watch.shop.model;

import java.time.LocalDate;

public class MensWatches extends Watch {
    private String glass;
    private boolean luminescentHands;

    public MensWatches(long barCode, LocalDate receiptDate, double price, String brand, String modelName, String color,
                       double caseDepthApprox, double caseWidthApprox, String primaryMaterial, String movement,
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
}
