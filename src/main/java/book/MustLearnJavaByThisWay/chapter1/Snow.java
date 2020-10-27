package book.MustLearnJavaByThisWay.chapter1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 江映锋
 * Created on 2020/10/26
 */
public class Snow {

    public static void main(String[] args) {
        Frame frame = new Frame();
        DrawSnow drawSnow = new DrawSnow();
        Thread thread = new Thread(drawSnow);
        frame.setBackground(Color.black);
        frame.setSize(1920, 1080);
        frame.add(drawSnow);
        thread.start();
        frame.show();
        frame.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}

class DrawSnow extends Panel implements Runnable {
    int[] x = new int[300];
    int[] y = new int[300];

    public DrawSnow() {
        for (int i = 0; i < 300; i++) {
            x[i] = (int) (Math.random() * 1920);
            y[i] = (int) (Math.random() * 1080);
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        for (int i = 0; i < 300; i++) {
            g.drawString("*", x[i], y[i]);
        }
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep((long)(Math.random()*10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        for (int i = 0; i < 300; i++) {
            if (y[i]>1080){
                y[i]=0;
            }

//            try {
//                Thread.sleep((long)(Math.random()*2));
//            } catch (InterruptedException e) {
//          e.printStackTrace();
//
//        }
            y[i]++;
            repaint();
        }
    }
}}