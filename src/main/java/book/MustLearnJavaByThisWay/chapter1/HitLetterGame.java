package book.MustLearnJavaByThisWay.chapter1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description: TODO 1、做满天星星 2、将星星改成10个随机字母 3、让字母下落。如果落出屏幕就产生新的字母，并从屏幕上方重新出现
 * TODO 4、接收键盘输入并消除匹配的字母 5、积分程序
 * @date 2020/10/27 23:52
 */
public class HitLetterGame {
    public static void main(String[] args) {
        Frame frame = new Frame();
        HitLetterGamePanel panel = new HitLetterGamePanel();
        Thread thread = new Thread(panel);
        frame.setSize(400, 300);
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

class HitLetterGamePanel extends Panel implements Runnable {
    char[] datas = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    int j;
    int[] x = new int[10];
    int[] y = new int[10];
    String[] numbers = new String[10];

    public HitLetterGamePanel() {
        for (int i = 0; i < 10; i++) {
            j = (int) (Math.random() * 10);
            x[i] = (int) (Math.random() * 350);
            y[i] = (int) (Math.random() * 250);
            numbers[i] = String.valueOf(datas[j]);
        }
    }

    public void paint(Graphics g) {

        for (int i = 0; i < 10; i++) {
            g.drawString(numbers[i], x[i], y[i]);
//            g.drawString(String.valueOf(num),x[i],y[i]);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                if (y[i] > 250) {
                    y[i] = 0;
                    x[i] = (int) (Math.random() * 350);
                    numbers[i] = String.valueOf(datas[(int) (Math.random() * 10)]);
                }
                y[i]++;

                repaint();
            }

        }
    }
}