import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Delete {
    public static void main(String[] args) throws SQLException {
        //创建DataSource对象
        DataSource ds=new MysqlDataSource();
        //配置信息，以便能够访问到数据库的服务器
        //需要进行向下转型
        ((MysqlDataSource) ds).setURL("jdbc:mysql://127.0.0.1:3306/javastudy?characterEncoding=utf-8&&useSSL=true");
        ((MysqlDataSource) ds).setUser("root");
        ((MysqlDataSource) ds).setPassword("wangfuming1021");
        Connection connection = ds.getConnection();
        int id=1;
        String sql="delete from student where id=(?)";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setInt(1,id);
        int ret=statement.executeUpdate();
        System.out.println("ret:"+ret);
        statement.close();
        connection.close();
    }
}
