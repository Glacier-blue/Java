package practice;

import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger num=new AtomicInteger(0);
        Thread t1=new Thread(){
            @Override
            public void run() {
                for(int i=0;i<=1000;i++){
                    num.addAndGet(2);
                }
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                for(int i=0;i<=1000;i++){
                    num.addAndGet(2);
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(num);
    }
}
