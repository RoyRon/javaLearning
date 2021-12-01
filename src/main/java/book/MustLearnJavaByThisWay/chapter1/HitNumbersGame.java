package book.MustLearnJavaByThisWay.chapter1;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description: TODO 1、做满天星星 2、将星星改成10个随机字母 3、让字母下落。如果落出屏幕就产生新的字母，并从屏幕上方重新出现
 * TODO 4、接收键盘输入并消除匹配的字母 5、积分程序
 * @date 2020/10/27 23:52
 */
public class HitNumbersGame {
    public static void main(String args[]) {
        Frame frame = new Frame();
        HitLetterGamePanel panel = new HitLetterGamePanel();
        Thread thread = new Thread(panel);
        frame.setSize(400, 300);
        frame.add(panel);
        thread.start();
        frame.addKeyListener(panel);
        panel.addKeyListener(panel);
        frame.show();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class HitLetterGamePanel extends Panel implements Runnable, KeyListener {
    char[] datas = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}; //不知道怎么输入随机字母，所以选择了用一个字符数组自定义落入屏幕的数据
    int j;
    int[] x = new int[10];
    int[] y = new int[10];
    String[] numbers = new String[10];
    int score = 0;
    boolean mark = false;

    public HitLetterGamePanel() {
        for (int i = 0; i < 10; i++) {
            j = (int) (Math.random() * 10);
            //x,y坐标没取面板边界，因为取边界会有部分数字被边界遮挡
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
        //分数可以用写在面板上
        g.setColor(Color.RED);
        g.drawString(score + "", 250, 10);
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
                    score = score - 10;
                    System.out.println("Miss,得分-10: " + score);
                    y[i] = 0;
                    x[i] = (int) (Math.random() * 350);
                    numbers[i] = String.valueOf(datas[(int) (Math.random() * 10)]);
                }
                y[i]++;

                repaint();
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (int i = 0; i < 10; i++) {
            if (String.valueOf(e.getKeyChar()).equals(numbers[i])) {
//                System.out.println("keyChar:"+String.valueOf(e.getKeyChar()));
//                System.out.println("numbers:"+numbers[i]);

                y[i] = 0;

                x[i] = (int) (Math.random() * 350);
                numbers[i] = String.valueOf(datas[(int) (Math.random() * 10)]);
                mark = true;

                break; //加上break防止输入一次，消掉多个数字
            }else {
                mark=false;
            }
//            else {
//                score=score-20;
//                System.out.println("Wrong,得分-20: "+score);
//            } 这段代码是错误的；输错减分，有10个数字，输对1个的同时，有9个不匹配的，会多扣9*20分，所以不能这样直接else减分，需要引入一个变量存储整个遍历后，是匹配成功还是失败，成功加分，匹配减分

        }
        if (mark) {
            score +=  5;
            System.out.println("Hit,得分+5: " + score);
        } else {
            score -=  20;
            System.out.println("Wrong,得分-20: " + score);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}