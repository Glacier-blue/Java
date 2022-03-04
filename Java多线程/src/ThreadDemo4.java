import static java.lang.Thread.*;

public class ThreadDemo4 {
    //第二种方式，即使线程在休眠也可以感受到中断
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("通过异常收到了中断情况");
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().isInterrupted());
            }
        }
    }
    public static void main6(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        thread.start();
        thread.interrupt();
    }
    //清除标志位
    public static void main5(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.interrupted());
                }
            }
        };
        t.start();
        t.interrupt();
    }
    //不清除标志位
    public static void main4(String[] args){
        Thread t=new Thread(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        };
        t.start();
        System.out.println("中断启动");
        t.interrupt();
    }
    //这个对捕捉的异常进行处理
    public static void main3(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("正在执行");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        t.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请求终止执行");
        t.interrupt();
    }
    //通过interrupt进行中断，抛出的异常被捕捉后没有做处理
    public static void main2(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run() {
                while(!Thread.currentThread().isInterrupted()){
                    System.out.println("正在执行");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请求终止执行");
        t.interrupt();
    }

    //通过共享标志位进行中断
    private static boolean isQuit=false;
    public static void main1(String[] args) {
        Thread t=new Thread(){
            @Override
            public void run(){
               while(!isQuit){
                   System.out.println("正在执行");
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
                System.out.println("终止执行");
            }
        };
        t.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请求终止执行");
        isQuit=true;
    }
}
