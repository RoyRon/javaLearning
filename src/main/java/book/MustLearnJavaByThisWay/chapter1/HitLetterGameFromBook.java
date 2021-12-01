package book.MustLearnJavaByThisWay.chapter1;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description: TODO
 * @date 2020/11/17 8:32
 */
public class HitLetterGameFromBook {
    public static void main(String args[]) {
        Frame frame = new Frame();
        MyPanel3 panel3 = new MyPanel3();
        Thread thread = new Thread(panel3);
        frame.setSize(300, 400);
        frame.add(panel3);
        frame.addKeyListener(panel3);
        panel3.addKeyListener(panel3);
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

class MyPanel3 extends Panel implements Runnable, KeyListener {
    int[] x = new int[10];
    int[] y = new int[10];
    char[] c = new char[10];
    int score = 0;

    MyPanel3() {
        for (int i = 0; i < 10; i++) {
            x[i] = (int) (Math.random() * 250);
            y[i] = (int) (Math.random() * 350);
            c[i] = (char) (Math.random() * 26 + 97); //乘以的是范围，26个字母就乘以26
        }

    }

    public void paint(Graphics g) {
        for (int i = 0; i < 10; i++) {
            g.drawString(new Character(c[i]).toString(), x[i], y[i]);
        }
        g.setColor(Color.RED);
        g.drawString(String.valueOf(score),200,15);
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                y[i]++;
                if (y[i] > 350) {
                    y[i] = 0;
                    x[i] = (int) (Math.random() * 250);
                    c[i] = (char) (Math.random() * 26 + 97);
                    score-=20;
                    System.out.println("错过了，减20分："+score);
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyChar = e.getKeyChar();
        int nowY = -1;
        int nowIndex = -1;
        for (int i = 0; i < 10; i++) {
            if (keyChar == c[i]) {
                if (y[i] > nowY) {
                    nowY = c[i];
                    nowIndex = i;
                }
            }
        }
        if (nowIndex != -1) {
            y[nowIndex] = 0;
            x[nowIndex] = (int) (Math.random() * 250);
            c[nowIndex] = (char) (Math.random() * 26 + 97);
            score += 5;
            System.out.println("答对了,是" + keyChar + ",加5分：" + score);
        } else {
            score -= 10;
            System.out.println("答错了，减10分：" + score);

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
