package org.example.draw;

import javax.swing.*;
import java.util.List;

/**
 * @author Min Danil 13.11.2023
 */
public class Histogram extends JFrame {
    List<Integer> vector;

    public Histogram(List<Integer> vector) {
        this.vector = vector;

        setTitle("Гистограмма");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new HistogramPanel());
    }
}
