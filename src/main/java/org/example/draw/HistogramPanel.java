package org.example.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author Min Danil 13.11.2023
 */
public class HistogramPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int barWidth = 30;
        int barGap = 10;
        int x = 50;
        int maxHeight = getHeight() - 50;
        for (int value : ((Histogram) SwingUtilities.getWindowAncestor(this)).vector) {
            int barHeight = value * 5;
            g.fillRect(x, maxHeight - barHeight, barWidth, barHeight);
            x += barWidth + barGap;
        }
    }
}
