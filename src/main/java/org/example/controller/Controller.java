package org.example.controller;

import org.example.service.Service;
import org.example.printer.PrinterMenu;

import java.util.Scanner;

/**
 * @author Min Danil 12.10.2023
 */
public class Controller {
    private final PrinterMenu printer;
    private final Scanner scanner;
    private final Service service;

    public Controller(PrinterMenu printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
        this.service = new Service(printer);
    }

    public void mainPage() {
        try {
            printer.printMain();
            int flag = scanner.nextInt();
            if (flag != 0)
                mainController(flag);
        } catch (RuntimeException e) {
            printer.printErrorCommand();
        }
    }
    public void mainController(int flag) {
        try {
            while (flag != 0) {
                switch (flag) {
                    case 1:
                        printer.printFirst();
                        int secondFlag = scanner.nextInt();
                        while (secondFlag != 0) {
                            firstController(secondFlag);
                            printer.printFirst();
                            secondFlag = scanner.nextInt();
                        }
                        break;
                    case 2:
                        printer.printSecond();
                        secondFlag = scanner.nextInt();
                        while (secondFlag != 0) {
                            secondController(secondFlag);
                            printer.printSecond();
                            secondFlag = scanner.nextInt();
                        }
                    case 3:
                        break;
                }
                printer.printMain();
                flag = scanner.nextInt();
            }
        } catch (RuntimeException e) {
            printer.printErrorCommand();
        }
    }

    private void firstController(int flag) {
        switch (flag) {
            case 1:
                service.readAndPrint();
                break;
            case 2:
                service.readAndLoadToFile();
                break;
            case 3:
                service.readFromFileToConsole();
                break;
            case 4:
                service.readAndWriteOnBegin();
                break;
        }
    }

    private void secondController(int flag) {
        switch (flag) {
            case 1:
                service.createArray();
                break;
            case 2:
                service.readAndOutArray();
                break;
            case 3:
                service.createRandomArray();
                break;
            case 4:
                service.createRandomArrayBetween();
                break;
        }
    }
}
