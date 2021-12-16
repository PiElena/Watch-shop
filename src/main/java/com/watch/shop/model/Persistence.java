package com.watch.shop.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Persistence {
    static ArrayList<Watch> watches = new ArrayList<>();

    static {
        watches.add(new SmartWatches(4549526297175l, LocalDate.of(2021, 12, 1), 156.68,
                "Casio", "Vital Series", "black", 17.00, 58.00,
                "plastic/resin", "quartz multifunction", Type.DIGITAL, 69.00));
        watches.add(new LadiesWatches(7613077566930l, LocalDate.of(2021, 12, 1), 437.22,
                "Bulova", "Octava", "silver", 10.00, 42.00,
                "stainless steel", "automatic", Type.ANALOG, true));
        watches.add(new ChildrensWatches(7610522533479l, LocalDate.of(2021, 12, 15), 42.95,
                "Flik Flak", "Green Ahead", "multiColour", 9.00, 34.00,
                "aluminium", "quartz", Type.ANALOG, true));
        watches.add(new MensWatches(7611608281055l, LocalDate.of(2021, 12, 15), 423.80,
                "Tissot", "Automatics III", "black", 9.50, 39.70,
                "stainless steel", "automatic", Type.ANALOG, "sapphire", true));
        watches.add(new SportWatches(7611608294185l, LocalDate.of(2021, 12, 1), 338.14,
                "Tissot", "Chrono XL Exclusive", "black", 11.00, 45.00,
                "stainless steel", "quartz", Type.ANALOG, 100));
    }
}
