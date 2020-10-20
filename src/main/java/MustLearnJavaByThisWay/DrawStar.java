package MustLearnJavaByThisWay;

import java.awt.*;

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
    }
}
class MyPanel2 extends Panel{
    public void paint(Graphics g){
        g.setColor(Color.YELLOW);
        g.drawString("*",500,500);
    }
}
