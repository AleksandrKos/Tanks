package square.entity;

import java.awt.*;

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

    public AbstractObject(int startX, int startY) {
        this.startX = startX;
        this.startY = startY;
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
