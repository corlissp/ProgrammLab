package org.example.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author Min Danil 12.11.2023
 */
class SquarePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = 100;
        int x = getWidth() / 2 - size / 2;
        int y = getHeight() / 2 - size / 2;
        g.drawRect(x, y, size, size);
    }
}
