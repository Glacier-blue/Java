import java.sql.ResultSet;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Select {
    public static void main(String[] args) throws SQLException {
        //创建DataSource对象
        DataSource ds=new MysqlDataSource();
        //配置信息，以便能够访问到数据库的服务器
        //需要进行向下转型
        ((MysqlDataSource) ds).setURL("jdbc:mysql://127.0.0.1:3306/javastudy?characterEncoding=utf-8&&useSSL=true");
        ((MysqlDataSource) ds).setUser("root");
        ((MysqlDataSource) ds).setPassword("wangfuming1021");
        Connection connection = ds.getConnection();
        String sql="select* from student where id=(?)";
        int id=1;
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setInt(1,1);
        ResultSet resultSet= statement.executeQuery();
        while(resultSet.next()){
            int a=resultSet.getInt(1);
            String b=resultSet.getString(2);
            int c=resultSet.getInt(3);
            System.out.println("id:   "+a+"  name:  "+b+"  class: "+c);

        }
        resultSet.close();

        statement.close();
        connection.close();
    }
}
