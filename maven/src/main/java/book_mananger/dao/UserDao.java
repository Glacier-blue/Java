package book_mananger.dao;

import book_mananger.utils.DBUtils;
import book_mananger.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static User selectBySID(String sid){
        Connection connection = DBUtils.getConnect();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where sid = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,sid);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                User user = new User();
                user.id = resultSet.getInt("id");
                user.sid = sid;
                user.name = resultSet.getString("name");
                user.password = resultSet.getString("password");
                user.authority = resultSet.getInt("authority");
                user.booksNum = resultSet.getInt("bookNum");
                return user;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }
        return null;
    }
    public static List<User> selectByName(String msg){
        List<User> users = new ArrayList<User>();
        Connection connection = DBUtils.getConnect();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where name like ? or sid = ?";
        try {
            statement = connection.prepareStatement(sql);
            String name = "%" + msg + "%";
            String sid = msg;
            statement.setString(1,name);
            statement.setString(2,sid);
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.id = resultSet.getInt("id");
                user.sid = resultSet.getString("sid");
                user.name = resultSet.getString("name");
                user.authority = resultSet.getInt("authority");
                user.booksNum = resultSet.getInt("bookNum");
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }
    }
    public static boolean add(User user)  {
        Connection connection = DBUtils.getConnect();
        String sql = "insert into user value (null,?,?,0,0,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.sid);
            statement.setString(2, user.name);
            statement.setString(3, user.password);
            int ret = statement.executeUpdate();
            return ret > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,null);
        }
    }
}
