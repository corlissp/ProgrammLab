package org.example.printer;

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

    public void printMatrix(int [][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }

}
