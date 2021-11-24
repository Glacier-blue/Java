package day1124;

import java.util.Scanner;

/**
 * 1、引用类型和整数类型无法公用判断相等的体系
 * 2、getpos返回值若为泛型，无法处理异常情况
 */

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> a=new MyArrayList<String>();
        a.add(0,"abc");
        a.add(1,"cdf");
        a.add(0,"qwewe");
        a.display();
    }
}
