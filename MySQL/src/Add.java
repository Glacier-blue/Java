import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add {
    public static void main(String[] args) throws SQLException {
        //创建DataSource对象
        DataSource ds=new MysqlDataSource();
        //配置信息，以便能够访问到数据库的服务器
        //需要进行向下转型
        ((MysqlDataSource) ds).setURL("jdbc:mysql://127.0.0.1:3306/javastudy?characterEncoding=utf-8&&useSSL=true");
        ((MysqlDataSource) ds).setUser("root");
        ((MysqlDataSource) ds).setPassword("wangfuming1021");
        Connection connection = ds.getConnection();
        //拼接SQL语句
        //插入操作
        int id=1;
        String name="曹操";
        int classId=10;
        String sql="insert into student values(?,?,?)";
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.setString(2,name);
        statement.setInt(3,classId);
        int ret=statement.executeUpdate();
        System.out.println("ret:"+ret);

        statement.close();
        connection.close();
    }
}
