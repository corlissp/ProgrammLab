package org.example.service;

import org.example.printer.Printer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Min Danil 12.10.2023
 */
public class Service {
    private final Printer printer;
    private final Scanner scanner;
    public Service(Printer printer) {
        this.printer = printer;
        this.scanner = new Scanner(System.in);
    }

    public void readAndPrint() {
        System.out.print(Printer.GREEN + "Введите строку: ");
        String input = scanner.next();
        System.out.print(Printer.GREEN + "Результат: ");
        printer.print(Printer.GREEN + input + "\n");
    }

    public void readAndLoadToFile() {
        System.out.print(Printer.GREEN + "Название файла: ");
        String fileName = scanner.next();
        System.out.print(Printer.GREEN + "Введите строку: ");
        String string = scanner.next();
        loadToFile(fileName, string);
    }

    public void readFromFileToConsole() {
        System.out.print(Printer.GREEN + "Название файла: ");
        String name = scanner.next();
        List<String> file = readFromFile(name);
        printer.print(file);
    }

    public void readAndWriteOnBegin() {
        System.out.print(Printer.GREEN + "Название файла: ");
        String fileName = scanner.next();
        System.out.print(Printer.GREEN + "Введите строку: ");
        String string = scanner.next();
        List<String> list = readFromFile(fileName);
        list.add(0, string);
        loadToFileList(fileName, list);
    }

    public void createArray() {
        try {
            System.out.print(Printer.GREEN + "Кол-во элементов в массиве: ");
            int length = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++)
                list.add(i);
            printer.printListInt(list);
        } catch (RuntimeException e) {
            printer.printErrorInput();
        }
    }

    public void readAndOutArray() {
        try {
            System.out.print(Printer.GREEN + "Кол-во элементов в массиве: ");
            int length = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            int element;
            for (int i = 0; i < length; i++) {
                System.out.print(Printer.GREEN + "Элемент: ");
                element = scanner.nextInt();
                list.add(element);
            }
            printer.printListInt(list);
        } catch (RuntimeException e) {
            printer.printErrorInput();
        }
    }

    public void createRandomArray() {
        try {
            System.out.print(Printer.GREEN + "Кол-во элементов в массиве: ");
            int length = scanner.nextInt();
            Random random = new Random();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++)
                list.add(random.nextInt());
            printer.printListInt(list);
        } catch (RuntimeException e) {
            printer.printErrorInput();
        }
    }

    public void createRandomArrayBetween() {
        try {
            System.out.print(Printer.GREEN + "Кол-во элементов в массиве: ");
            int length = scanner.nextInt();
            System.out.print(Printer.GREEN + "Начало диапазона: ");
            int seed = scanner.nextInt();
            System.out.print(Printer.GREEN + "Конец диапазона: ");
            int bound = scanner.nextInt();
            System.out.print(Printer.GREEN + "Название файла: ");
            String fileName = scanner.next();
            Random random = new Random(seed);
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < length; i++)
                list.add(random.nextInt(bound));
            loadToFile(fileName, list.toString());
            printer.printListInt(list);
        } catch (RuntimeException e) {
            printer.printErrorInput();
        }
    }


    private void loadToFileList(String name, List<String> list) {
        try {
            String separator = File.separator;
            Path path = Paths.get("src" + separator + "main" + separator + "resources");
            Path absPath = path.toAbsolutePath();
            File file = new File(absPath + separator + name);
            Writer fileWriter = new FileWriter(file);
            for (String line: list)
                fileWriter.write(line + "\n");
            fileWriter.close();
            System.out.println(Printer.GREEN + "Запись произведена в файл " + name + "!");
        } catch (IOException ex) {
            System.out.println(Printer.RED + "Запись не выполнена!");
        }
    }

    private void loadToFile(String name, String string) {
        try {
            String separator = File.separator;
            Path path = Paths.get("src" + separator + "main" + separator + "resources");
            Path absPath = path.toAbsolutePath();
            File file = new File(absPath + separator + name);
            Writer fileWriter = new FileWriter(file);
            fileWriter.write(string);
            fileWriter.close();
            System.out.println(Printer.GREEN + "Запись произведена в файл " + name + "!");
        } catch (IOException ex) {
            System.out.println(Printer.RED + "Запись не выполнена!");
        }
    }

    private List<String> readFromFile(String name) {
        String separator = File.separator;
        Path path = Paths.get("src" + separator + "main" + separator + "resources");
        Path absPath = path.toAbsolutePath();
        File file = new File(absPath + separator + name);
        List<String> lines = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(file);
            if(!fileScanner.hasNext()) {
                System.out.println(Printer.YELLOW + "Файл пустой!");
                return lines;
            }
            String line = fileScanner.nextLine();
            lines.add(line);
            while (fileScanner.hasNext()) {
                line = fileScanner.nextLine();
                lines.add(line);
            }
            fileScanner.close();
        } catch (IOException ex) {
            System.out.println(Printer.RED + "Не удалось считать файл: " + file);
        }
        return lines;
    }
}
