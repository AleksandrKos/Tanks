package square.entity;

/**
 * Created by Администратор on 22.03.2016.
 */
public class CircleObject extends AbstractObject {

    public CircleObject(int diameter) {
        super(diameter, diameter);
    }

    public int getDiameter() {
        return super.getOBJECT_HEIGHT();
    }
}
