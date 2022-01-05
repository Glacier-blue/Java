

public class ThreadDemo1 {

    private long count=100_0000_0000L;
    public static void main2(String[] args) throws InterruptedException {
        ThreadDemo1 threadDemo1=new ThreadDemo1();
        long start=System.currentTimeMillis();
        threadDemo1.serival();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        threadDemo1.concurrency();
        // 执行时间由11s->3s
    }

    public  void serival(){
        long a=0;
        for(long i=0;i<count;i++){
            a++;
        }
        long b=0;
        for(long i=0;i<count;i++){
            b++;
        }
    }

    /**
     * t1，t2和main都是并发执行的
     */
    public void concurrency() throws InterruptedException {
        long start=System.currentTimeMillis();
        //匿名内部类
        Thread thread1=new MyThread(){
            @Override
            public void run() {
                long a=0;
                for(long i=0;i<count;i++){
                    a++;
                }
            }
        };
        Thread thread2=new MyThread(){
            @Override
            public void run() {
                long a=0;
                for(long i=0;i<count;i++){
                    a++;
                }
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

/**
 * ---------------------------------------分割线--------------------------------------------------------------------
 */
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
