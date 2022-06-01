package book_mananger.dao;

import book_mananger.model.Book;
import book_mananger.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowDao {
    public static boolean borrowing(int sid,int id){
        Connection connection = DBUtils.getConnect();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from borrow where status = 0 and sid = ? and bid = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,sid);
            statement.setInt(2,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }
    }
    public static List<Book> borrowBook(int sid,int status){
        List<Book> books = new ArrayList<>();
        Connection connection = DBUtils.getConnect();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select b.id,b.number,b.name,b.status from book b,borrow p where p.sid = ? and p.status = ? and b.id = p.bid";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,sid);
            statement.setInt(2,status);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Book book = new Book();
                book.id = resultSet.getInt("id");
                book.number = resultSet.getString("number");
                book.name = resultSet.getString("name");
                book.status = resultSet.getInt("status");
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }
    }
    public static boolean borrow(int sid,int bid)  {
        Connection connection = DBUtils.getConnect();
        String sql = "insert into borrow value (null,?,?,0)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sid);
            statement.setInt(2, bid);
            int ret = statement.executeUpdate();
            return ret > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,null);
        }
    }
    public static boolean back(int sid,int bid){
        Connection connection = DBUtils.getConnect();
        String sql = "update borrow set status = 1 where sid = ? and bid = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sid);
            statement.setInt(2, bid);
            int ret = statement.executeUpdate();
            return ret > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,null);
        }
    }
}
