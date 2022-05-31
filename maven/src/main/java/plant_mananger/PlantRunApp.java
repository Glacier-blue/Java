package plant_mananger;

import java.util.List;
import java.util.Scanner;

public class PlantRunApp {
    Scanner scanner = new Scanner(System.in);
    PlantController plantController =new PlantController();
    public void menu(){
        while (true){
            System.out.println("---------欢迎登录植物园----------");
            System.out.println("----------1、新增植物---------------");
            System.out.println("----------2、修改植物信息---------------");
            System.out.println("----------3、查找植物---------------");
            System.out.println("----------4、查看异常植物---------------");
            System.out.print("command>>>");
            int n = scanner.nextInt();
            scanner.nextLine();
            if(n==1){
                plantController.add();
            }else if(n==2){
                plantController.update();
            }else if(n==3){
                plantController.find();
            }else if(n==4){
                plantController.select();
            }else if(n==5){
                System.exit(0);
            }else{
                System.out.println("***Warning:Unknown Command***");
                return;
            }
        }
    }
    public static void main(String[] args) {
        PlantRunApp plantRunApp = new PlantRunApp();
        while(true){
            plantRunApp.menu();
        }
    }
}
