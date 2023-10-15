package org.example.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author Min Danil 15.10.2023
 */
public class DrawCircle extends JFrame {
    public DrawCircle() {
        setTitle("Рисование круга");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(150, 150, 100, 100);
    }
}
