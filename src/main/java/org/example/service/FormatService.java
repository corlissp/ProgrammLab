package org.example.service;

import org.example.printer.Printer;

import java.util.List;

/**
 * @author Min Danil 19.10.2023
 */
public class FormatService extends MatrixService {
    private static final int TOTAL_WIDTH = 144;
    public FormatService(Printer printer) {
        super(printer);
    }

    public String centeredText(String string) {
        int spaces = (TOTAL_WIDTH - string.length()) / 2;
        return String.format("%" + spaces + "s%s%" + spaces + "s", "", string, "");
    }

    public String rightText(String string) {
        return String.format("%" + TOTAL_WIDTH + "s", string);
    }

    public void drawTable(int cols, int rows) {
        for (int i = 0; i <= rows * 2; i++) {
            if (i % 2 == 0)
                System.out.print(Printer.CYAN + "-");
            else
                System.out.print("|");
            for (int j = 0; j < cols; j++) {
                if (i % 2 == 0) {
                    System.out.print(eagleTable());
                } else {
                    if (i != rows * 2)
                        System.out.print(columnTable());
                }
            }
            System.out.println();
        }
    }

    public String deleteChars(String string, String chars) {
        string = string.replaceAll("[" + chars + "]", "");
        return string;
    }

    private String columnTable() {
        return String.format("%20s", "|");
    }

    private String eagleTable() {
        String string = "";
        for (int i = 0; i < 20; i++) {
            string = string + "-";
        }
        return string;
    }

    public int searchString(List<String> list, String searchString) {
        int lineNumber = 0;
        int lastMatchingLine = -1;

        for (String line : list) {
            lineNumber++;
            if (line.contains(searchString)) {
                lastMatchingLine = lineNumber;
            }
        }
        return lastMatchingLine;
    }

    public void runningString(String inputString) throws InterruptedException {
        for (int i = inputString.length(); i >= 0; i--) {
            System.out.print("\r" + inputString.substring(0, i));
            Thread.sleep(500);
            System.out.print("\r" + " ".repeat(inputString.length() - i));
        }
        System.out.println();
    }
}
