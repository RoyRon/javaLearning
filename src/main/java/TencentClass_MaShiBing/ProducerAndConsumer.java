package TencentClass_MaShiBing;

/**
 * @author 江映锋
 * Create on 2019/03/28
 */
public class ProducerAndConsumer {

    public static void main(String[] args) {
        SysnStack sysnStack = new SysnStack();
        Producer producer = new Producer(sysnStack);
        Consumer consumer = new Consumer(sysnStack);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }}

      class Cake {
         int id;

        public Cake(int id) {
            this.id = id;
        }
    }

    class SysnStack {
        int index = 0;
        Cake[] cakes = new Cake[6];


        public synchronized void put(Cake cake) throws InterruptedException {
            while (index==cakes.length){
                //在方法前加了关键字synchronized才能使用wait（）和notify（）方法
                this.wait();
            }
            this.notify();
            cakes[index] = cake;
            System.out.println("生产了一个蛋糕" + cakes[index].id);
            Thread.sleep(1);
            index++;

        }

        /**
         * @return
         * @throws InterruptedException
         */
        public synchronized Cake pop() throws InterruptedException {
            while (index==0){
                this.wait();
            }
            this.notify();
            index--;
            System.out.println("消费了一个蛋糕" + cakes[index].id);
            Thread.sleep(1);
            return cakes[index];
        }
    }

     class Producer implements Runnable {
        SysnStack sysnStack = null;

        Producer(SysnStack sysnStack) {
            this.sysnStack = sysnStack;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    sysnStack.put(new Cake(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        private SysnStack sysnStack;

        /**
         * @param sysnStack
         */
        Consumer(SysnStack sysnStack) {
            this.sysnStack = sysnStack;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    sysnStack.pop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

