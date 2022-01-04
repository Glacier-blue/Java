import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private User log() throws SQLException {
        Operation operation=new Operation();
        Scanner scanner=new Scanner(System.in);
        System.out.print("账号>>");
        String id=scanner.nextLine();
        System.out.print("密码>>");
        String password=scanner.nextLine();
        User user=operation.log(id,password);
        if(user==null) {
            System.out.println("账号密码错误");
            return null;
        }
        return user;
    }
    public static void main(String[] args) throws SQLException {
        Main main=new Main();
        Scanner scanner=new Scanner(System.in);
        Operation operation=new Operation();
        User user=null;
        while(user==null){
            user=main.log();
        }
        System.out.println("         "+user.power+user.name+"欢迎你");
        if(user.power.equals("管理员")){
            user.menu1();
        }else{
            user.menu2();
        }
        while(true){
            int n=0;
            System.out.print("Operation:");
            n=scanner.nextInt();
            switch (n){
                case 1:
                    scanner.nextLine();
                    String bookName=scanner.nextLine();
                    operation.find(bookName);break;
                case 2:
                    if(user.power.equals("管理员")) {
                        operation.add();
                    }else{
                        int bookId=scanner.nextInt();
                        operation.borrowBook(bookId,user.id);
                    }
                    break;
                case 3:
                    if(user.power.equals("管理员")){
                        int bookId=scanner.nextInt();
                        operation.delete(bookId);
                    }else{
                        operation.returnBook(1, user.id);
                    }
                    break;
                case 4:
                    if(user.power.equals("管理员")){
                        operation.find();
                    }else{
                        operation.add();
                    }
                case 0:System.exit(0);
            }
        }
    }
}
