package jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public void delete(int id) throws SQLException {
        Connection connection= DBUtils.getConnection();
        String sql="delete from msg where id=?";
        assert connection != null;
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setInt(1,id);
        int ret=statement.executeUpdate();
        if(ret>=0){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败");
        }
        DBUtils.close(connection,statement,null);
    }
}
