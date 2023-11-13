package org.example.service;

import org.example.printer.Printer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author Min Danil 12.10.2023
 */
public class Service {
    private final Printer printer;
    protected final Scanner scanner;
    protected final String separator = File.separator;
    protected final Path path = Paths.get("src" + separator + "main" + separator + "resources");
    protected final Path absPath = path.toAbsolutePath();
    public Service(Printer printer) {
        this.printer = printer;
        this.scanner = new Scanner(System.in);
    }

    public String read() {
        System.out.print(Printer.GREEN + "Введите строку: ");
        return scanner.next();
    }

    public String readLine() {
        System.out.print(Printer.GREEN + "Введите строку: ");
        return scanner.nextLine();
    }

    private String readNameFile() {
        System.out.print(Printer.GREEN + "Название файла: ");
        return scanner.next();
    }

    public void readAndLoadToFile() {
        String string = read();
        String fileName = readNameFile();
        loadToFile(fileName, string);
    }

    public List<String> readFromFile() {
        System.out.print(Printer.GREEN + "Название файла: ");
        String name = scanner.next();
        return readFromFile(name);
    }

    public void readAndWriteOnBegin() {
        String fileName = readNameFile();
        String string = read();
        List<String> list = readFromFile(fileName);
        list.add(0, string);
        loadToFileList(fileName, list);
    }

    public List<Integer> createArray() {
        List<Integer> list = new ArrayList<>();
        try {
            System.out.print(Printer.GREEN + "Кол-во элементов в массиве: ");
            int length = scanner.nextInt();
            for (int i = 0; i < length; i++)
                list.add(i);
        } catch (RuntimeException e) {
            printer.printErrorInput();
        }
        return list;
    }

    public List<Integer> inputArray() {
        List<Integer> list = new ArrayList<>();
        try {
            System.out.print(Printer.GREEN + "Кол-во элементов в массиве: ");
            int length = scanner.nextInt();
            for (int i = 0; i < length; i++)
                list.add(scanner.nextInt());
        } catch (RuntimeException e) {
            printer.printErrorInput();
        }
        return list;
    }

    public List<Integer> readArray() {
        List<Integer> list = new ArrayList<>();
        try {
            System.out.print(Printer.GREEN + "Кол-во элементов в массиве: ");
            int length = scanner.nextInt();
            int element;
            for (int i = 0; i < length; i++) {
                System.out.print(Printer.GREEN + "Элемент: ");
                element = scanner.nextInt();
                list.add(element);
            }
        } catch (RuntimeException e) {
            printer.printErrorInput();
        }
        return list;
    }

    public List<Integer> createRandomArray() {
        List<Integer> list = new ArrayList<>();
        try {
            System.out.print(Printer.GREEN + "Кол-во элементов в массиве: ");
            int length = scanner.nextInt();
            Random random = new Random();
            for (int i = 0; i < length; i++)
                list.add(random.nextInt());
        } catch (RuntimeException e) {
            printer.printErrorInput();
        }
        return list;
    }

    public List<Integer> createRandomArrayBetween() {
        List<Integer> list = new ArrayList<>();
        try {
            System.out.print(Printer.GREEN + "Кол-во элементов в массиве: ");
            int length = scanner.nextInt();
            System.out.print(Printer.GREEN + "Начало диапазона: ");
            int min = scanner.nextInt();
            System.out.print(Printer.GREEN + "Конец диапазона: ");
            int max = scanner.nextInt();
            Random random = new Random();
            for (int i = 0; i < length; i++)
                list.add(random.nextInt(max - min) + min);
        } catch (RuntimeException e) {
            printer.printErrorInput();
        }
        return list;
    }

    public void loadListToFile(List<Integer> list) {
        String fileName = readNameFile();
        loadToFile(fileName, list.toString());
    }

    public List<Integer> searchMinSum(List<Integer> first, List<Integer> second) {
        if (calculateSum(first) >= calculateSum(second)) {
            return first;
        }
        return second;
    }

    private int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public List<Integer> reverseList(List<Integer> list) {
        Collections.reverse(list);
        return list;
    }

    public List<Integer> sortList(List<Integer> list) {
        Collections.sort(list);
        return list;
    }

    public int maxFromList(List<Integer> list) {
        return Collections.max(list);
    }

    public int minFromList(List<Integer> list) {
        return Collections.min(list);
    }

    public int findGcd(List<Integer> list) {
        int gcd = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            gcd = findGCD(gcd, list.get(i));
        }
        return gcd;
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private void loadToFileList(String name, List<String> list) {
        try {
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
