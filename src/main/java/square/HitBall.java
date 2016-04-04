package square;

import square.action.EquationsOfMotion;
import square.action.Rotation;
import square.entity.CircleObject;
import square.entity.SquareObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Aleksander Kasiakin
 */
public class HitBall extends Canvas implements Runnable {

    private boolean running;
    private final int AMOUNT_OF_OBJECT = 2;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final int SQUARE_WIDTH = 20;
    private final int SQUARE_HEIGHT = 20;
    private List<SquareObject> objectList;
    private CircleObject objectCircle;
    private CircleObject childCircleObject;
    private Rotation rotation;
    private Rotation childRotation;
    public static String NAME = "Square";
    private JFrame frame;

    public HitBall() {
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame = new JFrame(NAME);
        frame.setLayout(new BorderLayout());

        frame.add(this, BorderLayout.CENTER);
        frame.pack();

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HitBall().start();
    }

    private void start() {
        running = true;
        new Thread(this).start();
    }

    public void run() {

        long lastTime = System.nanoTime();
        double nsPerTick = 1000000000D / 60D; //60 кадров в секунду
        double delta = 0;

        init();

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerTick;
            lastTime = now;

            boolean shouldRender = false;

            while (delta >= 1) {
                delta -= 1;
                shouldRender = true;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (shouldRender) {
                render(objectList);
                update(objectList);
            }
        }
    }

    private void init() {

        objectList = new ArrayList<SquareObject>();

        Random r = new Random();
        for (int i = 0; i < AMOUNT_OF_OBJECT; i++) {
            objectList.add(new SquareObject(SQUARE_HEIGHT, SQUARE_WIDTH));
            objectList.get(i).setCurrentX(r.nextInt(WIDTH));
            objectList.get(i).setCurrentY(r.nextInt(HEIGHT));
        }

        objectCircle = new CircleObject(30);
        childCircleObject = new CircleObject(10);
        rotation = new Rotation(objectCircle, 100, 150, 60, WIDTH, HEIGHT);
        childRotation = new Rotation(childCircleObject, rotation.getCenterX(), rotation.getCenterY(), 20, WIDTH, HEIGHT);
    }

    private void render(List<SquareObject> objectList) {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
//        g.fillRect(0, 0, getWidth(), getHeight());
        g.fillRect(0, 0, WIDTH, HEIGHT);

        int randomElement = 1;
        for (SquareObject currentObject : objectList) {
            g.setColor(currentObject.getObjectColor());
            if (randomElement > 0) {
                g.fillRect(currentObject.getCurrentX(), currentObject.getCurrentY(), SQUARE_WIDTH, SQUARE_HEIGHT);
            }
            if (randomElement < 0) {
                g.fillOval(currentObject.getCurrentX(), currentObject.getCurrentY(), SQUARE_WIDTH, SQUARE_HEIGHT);
            }
            randomElement *= -1;
        }
        g.fillOval(objectCircle.getCurrentX(), objectCircle.getCurrentY(), objectCircle.getDiameter(), objectCircle.getDiameter());
        g.fillOval(childCircleObject.getCurrentX(), childCircleObject.getCurrentY(), childCircleObject.getDiameter(), childCircleObject.getDiameter());
        g.dispose();
        bs.show();
    }

    private void update(List<SquareObject> objectList) {

        for (SquareObject currentObject : objectList) {
            EquationsOfMotion.linearMotion(currentObject, WIDTH, HEIGHT, 2);
        }
        EquationsOfMotion.circleMotion(rotation, 0.03);
        EquationsOfMotion.setCenterCoordinates(childRotation, rotation);
        EquationsOfMotion.circleMotion(childRotation, 0.07);
    }
}
