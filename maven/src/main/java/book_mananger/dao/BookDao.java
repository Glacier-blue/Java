package book_mananger.dao;

import book_mananger.model.Book;
import book_mananger.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public static boolean update(int id,int status){
        Connection connection = DBUtils.getConnect();
        PreparedStatement statement = null;
        String sql = "update book set status = ? where id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,status);
            statement.setInt(2,id);
            int ret = statement.executeUpdate();
            return ret > 0;
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,null);
        }
    }
    public static Book selectBookById(int id){
        Connection connection = DBUtils.getConnect();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from book where id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                Book book = new Book();
                book.id = resultSet.getInt("id");
                book.number = resultSet.getString("number");
                book.name = resultSet.getString("name");
                book.status = resultSet.getInt("status");
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }
        return null;
    }
    public static List<Book> selectBook(String msg){
        List<Book> books = new ArrayList<>();
        Connection connection = DBUtils.getConnect();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from book where name like ? or id = ? or number = ?";
        try {
            statement = connection.prepareStatement(sql);
            String name = "%" + msg + "%";
            statement.setString(1,name);
            statement.setString(2,msg);
            statement.setString(3,msg);
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
    public static boolean add(Book book){
        Connection connection = DBUtils.getConnect();
        String sql = "insert into book value (null,?,?,0)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, book.number);
            statement.setString(2, book.name);
            int ret = statement.executeUpdate();
            return ret > 0;
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,null);
        }
    }
}
