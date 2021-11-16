package user;
import operation.*;

import book.BookList;

import java.util.Scanner;



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
