package org.example.printer;

/**
 * @author Min Danil 12.10.2023
 */
public class PrinterMenu extends Printer {
    public void printMain() {
        System.out.println(GREEN + "\nВыберите блок работы:");
        System.out.println(PURPLE + "1. Чтение и запись.");
        System.out.println(PURPLE + "2. Создание массива.");
        System.out.println(PURPLE + "3. Работа с массивом.");
        System.out.println(RED + "0. Завершить работу.");
    }

    public void printFirst() {
        System.out.println(GREEN + "\nВыберите задание:");
        System.out.println(PURPLE + "1. Чтение информации с клавиатуры и вывод на экран.");
        System.out.println(PURPLE + "2. Чтение информации с клавиатуры и запись в файл.");
        System.out.println(PURPLE + "3. Чтение информации из файла и вывод на экран.");
        System.out.println(PURPLE + "4. Чтение информации с клавиатуры и запись в начало файла.");
        System.out.println(RED + "0. Выйти.");
    }

    public void printSecond() {
        System.out.println(GREEN + "\nВыберите задание:");
        System.out.println(PURPLE + "1. Создание массива и вывод на экран.");
        System.out.println(PURPLE + "2. Чтение массива с клавиатуры и вывод на экран.");
        System.out.println(PURPLE + "3. Создание массива генератором случайных значений и вывод на экран.");
        System.out.println(PURPLE + "4. Создание массива генератором случайных значений в диапазоне.");
        System.out.println(RED + "0. Выйти.");
    }

    public void printThird() {
        System.out.println(GREEN + "\nВыберите задание:");
        System.out.println(PURPLE + "1. Вывести вектор в обратной последовательности.");
        System.out.println(PURPLE + "2. Отсортировать вектор.");
        System.out.println(PURPLE + "3. Найти минимальное\\максимальное значение.");
        System.out.println(PURPLE + "4. Найти НОД.");
        System.out.println(PURPLE + "5. Сравнение сумм векторов. Вывод вектора с наименьшей суммой.");
        System.out.println(RED + "0. Выйти.");
    }

    public void printQuestions(int flag) {
        switch (flag) {
            case 1:
                System.out.println(GREEN + "Выберите принцип сортировки:");
                System.out.println(PURPLE + "1. Отсортировать по возрастанию.");
                System.out.println(PURPLE + "2. Отсортировать по убыванию.");
                break;
            case 2:
                System.out.println(GREEN + "Выберите цель поиска:");
                System.out.println(PURPLE + "1. Вывести максимум.");
                System.out.println(PURPLE + "2. Вывести минимум.");
        }
    }
}
