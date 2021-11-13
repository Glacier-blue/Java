package com.bit.com;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Data[] data=new Data[3];
        data[0]=new Data(12,89.0,"zhangsan");
        data[1]=new Data(17,45.6,"lisi");
        data[2]=new Data(14,67.7,"wanger");
        AgeComparator ageComparator=new AgeComparator();
        Arrays.sort(data,ageComparator);
        System.out.println(Arrays.toString(data));
    }
}
