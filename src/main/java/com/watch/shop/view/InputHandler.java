package com.watch.shop.view;

import java.util.Scanner;

public final class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readConsoleString() {
        return scanner.next();
    }

    public static int readConsoleInt() {
        return scanner.nextInt();
    }
}
