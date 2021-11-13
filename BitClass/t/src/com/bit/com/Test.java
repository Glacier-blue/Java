package com.bit.com;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Student[] students=new Student[3];
        students[0]=new Student(12,89.0,"zhangsan");
        students[1]=new Student(13,45.6,"lisi");
        students[2]=new Student(14,67.7,"wanger");
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
