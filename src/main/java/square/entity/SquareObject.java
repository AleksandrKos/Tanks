package square.entity;

/**
 * Created by Aleksandr on 18.03.2016.
 */
public class SquareObject extends AbstractObject{

    private final int HEIGHT;
    private final int WIDTH;
    private int x;
    private int y;
    private int directionN;
    private int directionM;

    public SquareObject(int objectHeight, int objectWidt, int maxX, int maxY) {
        super(maxX, maxY);
        HEIGHT = objectHeight;
        WIDTH = objectWidt;
        directionN = 1;
        directionM =1;
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
}
