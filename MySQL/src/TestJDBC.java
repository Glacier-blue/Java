
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestJDBC {
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

        sql="select* from student where id=(?)";
        id=1;
        statement= connection.prepareStatement(sql);
        statement.setInt(1,1);
        ResultSet resultSet= statement.executeQuery();
        while(resultSet.next()){
            int a=resultSet.getInt(1);
            String b=resultSet.getString(2);
            int c=resultSet.getInt(3);
            System.out.println("id:   "+a+"  name:  "+b+"  class: "+c);

        }

        //修改操作
        sql="update student set class=(?) where id=(?)";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,2);
        statement.setInt(2,1);
        ret=statement.executeUpdate();
        System.out.println("ret:"+ret);

        //删除操作
        id=1;
        sql="delete from student where id=(?)";
        statement=connection.prepareStatement(sql);
        statement.setInt(1,id);
        ret=statement.executeUpdate();
        System.out.println("ret:"+ret);


        /**
         * 关闭资源不能省略
         * 先创建的后释放
         */
        resultSet.close();
        statement.close();
        connection.close();
    }
}
