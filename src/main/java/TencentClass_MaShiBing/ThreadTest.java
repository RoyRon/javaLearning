package TencentClass_MaShiBing;

/**
 * @author 江映锋
 * Create on 2019/03/26
 */
public class ThreadTest implements Runnable {
    static int i=0;
    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
        Thread thread1 = new Thread(t);
//        Thread thread2 = new Thread(t);
        thread1.start();
//        thread2.start();
        t.m2();
    }



    public synchronized void m1() throws InterruptedException {
        i = 100;
        Thread.sleep(1);
        System.out.println("m1:" + i);
    }

    public synchronized void  m2() {
        i = 2;
        System.out.println("m2:" + i);
    }

    @Override
    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
