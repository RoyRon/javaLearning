package book.MustLearnJavaByThisWay;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description: TODO
 * @date 2020/10/20 9:08
 */
public class DrawStar {
    public static void main(String args[]){
        Frame frame=new Frame();
        frame.setSize(1920,1080);
        frame.setBackground(Color.black);
        MyPanel2 mypanel=new MyPanel2();
        frame.add(mypanel);
        frame.show();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(1);
            }
        });
    }
}
class MyPanel2 extends Panel{
    public void paint(Graphics g){
        g.setColor(Color.YELLOW);
        for (int i=0;i<300;i++) {
            g.drawString("*", (int)(Math.random()*1920), (int)(Math.random()*1080));
//            g.drawString("*",i,i);
        }
    }
}
