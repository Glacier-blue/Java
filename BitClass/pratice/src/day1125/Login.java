package day1125;

import java.util.Scanner;

class UserError extends Exception {
    public UserError(String message) {
        super(message);
    }
}
class PasswordError extends Exception {
    public PasswordError(String message) {
        super(message);
    }
}
public class Login {
    private static String userName = "admin";
    private static String password = "123456";

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("输入用户名>>");
        String name= scanner.nextLine();
        System.out.print("输入密码>>");
        String password=scanner.nextLine();
        try {
            login(name, password);
        } catch (UserError userError) {
            userError.printStackTrace();
        } catch (PasswordError passwordError) {
            passwordError.printStackTrace();
        }
    }
    public static void login(String userName, String password) throws UserError,
            PasswordError {
        if (!Login.userName.equals(userName)) {
            throw new UserError("用户名错误");
        }
        if (!Login.password.equals(password)) {
            throw new PasswordError("密码错误");
        }
        System.out.println("登陆成功");
    }
}
