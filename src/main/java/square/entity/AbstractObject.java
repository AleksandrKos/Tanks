package square.entity;

import square.MyColors;

import java.awt.*;

/**
 * Created by Aleksandr on 20.03.2016.
 */
public class AbstractObject {

    private final int OBJECT_HEIGHT;
    private final int OBJECT_WIDTH;
    private int currentX;
    private int currentY;
    private Color objectColor;
    private int accelerationFactor;
    private int directionX;
    private int directionY;

    public AbstractObject(int objectHeight, int objectWidth) {
        OBJECT_HEIGHT = objectHeight;
        OBJECT_WIDTH = objectWidth;
        MyColors colors = new MyColors();
        objectColor = colors.getRandomColor();
        directionX = 1;
        directionY =1;
        accelerationFactor = 1;
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

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public int getOBJECT_HEIGHT() {
        return OBJECT_HEIGHT;
    }

    public int getOBJECT_WIDTH() {
        return OBJECT_WIDTH;
    }
}
