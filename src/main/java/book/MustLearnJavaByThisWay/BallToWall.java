package book.MustLearnJavaByThisWay;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description: TODO 1、做个窗体 2、做个小球 3、让小球斜着飞 4、遇到墙反弹
 * @date 2020/10/23 8:31
 */
public class BallToWall {
    public static void main(String args[]) {
        Frame frame = new Frame();
        MyPanel4 myPanel4=new MyPanel4();
        frame.setSize(800, 800);
        frame.add(myPanel4);
        frame.show();
        Thread thread=new Thread(myPanel4);
        thread.start();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

class MyPanel4 extends Panel implements Runnable{
    int x=2;
    int y=200;
    int flyingStatus=0;//0是右下，1是左下，2是左上，3是右上
    public void paint(Graphics g){
        g.fillOval(x,y,30,30);
    }

    @Override
    public void run() {
        while (true){
            //定义飞行姿态
            if (flyingStatus==0){
                x++;
                y++;
            }else if (flyingStatus==1){
                x--;
                y++;
            }else if (flyingStatus==2){
                x--;
                y--;
            }else if (flyingStatus==3){
                x++;
                y--;
            }
//            if (y>800){
//                y--; //减1之后就不再走这段代码，因为y又小于800了，相当于又没撞墙了
//                x++;
//            }else {
//                x++;
//                y++;
//            }
            //改变飞行状态
            if (x>750){
                if (flyingStatus==0){
                    flyingStatus=1;
                }else {
                    flyingStatus=2;
                }
            }
            if (y>735){
                if (flyingStatus==1){
                    flyingStatus=2;
                }else {
                    flyingStatus=3;
                }
            }
            if (x<0){
                if (flyingStatus==2){
                    flyingStatus=3;
                }else {
                    flyingStatus=0;
                }
            }
            if (y<0){
                if (flyingStatus==3){
                    flyingStatus=0;
                }else {
                    flyingStatus=1;
                }
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}