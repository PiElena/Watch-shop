package com.watch.shop;

import com.watch.shop.controller.Controller;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.execute();
    }
}
