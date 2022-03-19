package jdbc;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
    public void select() throws SQLException {
        Connection connection= DBUtils.getConnection();
        String sql="select * from msg";
        assert connection != null;
        PreparedStatement statement= connection.prepareStatement(sql);

        ResultSet resultSet= statement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt("id")+" "+resultSet.getString("name"));
        }
        DBUtils.close(connection,statement,resultSet);
    }
}
