package org.example.draw;

import javax.swing.*;

/**
 * @author Min Danil 12.11.2023
 */
public class DrawSquare extends JFrame {
    public DrawSquare() {
        setTitle("Квадрат");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        SquarePanel squarePanel = new SquarePanel();
        add(squarePanel);
        SwingUtilities.invokeLater(() -> squarePanel.repaint());
    }
}
