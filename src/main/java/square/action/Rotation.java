package square.action;

import square.entity.AbstractObject;

/**Класс-оболочка для вращающегося объекта. В первую очередь он предназначен для присвоения и хранения координат центра
 * вращения.
 *
 * Created by Aleksander Kasiakin on 22.03.2016.
 */
public class Rotation {

    private final AbstractObject currentObject;
    private int centerX;
    private int centerY;
    private int radius;
    private double angel;

    /**
     * Конструктор без угла, ему присваивается 0
     * @param currentObject Собственно объект, который будем вращать.
     * @param centerX Получаем первичную координату Х, потом будем ее проверять и, если надо, корректировать
     * @param centerY Тоже самое для координаты У
     * @param radius Радиус вращения
     * @param mainFieldWidth Ширина основного окна
     * @param mainFieldHeight Высота основного окна
     */
    public Rotation(AbstractObject currentObject, int centerX, int centerY, int radius, int mainFieldWidth, int mainFieldHeight) {
        this.currentObject = currentObject;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.angel = 0;
        validateCenterCoordinates(currentObject, centerX, centerY, radius, mainFieldWidth, mainFieldHeight);
    }

    public Rotation(AbstractObject currentObject, int centerX, int centerY, int radius, int mainFieldWidth, int mainFieldHeight, int angel) {

        this.currentObject = currentObject;
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.angel = angel;
        validateCenterCoordinates(currentObject, centerX, centerY, radius, mainFieldWidth, mainFieldHeight);
    }

    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getAngel() {
        return angel;
    }

    public void setAngel(double angel) {
        this.angel = angel;
    }

    public AbstractObject getCurrentObject() {
        return currentObject;
    }

    /**
     *Метод проверяет не вылезет ли объект за границы основного окна при вращении в передаваемом центре.
     *
     * @param currentObject Собственно объект, который будем вращать. Нужен, чтобы получить его габариты
     * @param centerX Получаем первичную координату Х, потом будем ее проверять и, если надо, корректировать
     * @param centerY Тоже самое для координаты У
     * @param radius Радиус вращения
     * @param mainFieldWidth Ширина основного окна
     * @param mainFieldHeight Высота основного окна
     */
    private void validateCenterCoordinates(AbstractObject currentObject, int centerX, int centerY, int radius, int mainFieldWidth, int mainFieldHeight) {
        if ((centerX + radius + currentObject.getOBJECT_WIDTH()) > mainFieldWidth) {
            this.centerX = mainFieldWidth - radius - currentObject.getOBJECT_WIDTH();
        }
        if ((centerX - radius - currentObject.getOBJECT_WIDTH()) < 0) {
            this.centerX = radius + currentObject.getOBJECT_WIDTH();
        }
        if ((centerY + radius + currentObject.getOBJECT_HEIGHT()) > mainFieldHeight) {
            this.centerY = mainFieldHeight - radius - currentObject.getOBJECT_HEIGHT();
        }
        if ((centerY - radius - currentObject.getOBJECT_HEIGHT()) < 0) {
            this.centerY = radius + currentObject.getOBJECT_HEIGHT();
        }
    }
}
