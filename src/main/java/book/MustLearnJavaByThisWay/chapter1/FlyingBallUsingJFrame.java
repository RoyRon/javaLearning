package book.MustLearnJavaByThisWay.chapter1;

import javax.swing.*;
import java.awt.*;

/**
 * @author 光影风
 * @description: TODO
 * @date 2020/11/18 8:37
 */
public class FlyingBallUsingJFrame {
    public static void main(String args[]){
        JFrame jFrame=new JFrame();
        MyJPanel panel=new MyJPanel();
        Thread thread=new Thread(panel);
        jFrame.setSize(500,500);
        jFrame.add(panel);
        thread.start();
        jFrame.setVisible(true);
    }
}
class MyJPanel extends JPanel implements Runnable{
    int y=10;
    public void paint(Graphics g){
        super.paint(g);
        g.fillOval(200,y,20,20);
    }

    @Override
    public void run() {
        while (true){
            y++;
            if (y>500){
                y=0;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
