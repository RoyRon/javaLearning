package book.MustLearnJavaByThisWay.chapter1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description: TODO 第二次
 * @date 2020/10/28 9:13
 */
public class SnowRepeat20Times {
    public static void main(String args[]){
        Frame frame=new Frame();
        SnowPanel panel=new SnowPanel();
        Thread thread=new Thread(panel);
        frame.setSize(1920,1080);
        frame.setBackground(Color.black);
        frame.add(panel);
        thread.start();
        frame.show();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
class SnowPanel extends Panel implements Runnable{
    int[]x=new int[3000];
    int [] y=new int[3000];
    SnowPanel(){
        for (int i=0;i<300;i++){
            x[i]=(int)(Math.random()*1920);
            y[i]=(int)(Math.random()*1080);
        }
    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        for (int i=0;i<3000;i++){
        g.drawString("*",x[i],y[i]);
    }}

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i=0;i<3000;i++){
                if (y[i]>1080){
                    y[i]=0;
                }
                y[i]++;
                repaint();
            }
        }
    }
}