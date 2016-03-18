package square;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Aleksander Kasiakin
 */
public class HitBall extends Canvas implements Runnable {

    private boolean running;
    private static int x;
    private static int y;
    private static int n, m;

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int SQUARE_WIDTH = 50;
    private static final int SQUARE_HEIGHT = 70;
    private static int stepX = 1;
    private static int stepY = 2;
    private static int directionX = WIDTH - SQUARE_WIDTH - stepX;
    private static int directionY = HEIGHT - SQUARE_HEIGHT - stepY;
    public static String NAME = "Square";
    private JFrame frame;

    public HitBall() {
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setMaximumSize(new Dimension(WIDTH, HEIGHT));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        n = 1;
        m = 1;

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
                render();
                update();
            }
        }
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.fillRect(x, y, SQUARE_WIDTH, SQUARE_HEIGHT);
        g.dispose();
        bs.show();
    }

    private void update() {

        if (x >= directionX || x < 0) {
            n *= -1;
        }
        if (y >= directionY || y < 0) {
            m *= -1;
        }
        x += stepX * n;
        y += stepY * m;
    }
}
