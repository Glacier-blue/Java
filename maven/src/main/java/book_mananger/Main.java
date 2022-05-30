package book_mananger;

import book_mananger.controller.BookController;
import book_mananger.controller.UserController;
import book_mananger.dao.BookDao;
import book_mananger.dao.BorrowDao;
import book_mananger.model.Book;
import book_mananger.model.User;

import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    UserController userController = new UserController();
    BookController bookController = new BookController();
    public User firstMenu(){
        User user = null;
        System.out.println("*********欢迎来到图书管理系统*********\n*********1、登录(Login)*********\n" +
                "*********2、注册*********\n*********other、退出*********");
        while(user==null){
            System.out.print("输入命令>>>");
            int n = sc.nextInt();
            if(n==1){
                sc.nextLine();
                System.out.print("账号>>>");
                String sid = sc.nextLine();
                System.out.print("密码>>>");
                String password = sc.nextLine();
                user = userController.login(sid,password);
            }else if(n==2){
                user = userController.register();
            }else{
                System.exit(0);
            }
        }
        return user;
    }
    public void userMenu(User user){
        if(user==null){
            System.out.println("异常进入系统，强制退出");
            System.exit(0);
        }
        System.out.println("*********1、查找图书*********");
        System.out.println("*********2、借阅图书*********");
        System.out.println("*********3、查找借阅记录*********");
        System.out.println("*********4、查找在借书籍*********");
        System.out.println("*********5、归还图书*********");
        System.out.println("*********0、退出系统*********");
        int n = sc.nextInt();
        sc.nextLine();
        if(n==1){
            System.out.print("查找图书>>>输入图书信息，编号或者名字等>>>");
            String msg = sc.nextLine();
            List<Book> books = BookDao.selectBook(msg);
            display1(books);
        }else if(n==2){
            System.out.print("借阅图书>>>输入借阅图书id>>>");
            int id = sc.nextInt();
            Book book = BookDao.selectBookById(id);
            if(book==null) {
                System.out.println("书籍不存在");
                return;
            }
            if (book.status != 0) {
                System.out.println("书籍不存在或者已被借走，借阅失败");
            }
            BookDao.update(id,1);
            BorrowDao.borrow(user.id,id);
        }else if(n==3){
            List<Book> books = BorrowDao.borrowBook(user.id, 1);
            display1(books);
        }else if(n==4){
            List<Book> books = BorrowDao.borrowBook(user.id, 0);
            display1(books);
        }else if(n==5){
            System.out.print("归还图书id>>>>");
            int id = sc.nextInt();
            BorrowDao.back(user.id,id);
            BookDao.update(id,0);
        }else{
            System.exit(0);
        }
    }
    public void adminMenu(User user){
        if(user==null||user.authority==0){
            System.out.println("异常进入系统，强制退出");
            System.exit(0);
        }
        System.out.println("*********1、查找图书*********");
        System.out.println("*********2、新增图书*********");
        System.out.println("*********3、下架图书*********");
        System.out.println("*********0、退出系统*********");
        int n = sc.nextInt();
        if(n==1){
            System.out.println("输入图书信息，编号或者名字等");
            sc.nextLine();
            String msg = sc.nextLine();
            List<Book> books = BookDao.selectBook(msg);
            display1(books);
        }else if(n==2){
            bookController.add();
        }else if(n==3){
            System.out.println("下架图书id>>>>");
            int id = sc.nextInt();
            Book book = BookDao.selectBookById(id);
            if(book==null||book.status!=0){
                System.out.println("书籍不存在或者已被借走，删除失败");
            }
            BookDao.update(id,3);
        }else{
            System.exit(0);
        }
    }
    public void display1(List<Book> books){
        for(Book book:books){
            System.out.println(book);
        }
    }
    public void display2(List<User> users){
        for(User user:users){
            System.out.println(user);
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        User user = main.firstMenu();
        if(user==null){
            System.out.println("系统异常，强制退出");
            System.exit(0);
        }
        if(user.authority==0){
            while(true){
                main.userMenu(user);
            }
        }else{
            while(true){
                main.adminMenu(user);
            }
        }
    }
}
