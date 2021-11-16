package operation;

import book.Book;
import book.BookList;

/**
 * Created with IntelliJ IDEA.
 * User: 12629
 * Date: 2021/11/15
 * Time: 19:55
 * Description:
 */
public class DelOperation implements IOperation{
    public void work(BookList bookList) {
        System.out.println("删除图书！");
        //1、根据书名找到书的位置 index
        System.out.println("请输入你要删除的图书的名字：");
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();
        int index = 0;//存储找到的下标
        int i = 0;
        for (; i < currentSize; i++) {
            Book book = bookList.getPos(i);
            if(book.getName().equals(name)) {
                index = i;
                break;
            }
        }
        if(i >= currentSize) {
            System.out.println("没有你要删除的这本书！");
            return;
        }
        // 2、进行删除
        for (int j = index; j < currentSize-1; j++) {
            //bookList[j] = bookList[j+1]
            Book book = bookList.getPos(j+1);
            bookList.setBook(j,book);
        }
        bookList.setBook(currentSize,null);

        bookList.setUsedSize(currentSize-1);
        System.out.println("删除成功！");
    }
}