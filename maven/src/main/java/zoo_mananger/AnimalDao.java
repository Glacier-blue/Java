package zoo_mananger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao {
    public static boolean update(Animal animal){
        Connection connection = DBUtils.getConnect();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "update animal set type = ? , subspecies = ? , age = ? , name = ? , status =? where id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(6,animal.id);
            statement.setString(1,animal.type);
            statement.setString(2,animal.subspecies);
            statement.setInt(3,animal.age);
            statement.setString(4, animal.name);
            statement.setInt(5,animal.status);
            int ret = statement.executeUpdate();
            return ret>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }
    }
    public static Animal select(int id){
        Connection connection = DBUtils.getConnect();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from animal where id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                Animal findAnimal = new Animal();
                findAnimal.id = resultSet.getInt("id");
                findAnimal.type = resultSet.getString("type");
                findAnimal.subspecies = resultSet.getString("subspecies");
                findAnimal.age = resultSet.getInt("age");
                findAnimal.name = resultSet.getString("name");
                findAnimal.status = resultSet.getInt("status");
                return findAnimal;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }
    }
    public static List<Animal> select(Animal animal){
        List<Animal> animals = new ArrayList<>();
        Connection connection = DBUtils.getConnect();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from animal where id = ? or type = ? or subspecies = ? or age = ? or name like ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1,animal.id);
            statement.setString(2,animal.type);
            statement.setString(3,animal.subspecies);
            statement.setInt(4,animal.age);
            statement.setString(5, "%"+animal.name+"%");
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                Animal findAnimal = new Animal();
                findAnimal.id = resultSet.getInt("id");
                findAnimal.type = resultSet.getString("type");
                findAnimal.subspecies = resultSet.getString("subspecies");
                findAnimal.age = resultSet.getInt("age");
                findAnimal.name = resultSet.getString("name");
                findAnimal.status = resultSet.getInt("status");
                animals.add(findAnimal);
            }
            return animals;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtils.close(connection,statement,resultSet);
        }
    }
    public static boolean add(Animal animal){
        Connection connection = DBUtils.getConnect();
        String sql = "insert into animal value (null,?,?,?,?,4)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, animal.type);
            statement.setString(2, animal.subspecies);
            statement.setInt(3, animal.age);
            statement.setString(4, animal.name);
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
