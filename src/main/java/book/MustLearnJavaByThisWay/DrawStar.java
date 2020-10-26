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
    public static void main(String args[]) {
        Frame frame = new Frame();
        frame.setSize(1920, 1080);
        frame.setBackground(Color.black);
        MyPanel2 mypanel = new MyPanel2();
        frame.add(mypanel);
        frame.show();
        Thread thread = new Thread(mypanel);
        thread.start();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(1);
            }
        });
    }
}

class MyPanel2 extends Panel implements Runnable {
    int x = 0;
    int y = 0;

    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        for (int i = 0; i < 300; i++) {
            g.drawString("*", x = (int) (Math.random() * 1920), y = (int) (Math.random() * 1080));
//            g.drawString("*",i,i);
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
        while (true) {
            for (int i = 0; i < 300; i++) {
                x++;
                y++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                repaint();
            }
        }
    }
}
