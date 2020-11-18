package book.MustLearnJavaByThisWay.chapter1;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description: TODO
 * @date 2020/11/18 8:20
 */
public class MoveBallByMouse {
    public static void main(String args[]){
        Frame frame=new Frame();
        BallPanel panel=new BallPanel();
        frame.setSize(500,500);
        frame.add(panel);
        frame.addMouseMotionListener(panel);
        panel.addMouseMotionListener(panel);
        frame.show();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
class BallPanel extends Panel implements MouseMotionListener{
    int x=250;
    int y=250;
    public void paint(Graphics g){
        g.fillOval(x,y,20,20);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}