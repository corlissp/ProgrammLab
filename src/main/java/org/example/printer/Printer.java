package org.example.printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Min Danil 12.10.2023
 */
public abstract class Printer {
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public void print(String string) {
        System.out.println(string);
    }

    public void print(Integer integer) {
        System.out.println(integer);
    }

    public void printListString(List<String> list) {
        list.forEach(System.out::println);
    }

    public void printListInt(List<Integer> list) {
        System.out.println(list);
    }

    public void printErrorCommand() {
        System.out.println(RED + "Неверная команда!");
    }

    public void printErrorInput() {
        System.out.println(RED + "Ошибка при вводе!");
    }

    public void printEnter() {
        System.out.print(GREEN + "Введено: ");
    }

    public void printResult() {
        System.out.print(GREEN + "Результат: ");
    }

    public void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }

    public void printMaxMinColorMatrix(int[][] matrix, int max, int min) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == max || matrix[i][j] == min) {
                    System.out.print("\u001B[3" + (i + j) + "m" + matrix[i][j] + " ");
                } else {
                    System.out.print("\u001B[00m" + matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void printRowsColor(int[][] matrix, int input) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("\u001B[3" + (i + input) + "m" + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printColsColor(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("\u001B[3" + checkNegative(j, matrix[0][0]) + "m" + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printGradientMatrix(int[][] matrix) {
        List<Integer> diagonal = checkDiagonal(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print("\u001B[3" + checkLastIndex(diagonal.get(i)) + "m" + matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private List<Integer> checkDiagonal(int[][] matrix) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j)
                    arr.add(matrix[i][j]);
            }
        }
        return arr;
    }

    private int checkNegative(int a, int b) {
        if (a - b > 0)
            return a - b;
        else
            return (a - b) * -1;
    }

    private int checkLastIndex(int number) {
        if (number < 10) {
            return number;
        } else if (number >= 10 && number < 100) {
            return number % 10;
        } else {
            return number % 100;
        }
    }
}
