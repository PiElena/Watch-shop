package com.watch.shop.model;

import com.watch.shop.model.entity.Brand;
import com.watch.shop.model.entity.ChildrenWatches;
import com.watch.shop.model.entity.Color;
import com.watch.shop.model.entity.LadiesWatches;
import com.watch.shop.model.entity.MensWatches;
import com.watch.shop.model.entity.Movement;
import com.watch.shop.model.entity.SmartWatches;
import com.watch.shop.model.entity.SportWatches;
import com.watch.shop.model.entity.Type;
import com.watch.shop.model.entity.Watch;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Persistence {
    private final List<Watch> watches = new ArrayList<>();

    {
        watches.add(new SmartWatches(4549526297175l, LocalDate.of(2021, 12, 1), BigDecimal.valueOf(156.68),
                Brand.CASIO, "Vital Series", Color.BLACK, 17.00, 58.00,
                "plastic/resin", Movement.QUARTZ_MULTIFUNCTION, Type.DIGITAL, 69.00));
        watches.add(new LadiesWatches(7613077566930l, LocalDate.of(2021, 12, 1), BigDecimal.valueOf(437.22),
                Brand.BULOVA, "Octava", Color.SILVER_TONE, 10.00, 42.00,
                "stainless steel", Movement.AUTOMATIC, Type.ANALOG, true));
        watches.add(new ChildrenWatches(7610522533479l, LocalDate.of(2021, 12, 15), BigDecimal.valueOf(42.95),
                Brand.FLIK_FLAK, "Green Ahead", Color.MULTICOLOUR, 9.00, 34.00,
                "aluminium", Movement.QUARTZ, Type.ANALOG, true));
        watches.add(new MensWatches(7611608281055l, LocalDate.of(2021, 12, 15), BigDecimal.valueOf(423.80),
                Brand.TISSOT, "Automatics III", Color.BLACK, 9.50, 39.70,
                "stainless steel", Movement.AUTOMATIC, Type.ANALOG, "sapphire", true));
        watches.add(new SportWatches(7611608294185l, LocalDate.of(2021, 12, 1), BigDecimal.valueOf(338.14),
                Brand.TISSOT, "Chrono XL Exclusive", Color.BLACK, 11.00, 45.00,
                "stainless steel", Movement.QUARTZ, Type.ANALOG, 100));
    }

    public List<Watch> getDatabase() {
        return watches;
    }
}
