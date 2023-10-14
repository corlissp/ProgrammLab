package org.example.controller;

import org.example.printer.PrinterMenu;
import org.example.service.Service;

import java.util.List;
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
                        break;
                    case 3:
                        printer.printThird();
                        secondFlag = scanner.nextInt();
                        while (secondFlag != 0) {
                            thirdController(secondFlag);
                            printer.printThird();
                            secondFlag = scanner.nextInt();
                        }
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
        List<Integer> list;
        switch (flag) {
            case 1:
                list = service.createArray();
                printer.printResult();
                printer.printListInt(list);
                break;
            case 2:
                list = service.readArray();
                printer.printResult();
                printer.printListInt(list);
                break;
            case 3:
                list = service.createRandomArray();
                printer.printResult();
                printer.printListInt(list);
                break;
            case 4:
                list = service.createRandomArrayBetween();
                service.loadListToFile(list);
                printer.printResult();
                printer.printListInt(list);
                break;
        }
    }

    private void thirdController(int flag) {
        List<Integer> list;
        switch (flag) {
            case 1:
                list = service.createRandomArrayBetween();
                printer.printEnter();
                printer.printListInt(list);
                list = service.reverseList(list);
                printer.printResult();
                printer.printListInt(list);
                break;
            case 2:
                printer.printQuestions(1);
                int input = scanner.nextInt();
                if (input == 1) {
                    list = service.createRandomArrayBetween();
                    printer.printEnter();
                    printer.printListInt(list);
                    list = service.sortList(list);
                    printer.printResult();
                    printer.printListInt(list);
                } else if (input == 2) {
                    list = service.createRandomArrayBetween();
                    printer.printEnter();
                    printer.printListInt(list);
                    list = service.sortList(list);
                    list = service.reverseList(list);
                    printer.printResult();
                    printer.printListInt(list);
                } else {
                    printer.printErrorCommand();
                }
                break;
            case 3:
                printer.printQuestions(2);
                input = scanner.nextInt();
                if (input == 1) {
                    list = service.createRandomArrayBetween();
                    printer.printEnter();
                    printer.printListInt(list);
                    System.out.print("Максимум: ");
                    printer.print(service.maxFromList(list));
                } else if (input == 2) {
                    list = service.createRandomArrayBetween();
                    printer.printEnter();
                    printer.printListInt(list);
                    System.out.print("Минимум: ");
                    printer.print(service.minFromList(list));
                } else {
                    printer.printErrorCommand();
                }
                break;
            case 4:
                list = service.readArray();
                printer.printEnter();
                printer.printListInt(list);
                int result = service.findGcd(list);
                printer.printResult();
                printer.print(result);
                break;
            case 5:
                list = service.readArray();
                printer.printEnter();
                printer.printListInt(list);
                List<Integer> secondList = service.readArray();
                printer.printEnter();
                printer.printListInt(secondList);
                printer.printResult();
                printer.printListInt(service.searchMinSum(list, secondList));
                break;
        }
    }
}
