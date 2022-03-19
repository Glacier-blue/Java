package jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    public void update(int id,String name) throws SQLException {
        Connection connection= DBUtils.getConnection();
        String sql="update msg set name=? where id=?";
        assert connection != null;
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setInt(2,id);
        statement.setString(1,name);
        int ret=statement.executeUpdate();
        if(ret>=0){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
        DBUtils.close(connection,statement,null);
    }
}
