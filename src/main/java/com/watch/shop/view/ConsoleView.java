package com.watch.shop.view;

import com.watch.shop.model.*;

import java.util.List;

public class ConsoleView implements View {
    @Override
    public void showWatches(List<Watch> watches) {
        for (Watch watch:watches) {
            System.out.printf("""
                            Watch %d Brand %s, model %s, price %,.2f,\s
                             movement: %s, analog/digital: %s, color: %s, primary material: %s case depth: %.2f, case width: %.2f\s
                             receipt date: %s\s
                            """,
                    watch.getBarCode(), watch.getBrand(), watch.getModelName(), watch.getPrice(), watch.getMovement(),
                    watch.getType(), watch.getColor(), watch.getPrimaryMaterial(), watch.getCaseDepthApprox(),
                    watch.getCaseWidthApprox(), watch.getReceiptDate());
            if (watch instanceof ChildrensWatches) {
                System.out.printf("Сategory: for kids, water resistance: %s \n",
                        ((ChildrensWatches) watch).isWaterResistance() ?"yes":"no");
            }
            if (watch instanceof LadiesWatches) {
                System.out.printf("Сategory: for her, diamonds: %s \n",
                        ((LadiesWatches) watch).isDiamonds() ?"yes":"no");
            }
            if (watch instanceof MensWatches) {
                System.out.printf("Category: for him, glass: %s, luminescent hands: %s \n",
                        ((MensWatches) watch).getGlass(), ((MensWatches) watch).isLuminescentHands() ?"yes":"no");
            }
            if (watch instanceof SmartWatches) {
                System.out.printf("Category: smart, weight: %.2f \n", ((SmartWatches) watch).getWeight());
            }
            if (watch instanceof SportWatches) {
                System.out.printf("Category: sport, water resistance: %d meters \n",
                        ((SportWatches) watch).getWaterResistanceMeters());
            }
            System.out.println();
        }
    }

    @Override
    public void showPrices(List<Watch> watches) {
        System.out.println("Prices:");
        for (Watch watch:watches) {
            System.out.println(watch.getPrice());
        }
    }
}
