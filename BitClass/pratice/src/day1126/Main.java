package day1126;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(0,0);
        System.out.println(list);
    }
    public static void main2(String[] args) {
        ArrayList<String> list=new ArrayList<String>();
        list.add(0,"asda");
        list.add(0,"asdasda");
        System.out.println(list);
    }
    public static void main1(String[] args) {
        Integer a=128;
        Integer b=128;
        System.out.println(a==b);
    }
}
