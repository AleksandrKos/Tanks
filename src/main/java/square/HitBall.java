package square;

import square.entity.SquareObject;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksander Kasiakin
 */
public class HitBall extends Canvas implements Runnable {

    private boolean running;
    private final int AMOUNT_OF_OBJECT = 10;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int SQUARE_WIDTH = 20;
    private static final int SQUARE_HEIGHT = 20;
    private static int stepX = 1;
    private static int stepY = 2;
    private static int directionX = WIDTH - SQUARE_WIDTH;
    private static int directionY = HEIGHT - SQUARE_HEIGHT;
    private List<SquareObject> objectList;
    private SquareObject objectCircle;
    public static String NAME = "Square";
    private JFrame frame;

    //Для проверки ващения
    private static double angel = 0;

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
                updateCircle(objectCircle);
            }
        }
    }

    private void init() {
        objectList = new ArrayList<SquareObject>();

        for (int i = 0; i < AMOUNT_OF_OBJECT; i++) {
            objectList.add(new SquareObject(SQUARE_HEIGHT, SQUARE_WIDTH, directionX, directionY));
        }

        objectCircle = new SquareObject(30, 30, 150, 200);
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
        g.fillOval(objectCircle.getCurrentX(), objectCircle.getCurrentY(), objectCircle.getWIDTH(), objectCircle.getHEIGHT());
        g.dispose();
        bs.show();
    }

    private void update(List<SquareObject> objectList) {

        for (SquareObject currentObject : objectList) {
            if (currentObject.getCurrentX() >= directionX || currentObject.getCurrentX() < 0) {
                currentObject.setDirectionN(currentObject.getDirectionN() * (-1));
            }
            if (currentObject.getCurrentY() >= directionY || currentObject.getCurrentY() < 0) {
                currentObject.setDirectionM(currentObject.getDirectionM() * (-1));
            }
            currentObject.setCurrentX(currentObject.getCurrentX() + stepX * currentObject.getDirectionN());
            currentObject.setCurrentY(currentObject.getCurrentY() + stepY * currentObject.getDirectionM());
        }
    }

    private void updateCircle(SquareObject currentObject) {
        angel += 0.07;
        currentObject.setCurrentX((int) (currentObject.getStartX() + currentObject.getHEIGHT() * Math.cos(angel)));
        currentObject.setCurrentY((int) (currentObject.getStartY() + currentObject.getHEIGHT() * Math.sin(angel)));
    }
}
