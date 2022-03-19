package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add {
    public void add(int id,String name) throws SQLException {
        Connection connection= DBUtils.getConnection();
        String sql="insert into msg values (?,?)";
        assert connection != null;
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        int ret=statement.executeUpdate();
        if(ret>=0){
            System.out.println("插入成功");
        }else{
            System.out.println("插入失败");
        }
        DBUtils.close(connection,statement,null);
    }
}
