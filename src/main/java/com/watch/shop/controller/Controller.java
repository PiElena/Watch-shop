package com.watch.shop.controller;

import com.watch.shop.model.WatchesCategory;
import com.watch.shop.model.WatchService;
import com.watch.shop.model.entity.Brand;
import com.watch.shop.model.entity.ChildrenWatches;
import com.watch.shop.model.entity.Color;
import com.watch.shop.model.entity.LadiesWatches;
import com.watch.shop.model.entity.MensWatches;
import com.watch.shop.model.entity.Movement;
import com.watch.shop.model.entity.SmartWatches;
import com.watch.shop.model.entity.SportWatches;
import com.watch.shop.model.entity.Type;
import com.watch.shop.model.entity.Watch;
import com.watch.shop.view.InputHandler;
import com.watch.shop.view.View;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static com.watch.shop.view.Constants.DUPLICATE_MESSAGE;
import static com.watch.shop.view.Constants.ENTER_BARCODE;
import static com.watch.shop.view.Constants.ENTER_BRAND;
import static com.watch.shop.view.Constants.ENTER_CASE_DEPTH;
import static com.watch.shop.view.Constants.ENTER_CASE_WIDTH;
import static com.watch.shop.view.Constants.ENTER_CATEGORY;
import static com.watch.shop.view.Constants.ENTER_COLOR;
import static com.watch.shop.view.Constants.ENTER_DIAMONDS;
import static com.watch.shop.view.Constants.ENTER_GLASS_TYPE;
import static com.watch.shop.view.Constants.ENTER_LUMINESCENT_HANDS;
import static com.watch.shop.view.Constants.ENTER_MATERIAL;
import static com.watch.shop.view.Constants.ENTER_MODEL_NAME;
import static com.watch.shop.view.Constants.ENTER_MOVEMENT;
import static com.watch.shop.view.Constants.ENTER_PRICE;
import static com.watch.shop.view.Constants.ENTER_TYPE;
import static com.watch.shop.view.Constants.ENTER_WATER_RESISTANCE_BOOLEAN;
import static com.watch.shop.view.Constants.ENTER_WATER_RESISTANCE_METERS;
import static com.watch.shop.view.Constants.ENTER_WEIGHT;
import static com.watch.shop.view.Constants.EXIT_MESSAGE;
import static com.watch.shop.view.Constants.FAIL_MESSAGE;
import static com.watch.shop.view.Constants.MAIN_MENU;
import static com.watch.shop.view.Constants.TRY_ANOTHER_MESSAGE;
import static com.watch.shop.view.Constants.YES_FOR_COMPARE;
import static java.lang.String.format;

public class Controller {
    private static final int EXIT_COMMAND = 7;
    private final WatchService watchService;
    private final View view;

    public Controller(WatchService watchService, View view) {
        this.watchService = watchService;
        this.view = view;
    }

    public void run() {
        int command = 0;
        while (command != EXIT_COMMAND) {
            showMenu();
            command = InputHandler.readConsoleInt();
            switch (command) {
                case 1 -> showWatches(watchService.getAllWatches());
                case 2 -> showWatches(watchService.sortPriceWatches());
                case 3 -> showWatches(watchService.sortColorWatches());
                case 4 -> showWatches(watchService.sortReceiptDateWatches());
                case 5 -> view.printMessage(watchService.getAllWatchesPrice().toString());
                case 6 -> watchService.addWatch(readWatchFromConsole());
                case 7 -> view.printMessage(EXIT_MESSAGE);
                default -> view.printMessage(TRY_ANOTHER_MESSAGE);
            }
        }
    }

    private void showWatches(List<Watch> watches) {
        watches.forEach(watch -> view.printMessage(watch.toString()));
    }

    private void showMenu() {
        view.printMessage(MAIN_MENU);
    }

    private Watch readWatchFromConsole() {
        view.printMessage(format(ENTER_CATEGORY, Arrays.toString(WatchesCategory.values())));
        WatchesCategory watchesCategory = WatchesCategory.valueOf(InputHandler.readConsoleString().toUpperCase());
        Watch watch = null;

        switch (watchesCategory) {
            case KID -> watch = createChildrenWatches();
            case WOMAN -> watch = createLadiesWatches();
            case MAN -> watch = createMensWatches();
            case SMART -> watch = createSmartWatches();
            case SPORT -> watch = createSportWatches();
            default -> view.printMessage(FAIL_MESSAGE);
        }
        return watch;
    }

    private <T extends Watch> void fillMainAttributes(T watch) {

        watch.setBarCode(parseBarCode());
        view.printMessage(format(ENTER_BRAND, Arrays.toString(Brand.values())));
        watch.setBrand(Brand.valueOf(InputHandler.readConsoleString()));
        view.printMessage(ENTER_MODEL_NAME);
        watch.setModelName(InputHandler.readConsoleString());
        view.printMessage(ENTER_PRICE);
        watch.setPrice(BigDecimal.valueOf(Double.parseDouble(InputHandler.readConsoleString())));
        view.printMessage(format(ENTER_COLOR, Arrays.toString(Color.values())));
        watch.setColor(Color.valueOf(InputHandler.readConsoleString()));
        view.printMessage(ENTER_CASE_DEPTH);
        watch.setCaseDepthApprox(Double.parseDouble(InputHandler.readConsoleString()));
        view.printMessage(ENTER_CASE_WIDTH);
        watch.setCaseWidthApprox(Double.parseDouble(InputHandler.readConsoleString()));
        view.printMessage(ENTER_MATERIAL);
        watch.setPrimaryMaterial(InputHandler.readConsoleString());
        view.printMessage(format(ENTER_MOVEMENT, Arrays.toString(Movement.values())));
        watch.setMovement(Movement.valueOf(InputHandler.readConsoleString()));
        view.printMessage(format(ENTER_TYPE, Arrays.toString(Type.values())));
        watch.setType(Type.valueOf(InputHandler.readConsoleString()));
        watch.setReceiptDate(LocalDate.now());
    }

    private long parseBarCode() {
        long barCode = 0;
        while (barCode == 0) {
            view.printMessage(ENTER_BARCODE);
            String barCodeString = InputHandler.readConsoleString();
            try {
                barCode = Long.parseLong(barCodeString);
            } catch (NumberFormatException e) {
                view.printMessage(FAIL_MESSAGE);
            }
            if (!watchService.validateBarCode(barCode)) {
                view.printMessage(DUPLICATE_MESSAGE);
                barCode = 0;
            }
        }
        return barCode;
    }

    private Watch createChildrenWatches() {
        ChildrenWatches watch = new ChildrenWatches();
        fillMainAttributes(watch);
        view.printMessage(ENTER_WATER_RESISTANCE_BOOLEAN);
        boolean isWaterResistance = InputHandler.readConsoleString().equalsIgnoreCase(YES_FOR_COMPARE);
        watch.setWaterResistance(isWaterResistance);
        return watch;
    }


    private Watch createLadiesWatches() {
        LadiesWatches watch = new LadiesWatches();
        fillMainAttributes(watch);
        view.printMessage(ENTER_DIAMONDS);
        boolean hasDiamonds = InputHandler.readConsoleString().equalsIgnoreCase(YES_FOR_COMPARE);
        watch.setHasDiamonds(hasDiamonds);
        return watch;
    }

    private Watch createMensWatches() {
        MensWatches watch = new MensWatches();
        fillMainAttributes(watch);
        view.printMessage(ENTER_GLASS_TYPE);
        watch.setGlass(InputHandler.readConsoleString());
        view.printMessage(ENTER_LUMINESCENT_HANDS);
        boolean hasLuminescentHands = InputHandler.readConsoleString().equalsIgnoreCase(YES_FOR_COMPARE);
        watch.setHasLuminescentHands(hasLuminescentHands);
        return watch;
    }

    private Watch createSmartWatches() {
        SmartWatches watch = new SmartWatches();
        fillMainAttributes(watch);
        view.printMessage(ENTER_WEIGHT);
        double weight = Double.parseDouble(InputHandler.readConsoleString());
        watch.setWeight(weight);
        return watch;
    }

    private Watch createSportWatches() {
        SportWatches watch = new SportWatches();
        fillMainAttributes(watch);
        view.printMessage(ENTER_WATER_RESISTANCE_METERS);
        watch.setWaterResistanceMeters(Integer.parseInt(InputHandler.readConsoleString()));
        return watch;
    }
}
