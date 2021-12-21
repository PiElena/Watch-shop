package com.watch.shop.model;

import com.watch.shop.model.entity.Watch;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WatchServiceImpl implements WatchService {
    private final List<Watch> repository = new Persistence().getDatabase();

    @Override
    public List<Watch> getAllWatches() {
        return Collections.unmodifiableList(repository);
    }

    @Override
    public List<Watch> sortPriceWatches() {
        return repository.stream()
                .sorted(Comparator.comparing(Watch::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public List<Watch> sortColorWatches() {
        return repository.stream()
                .sorted(Comparator.comparing(Watch::getColor))
                .collect(Collectors.toList());
    }

    @Override
    public List<Watch> sortReceiptDateWatches() {
        return repository.stream()
                .sorted(Comparator.comparing(Watch::getReceiptDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Watch> getAllWatchesForSort() {
        return repository;
    }

    @Override
    public void addWatch(Watch watch) {
        if (watch.getBarCode() != 0) {
            new Persistence().setWatchToDatabase(watch);
        }
    }
}
