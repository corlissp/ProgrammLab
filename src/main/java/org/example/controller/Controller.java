package org.example.controller;

import org.example.draw.DrawCircle;
import org.example.draw.DrawSquare;
import org.example.printer.PrinterMenu;
import org.example.service.FormatService;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

/**
 * @author Min Danil 12.10.2023
 */
public class Controller {
    private final PrinterMenu printer;
    private final Scanner scanner;
    private final FormatService service;

    public Controller(PrinterMenu printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
        this.service = new FormatService(printer);
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
                    case 4:
                        printer.printMatrixBlock();
                        secondFlag = scanner.nextInt();
                        while (secondFlag != 0) {
                            matrixController(secondFlag);
                            printer.printMatrixBlock();
                            secondFlag = scanner.nextInt();
                        }
                        break;
                    case 5:
                        printer.printSortBlock();
                        secondFlag = scanner.nextInt();
                        while (secondFlag != 0) {
                            sortController(secondFlag);
                            printer.printSortBlock();
                            secondFlag = scanner.nextInt();
                        }
                        break;
                    case 6:
                        printer.printFormat();
                        secondFlag = scanner.nextInt();
                        while (secondFlag != 0) {
                            formatController(secondFlag);
                            printer.printFormat();
                            secondFlag = scanner.nextInt();
                        }
                        break;
                    case 7:
                        SwingUtilities.invokeLater(() -> {
                            DrawSquare squareDrawing = new DrawSquare();
                            squareDrawing.setVisible(true);
                        });
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
                printer.printResult();
                printer.print(service.read());
                break;
            case 2:
                service.readAndLoadToFile();
                break;
            case 3:
                printer.printListString(service.readFromFile());
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

    private void matrixController(int flag) {
        int [][] matrix;
        switch (flag) {
            case 1:
                matrix = service.createMatrix();
                printer.printMatrix(matrix);
                break;
            case 2:
                matrix = service.createMatrix();
                printer.printMatrix(service.removeColumn(matrix));
                break;
            case 3:
                matrix = service.createMatrix();
                printer.printMatrix(service.transposeMatrix(matrix));
                break;
            case 4:
                matrix = service.createMatrix();
                printer.printMatrix(service.removeMainDiagonal(matrix));
                break;
            case 5:
                matrix = service.createMatrix();
                printer.printMatrix(matrix);
                int[][] secondMatrix = service.createMatrix();
                printer.printMatrix(secondMatrix);
                System.out.print("Иднекс для замены: ");
                int index = scanner.nextInt();
                printer.printMatrix(service.replaceColumn(matrix, secondMatrix, index));
                break;
            case 6:
                matrix = service.createMatrix();
                printer.printMatrix(matrix);
                System.out.print("Введите значение: ");
                int searchValue = scanner.nextInt();
                printer.printMatrix(service.searchElement(matrix, searchValue));
                break;
            case 7:
                matrix = service.createMatrix();
                printer.printMatrix(matrix);
                printer.printResult();
                printer.print(service.calculateDeterminant(matrix));
                break;
            case 8:
                matrix = service.createMatrix();
                printer.printMatrix(matrix);
                printer.printMatrix(service.multiMatrix(matrix));
                break;
            case 9:
                matrix = service.swapRowsMatrix();
                printer.printMatrix(matrix);
                break;
        }
    }

    private void sortController(int flag) {
        int [][] matrix = service.createMatrix();
        printer.printEnter();
        System.out.println();
        printer.printMatrix(matrix);
        switch (flag) {
            case 1:
                matrix = service.sortMatrixShell(matrix);
                printer.printResult();
                System.out.println();
                printer.printMatrix(matrix);
                break;
            case 2:
                matrix = service.sortMatrixBubble(matrix);
                printer.printResult();
                System.out.println();
                printer.printMatrix(matrix);
                break;
            case 3:
                matrix = service.sortMatrixInsertion(matrix);
                printer.printResult();
                System.out.println();
                printer.printMatrix(matrix);
                break;
            case 4:
                matrix = service.sortMatrixSelection(matrix);
                printer.printResult();
                System.out.println();
                printer.printMatrix(matrix);
                break;
            case 5:
                matrix = service.sortMatrixHeap(matrix);
                printer.printResult();
                System.out.println();
                printer.printMatrix(matrix);
                break;
        }
    }

    private void formatController(int flag) {
        String string;
        switch (flag) {
            case 1:
                printer.printQuestions(3);
                int input = scanner.nextInt();
                if (input == 1) {
                    printer.print(service.read());
                } else if (input == 2) {
                    string = service.centeredText(service.read());
                    printer.print(string);
                } else if (input == 3) {
                    string = service.rightText(service.read());
                    printer.print(string);
                }
                break;
            case 2:
                System.out.print("Кол-во стобцов: ");
                int cols = scanner.nextInt();
                System.out.print("Кол-во строк: ");
                int rows = scanner.nextInt();
                service.drawTable(cols, rows);
                break;
            case 3:
                string = service.readFromFile().get(0);
                String chars = service.read();
                string = service.deleteChars(string, chars);
                printer.printResult();
                printer.print(string);
                break;
            case 4:
                List<String> list = service.readFromFile();
                string = service.read();
                int lastMatchingLine = service.searchString(list, string);
                if (lastMatchingLine != -1) {
                    printer.printResult();
                    System.out.println("Последняя строка с подстрокой '" + string + "' найдена в строке номер " + lastMatchingLine);
                } else {
                    System.out.println("Подстрока '" + string + "' не найдена в файле.");
                }
                break;
            case 5:
                string = service.read();
                try {
                    service.runningString(string);
                } catch (InterruptedException e) {
                }
                break;
        }
    }
}
