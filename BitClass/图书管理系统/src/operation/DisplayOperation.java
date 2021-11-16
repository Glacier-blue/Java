package operation;

import book.Book;
import book.BookList;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;


public class DisplayOperation implements IOperation{
    public void work(BookList bookList) {
        System.out.println("打印图书！");
        int size = bookList.getUsedSize();
        for (int i = 0; i < size; i++) {
            Book book = bookList.getPos(i);//bookList[i]
            System.out.println(book);
        }
    }
}
