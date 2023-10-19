package org.example.service;

import org.example.printer.Printer;

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
                    System.out.print(upTable());
                } else {
                    if (i != rows * 2)
                        System.out.print(columnTable());
                }
            }
            System.out.println();
        }
    }

    private String columnTable() {
        return String.format("%20s", "|");
    }

    private String upTable() {
        String string = "";
        for (int i = 0; i < 20; i++) {
            string = string + "-";
        }
        return string;
    }
}
