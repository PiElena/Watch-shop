package com.watch.shop.view;

import com.watch.shop.model.Watch;

import java.util.List;

public interface View {
    //methods
    void showWatches(List<Watch> watches);
    void showPrices(List<Watch> prices);
}
