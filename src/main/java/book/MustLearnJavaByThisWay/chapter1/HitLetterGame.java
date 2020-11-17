package book.MustLearnJavaByThisWay.chapter1;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 光影风
 * @description: TODO
 * @date 2020/11/4 8:30
 */
public class HitLetterGame {
    public static void main(String args[]) {
//        System.out.println((int)'a');

        Frame frame = new Frame();
        LetterPanel panel = new LetterPanel();
        Thread thread = new Thread(panel);
        frame.setSize(300, 400);
        frame.add(panel);
        thread.start();
        frame.addKeyListener(panel);
        panel.addKeyListener(panel);
//        char[] c={'a','b','c','a','a'};
//        panel.findDownmostLetter(c);
        frame.show();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class LetterPanel extends Panel implements Runnable, KeyListener {
    char[] letters = new char[10];
    int[] x = new int[10];
    int[] y = new int[10];
    int score = 0;
    boolean mark = false;


    LetterPanel() {
        for (int i = 0; i < 10; i++) {
            letters[i] = (char) (Math.random() * 26 + 97);
            x[i] = (int) (Math.random() * 250);
            y[i] = (int) (Math.random() * 350);
        }
    }

    public void paint(Graphics g) {
        Font font = new Font("myFont", 2, 15);
        g.setFont(font);
        for (int i = 0; i < 10; i++) {
            g.drawString(new Character(letters[i]).toString(), x[i], y[i]);
        }
        g.setColor(Color.RED);
        g.drawString(String.valueOf(score), 200, 10);
    }

    @Override
    public void run() {
        while (true) {

            for (int i = 0; i < 10; i++) {
                y[i]++;
                if (y[i] > 350) {
                    y[i] = 0;
                    x[i] = (int) (Math.random() * 250);
                    letters[i] = (char) (Math.random() * 26 + 97);
                    score -= 10;
                    System.out.println("Miss,score-10: " + score);

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
        int nowIndex = -1; //局部变量，每点击一次键盘使用一次，不能定义在类，不然nowIndex一旦变成不是-1就永远不是-1了，导致输入字母与画布字母不匹配也会得分的bug
        int maxY = -1;
//System.out.println(e.getKeyChar());
        for (int i = 0; i < 10; i++) {
            if (e.getKeyChar() == letters[i]) {
                System.out.println(e.getKeyChar());
                if (y[i] > maxY) {
                    maxY = y[i];
                    nowIndex = i;
                }
            }
        }

        if (nowIndex != -1) {
            score += 5;
            y[nowIndex] = 0;
            x[nowIndex] = (int) (Math.random() * 250);
            letters[nowIndex] = (char) (Math.random() * 26 + 97);
            //  repaint();
            System.out.println("Hit,score+5: " + score);
        } else {
            score -= 20;
            System.out.println("Wrong,score-20: " + score);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public int findDownmostLetter(char[] letters) {
        int nowIndex = -1;
        int maxY = 0;
        for (int i = 0; i < 5; i++) {
            if ('a' == letters[i]) {
                if (y[i] >= maxY) {
                    maxY = y[i];
                    nowIndex = i;
                }
            }

        }
        System.out.println("a最大的y坐标" + nowIndex);
        return nowIndex;

    }
}
