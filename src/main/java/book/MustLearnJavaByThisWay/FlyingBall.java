package book.MustLearnJavaByThisWay;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description: TODO 1、做个窗体 2、做个小球 3、让小球落下来
 * @date 2020/10/21 23:29
 */
public class FlyingBall {
    public static void main(String args[]) {
        Frame frame = new Frame();
        Mypane3 mypane3 = new Mypane3();
        frame.setSize(800, 800);
        frame.add(mypane3);
        Thread thread=new Thread(mypane3);
        thread.start();
        frame.show();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
}

class Mypane3 extends Panel implements Runnable {
    int x = 400;
    int y = 0;

    public void paint(Graphics g) {


        g.setColor(Color.GREEN);
        g.fillOval(x, y, 50, 50);
//        while (true){

//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        //用白球覆盖绿球，模拟重画
//            g.setColor(Color.WHITE);
//            g.fillOval(x,y,50,50);




//        }
    }

    @Override
    public void run() {
        while (true) {
            y++;
            if (y==800){
                y=0;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //调用重画方法重画小球
            repaint();
        }
    }
}