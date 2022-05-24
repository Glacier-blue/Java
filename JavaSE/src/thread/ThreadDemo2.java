package thread;

public class ThreadDemo2 {
    private final long count= 10000000000L;


    public static void main(String[] args) throws InterruptedException {
        ThreadDemo2 threadDemo2=new ThreadDemo2();
        long start=System.currentTimeMillis();
        threadDemo2.func1();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
        threadDemo2.func2();
        // 执行时间由11s->3s
    }

    public void func1(){
        int temp=0;
        for(long i=0;i<count;i++){
            if((i&1)==1){
                temp++;
            }
        }
        for(long i=0;i<count;i++){
            if((i&1)==1){
                temp--;
            }
        }
    }
    /**
     * t1，t2和main都是并发执行的
     */
    public void func2() throws InterruptedException {
        long start=System.currentTimeMillis();
        //匿名内部类
        Thread thread1=new ThreadDemo1.MyThread(){
            @Override
            public void run() {
                int tmp=0;
                for(long i=0;i<count;i++){
                    if((i&1)==1){
                        tmp--;
                    }
                }
            }
        };
        Thread thread2=new ThreadDemo1.MyThread(){
            @Override
            public void run() {
                for(long i=0;i<count;i++){
                    int tmp=0;
                    if((i&1)==1){
                        tmp++;
                    }
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
}
