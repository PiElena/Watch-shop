package com.watch.shop.controller;

import com.watch.shop.model.WatchService;
import com.watch.shop.model.WatchServiceImpl;
import com.watch.shop.view.ConsoleView;
import com.watch.shop.view.View;

import java.util.Scanner;

public class Controller {
    WatchService watchService = new WatchServiceImpl();
    View view = new ConsoleView();

    public void execute() {
        System.out.println("Магазин часов. \n Выберите опцию:");
        System.out.println("1 - показать все часы");
        System.out.println("2 - отсортировать часы по цене");
        System.out.println("3 - отсортировать часы по цвету");
        System.out.println("4 - отсортировать часы по дате поступления");
        System.out.println("5 - показать стоимость часов");
        System.out.println("6 - выход");
        Scanner console = new Scanner(System.in);
            OUTER: while (console.hasNextInt()) {
                INNER:
                switch (console.nextInt()) {
                    case 1: {
                        view.showWatches(watchService.getAllWatches());
                        break;
                    }
                    case 2: {
                        view.showWatches(watchService.sortPriceWatches());
                        break;
                    }
                    case 3: {
                        view.showWatches(watchService.sortColorWatches());
                        break;
                    }
                    case 4: {
                        view.showWatches(watchService.sortReceiptDateWatches());
                        break;
                    }
                    case 5: {
                        view.showPrices(watchService.getAllWatches());
                        break;
                    }
                    case 6: {
                        System.out.println("Будем рады увидеть Вас снова!");
                        break OUTER;
                    }
                    default:
                        System.out.println("К сожалению, такой опции не предусмотрено");
                }
            }
    }
}
