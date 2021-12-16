package com.watch.shop;

import com.watch.shop.controller.Controller;
import com.watch.shop.model.WatchService;
import com.watch.shop.model.WatchServiceImpl;
import com.watch.shop.view.View;

public class Application {
    public static void main(String[] args) {
        WatchService model = new WatchServiceImpl();
        View view = new View();

        Controller controller = new Controller(model, view);
        controller.run();
    }
}
