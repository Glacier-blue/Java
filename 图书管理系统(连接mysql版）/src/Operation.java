import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operation {
    public void add() throws SQLException {
        Scanner sc=new Scanner(System.in);
        System.out.println("新增图书");
        System.out.print("name:");
        String name=sc.nextLine();
        System.out.print("author:");
        String author=sc.nextLine();
        System.out.print("price:");
        double price=sc.nextDouble();
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/lms?characterEncoding=utf-8&&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("wangfuming1021");
        Connection connection= dataSource.getConnection();
        String sql="insert into book values(null,?,?,?,'在馆')";
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setString(1,name);
        statement.setString(2,author);
        statement.setDouble(3,price);
        int ret=statement.executeUpdate();
        if(ret>0){
            System.out.println("新增图书成功");
        }else{
            System.out.println("新增图书失败");
        }
        statement.close();
        connection.close();
    }
    public void delete(int id) throws SQLException {
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/lms?characterEncoding=utf-8&&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("wangfuming1021");
        Connection connection= dataSource.getConnection();
        String sql="update book set state = '下架' where id=?";
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setInt(1,id);
        int ret =statement.executeUpdate();
        if(ret==0){
            System.out.println("删除异常");
        }
        statement.close();
        connection.close();
    }
    public void borrowBook(int bookId,String studentId) throws SQLException {
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/lms?characterEncoding=utf-8&&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("wangfuming1021");
        Connection connection= dataSource.getConnection();
        String sql="update book set state = '借出' where id=?";
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setInt(1,bookId);
        int ret =statement.executeUpdate();
        if(ret==0){
            System.out.println("借书异常");
        }
        String sql2="insert into borrow values(?,?)";
        statement= connection.prepareStatement(sql2);
        statement.setInt(2,bookId);
        statement.setString(1,studentId);
        ret =statement.executeUpdate();
        if(ret==0){
            System.out.println("借书异常");
        }
        statement.close();
        connection.close();
    }
    public void returnBook(int bookId,String studentId) throws SQLException {
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/lms?characterEncoding=utf-8&&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("wangfuming1021");
        Connection connection= dataSource.getConnection();
        String sql="update book set state = '在馆' where id=?";
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setInt(1,bookId);
        int ret =statement.executeUpdate();
        if(ret==0){
            System.out.println("还书异常");
        }
        String sql2="delete from borrow where book_id=?";
        statement= connection.prepareStatement(sql2);
        statement.setInt(1,bookId);
        ret =statement.executeUpdate();
        if(ret==0){
            System.out.println("还书异常");
        }
        statement.close();
        connection.close();
    }
    public void find(String name) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/lms?characterEncoding=utf-8&&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("wangfuming1021");
        Connection connection = dataSource.getConnection();
        String sql = "select* from book where name=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();
        List<Book> list = new ArrayList<>();
        while (resultSet.next()) {
            String name1 = resultSet.getString(2);
            String author = resultSet.getString(3);
            Double price = resultSet.getDouble(4);
            String state = resultSet.getString(5);
            Book book = new Book(name1, author, price, state);
            list.add(book);
        }
        if (list.size() == 0) {
            System.out.println("未查询到结果");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
    public void find() throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/lms?characterEncoding=utf-8&&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("wangfuming1021");
        Connection connection = dataSource.getConnection();
        String sql = "select* from book";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Book> list = new ArrayList<>();
        while (resultSet.next()) {
            String name1 = resultSet.getString(2);
            String author = resultSet.getString(3);
            Double price = resultSet.getDouble(4);
            String state = resultSet.getString(5);
            Book book = new Book(name1, author, price, state);
            list.add(book);
        }
        if (list.size() == 0) {
            System.out.println("未查询到结果");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }



    public User log(String id,String password) throws SQLException {
        DataSource dataSource=new MysqlDataSource();
        ((MysqlDataSource) dataSource).setURL("jdbc:mysql://127.0.0.1:3306/lms?characterEncoding=utf-8&&useSSL=true");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("wangfuming1021");
        Connection connection= dataSource.getConnection();
        String sql="select*from user where id=? and password=?";
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setString(1,id);
        statement.setString(2,password);
        ResultSet resultSet=statement.executeQuery();
        if(!resultSet.next()) return null;
        String name=resultSet.getString(2);
        String tele=resultSet.getString(4);
        String mail=resultSet.getString(5);
        String power=resultSet.getString(6);
        return new User(id,name,password,tele,mail,power);
    }



}
