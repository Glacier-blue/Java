package user;

import book.BookList;
import operation.IOperation;

/**
 * Created with IntelliJ IDEA.
 * User: 12629
 * Date: 2021/11/15
 * Time: 20:03
 * Description:
 */
public abstract class User {
    protected String name;

    protected IOperation[] iOperations;

    public User(String name) {
        this.name = name;
    }
    public abstract int menu();


    public void doWork(int choice, BookList bookList) {
        iOperations[choice].work(bookList);
    }

}
