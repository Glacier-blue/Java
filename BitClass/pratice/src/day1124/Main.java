package day1124;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyArrayList<String> a=new MyArrayList<String>();
        a.add(0,"abc");
        a.add(1,"cdf");
        a.add(0,"qwewe");
        a.display();
    }
}
