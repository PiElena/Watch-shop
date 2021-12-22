package com.watch.shop.controller;

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
import java.util.List;
import java.util.stream.Collectors;

import static com.watch.shop.view.Constants.DUPLICATE_MESSAGE;
import static com.watch.shop.view.Constants.ENTER_BRAND;
import static com.watch.shop.view.Constants.ENTER_CATEGORY;
import static com.watch.shop.view.Constants.ENTER_COLOR;
import static com.watch.shop.view.Constants.ENTER_MOVEMENT;
import static com.watch.shop.view.Constants.EXIT_MESSAGE;
import static com.watch.shop.view.Constants.FAIL_MESSAGE;
import static com.watch.shop.view.Constants.MAIN_MENU;
import static com.watch.shop.view.Constants.TRY_ANOTHER_MESSAGE;

public class Controller {
    private static final int EXIT_COMMAND = 7;
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
                case 5 -> watchService.getAllWatchesForSort()
                        .forEach(watch -> view.printMessage(watch.getPrice().toString()));
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
        view.printMessage(ENTER_CATEGORY);
        String category = InputHandler.readConsoleString();
        view.printMessage("Enter the barcode");
        String barCodeString = InputHandler.readConsoleString();
        long barCode;
        try {
            barCode = Long.parseLong(barCodeString);
        } catch (NumberFormatException e) {
            view.printMessage(FAIL_MESSAGE);
            return null;
        }
        List<Watch> checkList = watchService.getAllWatchesForSort().stream()
                .filter(watch -> watch.getBarCode() == barCode)
                .collect(Collectors.toList());
        if (!checkList.isEmpty()) {
            view.printMessage(DUPLICATE_MESSAGE);
            return null;
        }
        view.printMessage(ENTER_BRAND);
        Brand brand = Brand.valueOf(InputHandler.readConsoleString());
        view.printMessage("Enter the modelName:");
        String modelName = InputHandler.readConsoleString();
        view.printMessage("Enter the price:");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(InputHandler.readConsoleString()));
        view.printMessage(ENTER_COLOR);
        Color color = Color.valueOf(InputHandler.readConsoleString());
        view.printMessage("Enter the case depth:");
        double caseDepthApprox = Double.parseDouble(InputHandler.readConsoleString());
        view.printMessage("Enter the case width:");
        double caseWidthApprox = Double.parseDouble(InputHandler.readConsoleString());
        view.printMessage("Enter the primary material:");
        String primaryMaterial = InputHandler.readConsoleString();
        view.printMessage(ENTER_MOVEMENT);
        Movement movement = Movement.valueOf(InputHandler.readConsoleString());
        view.printMessage("Enter the type: ANALOG / DIGITAL");
        Type type = Type.valueOf(InputHandler.readConsoleString());
        LocalDate receiptDate = LocalDate.now();
        switch (category) {
            case "kid" -> {
                view.printMessage("Enter the water resistance: yes / no");
                boolean waterResistance = InputHandler.readConsoleString().equals("yes");
                return new ChildrenWatches(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox,
                        caseWidthApprox, primaryMaterial, movement, type, waterResistance);
            }
            case "woman" -> {
                view.printMessage("Enter the diamonds: yes / no");
                boolean diamonds = InputHandler.readConsoleString().equals("yes");
                return new LadiesWatches(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox,
                        caseWidthApprox, primaryMaterial, movement, type, diamonds);
            }
            case "man" -> {
                view.printMessage("Enter the kind of glass:");
                String glass = InputHandler.readConsoleString();
                view.printMessage("Enter the luminescent hands: yes / no");
                boolean luminescentHands = InputHandler.readConsoleString().equals("yes");
                return new MensWatches(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox,
                        caseWidthApprox, primaryMaterial, movement, type, glass, luminescentHands);
            }
            case "smart" -> {
                view.printMessage("Enter the weight:");
                double weight = Double.parseDouble(InputHandler.readConsoleString());
                return new SmartWatches(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox,
                        caseWidthApprox, primaryMaterial, movement, type, weight);
            }
            case "sport" -> {
                view.printMessage("Enter the water resistance (meters): ");
                int waterResistanceMeters = Integer.parseInt(InputHandler.readConsoleString());
                return new SportWatches(barCode, receiptDate, price, brand, modelName, color, caseDepthApprox,
                        caseWidthApprox, primaryMaterial, movement, type, waterResistanceMeters);
            }
            default -> {
                return null;
            }
        }
    }
}
