public class TestDemo3 {
    public static void main(String[] args) {
        /**
         * long占据8个字节，float占据4个字节
         * float表示数的范围比long大
         * 大的可以直接接受小的，小的接受大的需要强制类型转换
         */
        long l=123456;
        float f=123.456F;
        //l=f;
        f=(float) l;
        System.out.println(l);
        System.out.println(f);
    }
}
