package jdbc;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Add add=new Add();
        Select select=new Select();
        Update update=new Update();
        Delete delete=new Delete();

        add.add(1,"zs");
        add.add(2,"lisi");
        add.add(3,"ww");
        select.select();
        update.update(1,"zhangsan");
        select.select();
        delete.delete(2);
        select.select();
    }
}
