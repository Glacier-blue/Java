/**
 * 单例模式
 * 使用场景：不应该存在多个实例，此时就应该使用单例模式来解决
 */
public class ThreadDemo9 {
    /**
     * 单例模式之饿汉模式
     * 类加载时直接实例化
     */
    static class Singleton{
        private Singleton(){}
        static private Singleton instance=new Singleton();
        static public Singleton getInstance(){
            return instance;
        }
    }

    /**
     * 懒汉模式
     * 类加载时不会实例化
     * 在使用时才会实例化
     * 多线程不安全，原因就是不是原子性的，当多个线程尝试修改instance时不安全
     */
    static class Singledog{
        private Singledog(){}
        private static volatile Singledog instance=null;

        public static Singledog getInstance() {
            if(instance==null){
                /**
                 * 只需要对实例化时加锁
                 */
                synchronized (Singledog.class){
                    if (instance==null){
                        instance=new Singledog();
                    }
                }
            }
            return instance;
        }

//        public  static Singledog getInstance(){
//            synchronized (Singledog.class){
//                if (instance==null){
//                    instance = new Singledog();
//                }
//            }
//            return instance;
//        }

//        public synchronized static Singledog getInstance(){
//            if (instance==null){
//                instance = new Singledog();
//            }
//            return instance;
//        }

    }

    /**
     * 懒汉模式比饿汉模式效率高
     * 原因就是在程序执行过程中很有可能一直都用不到实例
     */
    public static void main(String[] args) {
        Singleton s1=Singleton.getInstance();
        Singleton s2=Singleton.getInstance();
        System.out.println(s1==s2);
        Singledog s3=Singledog.getInstance();
        Singledog s4=Singledog.getInstance();
        System.out.println(s3==s4);
    }
}
