package book_mananger.controller;

import book_mananger.dao.BookDao;
import book_mananger.model.Book;

import java.util.Scanner;

public class BookController {
    public boolean add(){
        Scanner sc = new Scanner(System.in);
        Book book = new Book();
        System.out.println("新增操作，按照提示填写信息");
        System.out.print("编号>>>");
        book.number = sc.nextLine();
        System.out.print("书名>>>");
        book.name = sc.nextLine();
        return BookDao.add(book);
    }
}
