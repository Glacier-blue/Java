package binary;

public class Test {
    public static void main(String[] args) {
        BinaryFind binaryFind = new BinaryFind();
        int[] nums = {1,3,5,7,9};
        int ret = binaryFind.leftBound2(nums,2);
        System.out.println(ret);
    }
}
