package com.watch.shop.controller;

import com.watch.shop.model.WatchService;
import com.watch.shop.model.entity.Watch;
import com.watch.shop.view.InputHandler;
import com.watch.shop.view.View;

import java.util.List;

import static com.watch.shop.view.Constants.EXIT_MESSAGE;
import static com.watch.shop.view.Constants.FAIL_MESSAGE;
import static com.watch.shop.view.Constants.MAIN_MENU;

public class Controller {
    private static final int EXIT_COMMAND = 6;
    private final WatchService watchService;
    private final View view;

    public Controller(WatchService watchService, View view) {
        this.watchService = watchService;
        this.view = view;
    }

    public void run() {
        showMenu();
        int command = 0;
        while (command != EXIT_COMMAND) {
            command = InputHandler.readConsoleInt();
            switch (command) {
                case 1 -> showWatches(watchService.getAllWatches());
                case 2 -> showWatches(watchService.sortPriceWatches());
                case 3 -> showWatches(watchService.sortColorWatches());
                case 4 -> showWatches(watchService.sortReceiptDateWatches());
//                case 5 -> showPrices(watchService.getAllWatches());
                case 6 -> view.printMessage(EXIT_MESSAGE);
                default -> view.printMessage(FAIL_MESSAGE);
            }
        }
    }

    private void showWatches(List<Watch> watches) {
        watchService.getAllWatches().forEach(watch -> view.printMessage(watch.toString()));
    }

    private void showMenu() {
        view.printMessage(MAIN_MENU);
    }
}
