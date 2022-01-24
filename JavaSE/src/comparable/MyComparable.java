package comparable;

import java.util.Arrays;


public class MyComparable {
    public static void main1(String[] args) {
        Stu[] students=new Stu[5];
        students[0]=new Stu("zhangsan","0002",98.76);
        students[1]=new Stu("lisi","0001",98.45);
        students[2]=new Stu("wangwu","0003",78.56);
        students[3]=new Stu("wangermazi","0005",89.56);
        students[4]=new Stu("wangyi","0004",90.87);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
