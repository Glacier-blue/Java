import book.BookList;
import user.Admin;
import user.Ordinary;
import user.Ordinary;
import user.User;

import java.util.Scanner;
import user.*;

public class Main {

    public static User login() {
        System.out.println("请输入你的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请输入你的身份：1-》管理员,0-》普通用户");
        int choice = scanner.nextInt();
        if(choice == 1) {
            return new Admin(name);
        }else {
            return new Ordinary(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();//向上转型
        while (true) {
            int choice = user.menu();//发生了动态绑定  -》 多态
            //根据你的choice 调用合适的操作
            user.doWork(choice, bookList);
        }
    }
}
