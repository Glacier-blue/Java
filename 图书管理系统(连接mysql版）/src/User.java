public class User {
    public String id;
    public String name;
    public String password;
    public String telephone;
    public String mail;
    public String power;

    public User(String id, String name, String password, String telephone, String mail, String power) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.mail = mail;
        this.power = power;
    }
    public void menu1(){
        System.out.println("===========管理员菜单===========");
        System.out.println("1.查找图书");
        System.out.println("2.新增图书");
        System.out.println("3.删除图书");
        System.out.println("4.显示图书");
        System.out.println("0.退出系统");
        System.out.println("==============================");
    }
    public void menu2() {
        System.out.println("===========普通用户的菜单===========");
        System.out.println("1.查找图书");
        System.out.println("2.借阅图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("==============================");
    }
}
