package book.MustLearnJavaByThisWay.chapter1;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description: TODO
 * @date 2020/10/27 23:36
 */
public class MoveBall {
    public static void main(String[] args) {
        Frame frame = new Frame();
        MoveBallPanel panel = new MoveBallPanel();
        frame.setSize(800, 800);
        frame.add(panel);
        frame.addKeyListener(panel);
        panel.addKeyListener(panel);
        frame.show();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MoveBallPanel extends Panel implements KeyListener {
    int x = 200;
    int y = 200;

    public void paint(Graphics g) {
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode()+" "+e.getKeyChar());
        if (e.getKeyCode() == 37) {
            x--;
        }
        if (e.getKeyCode()==38){
            y--;
        }
        if (e.getKeyCode()==39){
            x++;
        }
        if (e.getKeyCode()==40){
            y++;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}