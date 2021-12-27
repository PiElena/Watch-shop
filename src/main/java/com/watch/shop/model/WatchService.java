package com.watch.shop.model;

import com.watch.shop.model.entity.Watch;

import java.math.BigDecimal;
import java.util.List;

public interface WatchService {
    List<Watch> getAllWatches();

    List<Watch> sortPriceWatches();

    List<Watch> sortColorWatches();

    List<Watch> sortReceiptDateWatches();

    BigDecimal getAllWatchesPrice();

    void addWatch(Watch watch);

    boolean validateBarCode(long barCode);
}
