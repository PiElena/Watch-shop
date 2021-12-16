package com.watch.shop.view;

import com.watch.shop.model.Watch;

import java.util.List;

public interface View {
    void showWatches(List<Watch> watches);

    void showPrices(List<Watch> prices);
}
