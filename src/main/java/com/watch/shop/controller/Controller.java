package com.watch.shop.controller;

import com.watch.shop.model.DBLyaer;
import com.watch.shop.model.ModelLyaer;
import com.watch.shop.view.ConsoleView;
import com.watch.shop.view.View;

public class Controller {
    ModelLyaer modelLyaer = new DBLyaer();
    View view = new ConsoleView();
    public void execute() {
        view.showWatches(modelLyaer.sortPriceWatches());
    }
}
