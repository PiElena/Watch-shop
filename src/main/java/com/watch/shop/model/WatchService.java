package com.watch.shop.model;

import java.util.ArrayList;
import java.util.List;

public interface WatchService {
    ArrayList<Watch> getAllWatches();

    List<Watch> sortPriceWatches();

    List<Watch> sortColorWatches();

    List<Watch> sortReceiptDateWatches();
}
