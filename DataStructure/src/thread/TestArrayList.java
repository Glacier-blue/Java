package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i = 1000;i<2000;i++){
                    list.add(i);
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0;i<1000;i++){
                    list.add(i);
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(list.size());
    }
    public static void main1(String[] args) throws InterruptedException {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        Thread t1 = new Thread(){
            @Override
            public void run() {
                for(int i = 0;i<20;i++){
                    list.add(i);
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                for(int i = 0;i<20;i++){
                    list.add(i);
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
