package square.entity;

import square.MyColors;

import java.awt.*;
import java.util.Random;

/**
 * Created by Aleksandr on 18.03.2016.
 */
public class SquareObject {

    private final int HEIGHT;
    private final int WIDTH;
    private int x;
    private int y;
    private int directionN;
    private int directionM;
    private int startX;
    private int startY;
    private Color objectColor;

    public SquareObject(int height, int widt, int directionX, int directionY) {
        Random r = new Random();
        startX = x = r.nextInt(directionX);
        startY = y = r.nextInt(directionY);
        HEIGHT = height;
        WIDTH = widt;
        directionN = 1;
        directionM =1;
        MyColors colors = new MyColors();
        objectColor = colors.getRandomColor();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getDirectionN() {
        return directionN;
    }

    public void setDirectionN(int directionN) {
        this.directionN = directionN;
    }

    public int getDirectionM() {
        return directionM;
    }

    public void setDirectionM(int directionM) {
        this.directionM = directionM;
    }

    public Color getObjectColor() {
        return objectColor;
    }

    public void setObjectColor(Color objectColor) {
        this.objectColor = objectColor;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
}
