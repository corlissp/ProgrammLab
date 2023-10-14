package org.example;

import org.example.controller.Controller;
import org.example.printer.PrinterMenu;

import java.util.Scanner;

/**
 *
 *
 */
public class App {
    public static void main( String[] args ) {
        PrinterMenu printerMenu = new PrinterMenu();
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller(printerMenu, scanner);
        controller.mainPage();
    }
}
