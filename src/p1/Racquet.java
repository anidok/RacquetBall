package p1;

import java.awt.Graphics2D;

public interface Racquet {
    final int WIDTH = 50;
    final int HEIGHT = 10;
    void paint(Graphics2D g2d);
    void move();

}
