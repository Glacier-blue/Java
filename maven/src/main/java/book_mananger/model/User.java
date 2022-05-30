package book_mananger.model;

public class User {
    // id，具有唯一性，数据库自动生成
    public int id;
    // Student ID 学号，具有唯一性
    public String sid;
    // 姓名
    public String name;
    public String password;
    // 权限，区分管理员以及普通用户
    public int authority;
    // 在借图书数
    public int booksNum;

    @Override
    public String toString() {
        return "User{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", authority=" + authority +
                ", booksNum=" + booksNum +
                '}';
    }
}
