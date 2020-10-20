package MustLearnJavaByThisWay;

import java.awt.*;

/**
 * @author 光影风
 * @description: TODO
 * @date 2020/10/20 8:49
 */
public class DrawTortoise {
    public static void main(String args[]){
        Frame frame=new Frame();
        frame.setSize(500,500);
        Mypanel p=new Mypanel();
        frame.add(p);
        frame.show();

    }
}
class Mypanel extends Panel{
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(200,200,90,105);
        g.setColor(Color.RED);
        g.drawOval(230,170,30,30);
        g.drawOval(170,210,30,30);
        g.drawOval(285,210,30,30);
        g.drawOval(170,250,30,30);
        g.drawOval(285,250,30,30);
        g.drawLine(245,300,245,355);
    }
}
