package plant_mananger;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlantDao {
    public static boolean update(Plant plant){
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "update plant set type = ? , number = ? , name = ? , status =? ,updatetime = ? where id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(6,plant.id);
            statement.setString(1,plant.type);
            statement.setInt(2,plant.number);
            statement.setString(3,plant.name);
            statement.setInt(4,plant.status);
            Date date = new Date();//获得系统时间.
            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
            String nowTime = sdf.format(date);
            statement.setString(5, nowTime);
            int ret = statement.executeUpdate();
            return ret>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            zoo_mananger.DBUtils.close(connection,statement,resultSet);
        }
    }
    public static List<Plant> select(){
        List<Plant> plants = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from plant where status < 4 and status > 1 order by status limit 10";
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                Plant p = new Plant();
                p.id = resultSet.getInt("id");
                p.number = resultSet.getInt("number");
                p.status = resultSet.getInt("status");
                p.createtime = resultSet.getString("createtime");
                p.updatetime = resultSet.getString("updatetime");
                p.name = resultSet.getString("name");
                p.type = resultSet.getString("type");
                plants.add(p);
            }
            return plants;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            zoo_mananger.DBUtils.close(connection,statement,resultSet);
        }
    }
    public static Plant select(int id){
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from plant where id = ?";
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                Plant p = new Plant();
                p.id = resultSet.getInt("id");
                p.number = resultSet.getInt("number");
                p.status = resultSet.getInt("status");
                p.createtime = resultSet.getString("createtime");
                p.updatetime = resultSet.getString("updatetime");
                p.name = resultSet.getString("name");
                p.type = resultSet.getString("type");
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            zoo_mananger.DBUtils.close(connection,statement,resultSet);
        }
    }
    public static List<Plant> select(Plant plant){
        List<Plant> plants = new ArrayList<>();
        Connection connection = DBUtils.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from plant where id = ? or type like ? or name like ? ";
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1,plant.id);
            statement.setString(2,"%"+plant.type+"%");
            statement.setString(3,"%"+plant.name+"%");
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Plant p = new Plant();
                p.id = resultSet.getInt("id");
                p.number = resultSet.getInt("number");
                p.status = resultSet.getInt("status");
                p.createtime = resultSet.getString("createtime");
                p.updatetime = resultSet.getString("updatetime");
                p.name = resultSet.getString("name");
                p.type = resultSet.getString("type");
                plants.add(p);
            }
            return plants;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            zoo_mananger.DBUtils.close(connection,statement,resultSet);
        }
    }
    public static boolean add(Plant plant){
        Connection connection = DBUtils.getConnection();
        String sql = "insert into plant value (null,?,?,?,1,?,?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, plant.name);
            statement.setInt(2, plant.number);
            statement.setString(3, plant.type);
            Date date = new Date();//获得系统时间.
            SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
            String nowTime = sdf.format(date);
            statement.setString(4, nowTime);
            statement.setString(5, nowTime);
            int ret = statement.executeUpdate();
            return ret > 0;
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,null);
        }
    }
}
