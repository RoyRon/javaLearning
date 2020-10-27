package book.MustLearnJavaByThisWay.chapter1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description:
    TODO 1、做满天星星 2、将星星改成10个随机字母 3、让字母下落。如果落出屏幕就产生新的字母，并从屏幕上方重新出现
    TODO 4、接收键盘输入并消除匹配的字母 5、积分程序
 * @date 2020/10/27 23:52
 */
public class HitLetterGame {
    public static void main(String[]args){
        Frame frame=new Frame();
        HitLetterGamePanel panel=new HitLetterGamePanel();
        frame.setSize(400,300);
        frame.add(panel);
        frame.show();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
class HitLetterGamePanel extends Panel{
    public void paint(Graphics g){
        char[] x={'1','2','3','4','5','6','7','8','9','0'};
        int j=0;
        for (int i=0;i<10;i++){
            j=(int)(Math.random()*10);
            g.drawString(String.valueOf(x[j]),(int)(Math.random()*380),(int)(Math.random()*280));
        }
    }
}