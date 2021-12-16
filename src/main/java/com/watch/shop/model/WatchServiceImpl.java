package com.watch.shop.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WatchServiceImpl implements WatchService {
    @Override
    public ArrayList<Watch> getAllWatches() {
        return Persistence.watches;
    }

    @Override
    public List<Watch> sortPriceWatches() {
        return Persistence.watches.stream()
                .sorted(Comparator.comparing(Watch::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Watch> sortColorWatches() {
        return Persistence.watches.stream()
                .sorted(Comparator.comparing(Watch::getColor))
                .collect(Collectors.toList());
    }

    @Override
    public List<Watch> sortReceiptDateWatches() {
        return Persistence.watches.stream()
                .sorted(Comparator.comparing(Watch::getReceiptDate))
                .collect(Collectors.toList());
    }

}
