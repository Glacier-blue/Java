package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: 12629
 * Date: 2021/11/15
 * Time: 19:55
 * Description: 默认放到数组的最后一个位置
 */
public class AddOperation implements IOperation{

    public void work(BookList bookList) {
        System.out.println("新增图书！");
        System.out.println("请输入图书的名字:");
        String name = scanner.nextLine();
        System.out.println("请输入图书的作者:");
        String author = scanner.nextLine();
        System.out.println("请输入图书的类型:");
        String type = scanner.nextLine();
        System.out.println("请输入图书的价格:");
        int price = scanner.nextInt();

        Book book = new Book(name,author,price,type);
        int size = bookList.getUsedSize();
        bookList.setBook(size,book);
        bookList.setUsedSize(size+1);
        System.out.println("新增图书成功！");
    }

}
