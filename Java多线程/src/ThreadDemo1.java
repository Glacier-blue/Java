
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("我是一个新线程");
    }
}
public class ThreadDemo1 {

    public static void main(String[] args) {
        Thread t=new Thread(()-> System.out.println("这是一个新线程"));
        t.start();
    }
    public static void main4(String[] args) {
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个线程");
            }
        };
        Thread t=new Thread(runnable);
        t.start();
    }

    public static void main3(String[] args) {
        Thread t=new Thread(new MyRunnable());
        t.start();
    }

    public static void main2(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                System.out.println("这是一个新线程");
            }
        };
        t.start();
    }


    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("hello word，这是一个线程");
        }
    }

    /**
     * 创建线程需要使用Thread类，来创建一个Thread实例
     * 还需要指定给线程指定要执行那些代码
     * 这里使用直接继承Thread类的方法
     */
    public static void main1(String[] args) {
        //当 Thread 对象被创建出来的时候, 内核中并没有随之产生一个线程(PCB).
        Thread myThread=new MyThread();
        //调用start后，代码执行后内核创建（线程）PCB
        //执行上面run方法的代码
        myThread.start();
    }
}
