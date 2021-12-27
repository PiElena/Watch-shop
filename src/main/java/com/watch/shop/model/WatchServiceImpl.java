package com.watch.shop.model;

import com.watch.shop.model.entity.Watch;

import java.math.BigDecimal;
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
    public BigDecimal getAllWatchesPrice() {
        return repository.stream()
                .map(Watch::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void addWatch(Watch watch) {
        if (watch != null) {
            repository.add(watch);
        }
    }

    public boolean validateBarCode(long barCode) {
        return repository.stream()
                .noneMatch(watch -> watch.getBarCode() == barCode);
    }
}
