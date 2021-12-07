public class TestDemo1 {
    public static void main(String[] args) {
        /**
         * 运算符的优先级性
         * 从左向右运算,后置++在运算后执行，前置++在运算前执行
         */
        int i=5;
        i+=i-=i*=i++;
        //i=i+i-i*i++;
        System.out.println(i);
    }
}
