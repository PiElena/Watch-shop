package com.watch.shop.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DBLyaer implements ModelLyaer {
    @Override
    public ArrayList<Watch> getAllWatches() {
        return DB.db;
    }

    @Override
    public List<Watch> sortPriceWatches() {
        return DB.db.stream()
                .sorted(Comparator.comparing(Watch::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Watch> sortColorWatches() {
        return DB.db.stream()
                .sorted(Comparator.comparing(Watch::getColor))
                .collect(Collectors.toList());
    }

    @Override
    public List<Watch> sortReceiptDateWatches() {
        return DB.db.stream()
                .sorted(Comparator.comparing(Watch::getReceiptDate))
                .collect(Collectors.toList());
    }

}
