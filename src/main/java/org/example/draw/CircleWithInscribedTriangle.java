package org.example.draw;

import javax.swing.*;

/**
 * @author Min Danil 12.11.2023
 */
public class CircleWithInscribedTriangle extends JFrame {
    private int radius;

    public CircleWithInscribedTriangle(int radius) {
        this.radius = radius;
        setTitle("Вписанный треугольник в круг");
        setSize(2 * radius, 2 * radius);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new CircleWithTrianglePanel());
    }
}
