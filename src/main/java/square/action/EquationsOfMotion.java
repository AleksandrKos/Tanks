package square.action;

import square.entity.AbstractObject;

/**
 * Created by Aleksander Kasiakin on 22.03.2016.
 */
public class EquationsOfMotion {

    public static void linearMotion(AbstractObject currentObject, int maxCoordinateX, int maxCoordinateY, int factorA) {
        if (currentObject.getCurrentX() >= (maxCoordinateX - currentObject.getOBJECT_WIDTH()) || currentObject.getCurrentX() < 0) {
            currentObject.setDirectionX(currentObject.getDirectionX() * (-1));
        }
        if (currentObject.getCurrentY() >= (maxCoordinateY - currentObject.getOBJECT_HEIGHT()) || currentObject.getCurrentY() < 0) {
            currentObject.setDirectionY(currentObject.getDirectionY() * (-1));
        }
        currentObject.setCurrentX(currentObject.getCurrentX() + 1 * currentObject.getAccelerationFactor() * currentObject.getDirectionX());
        currentObject.setCurrentY(currentObject.getCurrentY() + factorA * currentObject.getDirectionY());
    }

    public static void circleMotion(Rotation rotationObject, double rotationSpeed) {

        rotationObject.getCurrentObject().setCurrentX((int) (rotationObject.getCenterX() + rotationObject.getRadius() * Math.cos(rotationObject.getAngel())));
        rotationObject.getCurrentObject().setCurrentY((int) (rotationObject.getCenterY() + rotationObject.getRadius() * Math.sin(rotationObject.getAngel())));
        rotationObject.setAngel(rotationObject.getAngel() + rotationSpeed);
    }
}
