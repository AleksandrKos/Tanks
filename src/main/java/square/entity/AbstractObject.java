package square.entity;

import square.MyColors;

import java.awt.*;
import java.util.Random;

/**
 * Created by Aleksandr on 20.03.2016.
 */
public class AbstractObject {

    protected final int startX;
    protected final int startY;
    protected int currentX;
    protected int currentY;
    protected Color objectColor;
    protected int accelerationFactor;

    public AbstractObject(int maxX, int maxY) {
        Random r = new Random();
        startX = currentX = r.nextInt(maxX);
        System.out.println("x=" + startX);
        startY = currentY = r.nextInt(maxY);
        System.out.println("y=" + startY);
        MyColors colors = new MyColors();
        objectColor = colors.getRandomColor();
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public void setObjectColor(Color objectColor) {
        this.objectColor = objectColor;
    }

    public void setAccelerationFactor(int accelerationFactor) {
        this.accelerationFactor = accelerationFactor;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public Color getObjectColor() {
        return objectColor;
    }

    public int getAccelerationFactor() {
        return accelerationFactor;
    }
}
