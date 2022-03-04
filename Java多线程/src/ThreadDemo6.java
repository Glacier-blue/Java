import java.util.Scanner;

/**
 * 线程安全问题和锁
 */

public class ThreadDemo6 {

    static class MyThread implements Runnable{
        private int ticketNumber=10;
        @Override
        public void run() {
            for(int i=0;i<1000;i++){
                synchronized (this){
                    if(this.ticketNumber>0){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+",还有" +this.ticketNumber
                                -- +" 张票");
                    }
                }
            }
        }
    }

    public static void main3(String[] args) throws InterruptedException {
        MyThread mt = new MyThread() ;
        Thread t1 = new Thread(mt,"黄牛A");
        Thread t2 = new Thread(mt,"黄牛B");
        Thread t3 = new Thread(mt,"黄牛C");
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
    }
    public static void main(String[] args) {
        Object locker1 = new Object();
        Object locker2 = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                synchronized (locker1) {
                    System.out.println("请输入一个整数");
                    int num = scanner.nextInt(); // 用户如果不输入, 就会一直阻塞在 nextInt, 这个锁就会被一直占有
                    System.out.println("num = " + num);
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (locker2) {
                        System.out.println("线程2 获取到锁啦");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t2.start();
    }

    /**
     * 各自增加1万次，理论上为2万次
     */
    static class Counter{
        public int count=0;
        //加锁
        synchronized public void increase(){
            count++;
        }
    }
    public static void main1(String[] args) {
        Counter counter=new Counter();
        Thread t1=new Thread(){
          public void run(){
              for(int i=0;i<10000;i++){
                  counter.increase();
              }
          }
        };
        Thread t2=new Thread(){
            public void run(){
                for(int i=0;i<10000;i++){
                    counter.increase();
                }
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.count);
    }
}
