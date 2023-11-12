package org.example.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author Min Danil 12.11.2023
 */
public class CircleWithTrianglePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int circleDiameter = Math.min(getWidth(), getHeight());
        int circleX = centerX - circleDiameter / 2;
        int circleY = centerY - circleDiameter / 2;
        g.drawOval(circleX, circleY, circleDiameter, circleDiameter);
        int triangleHeight = (int) (Math.sqrt(3) / 3.45 * circleDiameter);
        int triangleBase = (int) (Math.sqrt(3) * circleDiameter / 2);
        int[] xPoints = {
                centerX,
                centerX - triangleBase / 2,
                centerX + triangleBase / 2
        };
        int[] yPoints = {
                centerY - circleDiameter / 2,
                centerY + triangleHeight / 2,
                centerY + triangleHeight / 2
        };

        g.drawPolygon(xPoints, yPoints, 3);
    }
}
