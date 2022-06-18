package circle;

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        long a = 100L;
        switch ((int) a){
            case 100:
                System.out.println("数1");
                break;
        }
    }
    public static void main2(String[] args) {
        String a = "ancdef";
        switch (a){
            case "ancdef":
                System.out.println("字符串1");
                break;
            case "ancdefg":
                System.out.println("字符串2");
                break;
            case "ancdefh":
                System.out.println("字符串3");
                break;
        }
    }
    public static void main1(String[] args) {
        char ch = 'b';
        switch (ch){
            case 'a':
                System.out.println("这是字符a");
                break;
            case 'b':
                System.out.println("这是字符b");
                break;
            case 'c':
                System.out.println("这是字符c");
                break;
        }
    }
}
