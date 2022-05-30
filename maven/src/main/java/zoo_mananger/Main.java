package zoo_mananger;

import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    AnimalController animalController = new AnimalController();
    public void menu(){
        System.out.println("*****1、登记动物信息*****");
        System.out.println("*****2、修改动物信息*****");
        System.out.println("*****3、查找动物信息*****");
        System.out.println("*****4、退出系统*****");
        int n = scanner.nextInt();
        scanner.nextLine();
        if(n==1){
            animalController.add();
        }else if(n==2){
            animalController.update();
        }else if(n==3){
            animalController.find();
        }else {
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        Main m = new Main();
        while(true){
            m.menu();
        }
    }
}
