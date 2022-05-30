package zoo_mananger;

import java.util.List;
import java.util.Scanner;

public class AnimalController {
    Scanner scanner = new Scanner(System.in);
    public boolean add() {
        System.out.println("请按照指引添加动物信息");
        Animal animal = new Animal();
        System.out.print("动物种类>>>");
        animal.type = scanner.nextLine();
        System.out.print("动物亚种>>>");
        animal.subspecies = scanner.nextLine();
        System.out.print("动物年龄>>>");
        animal.age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("动物名字>>>");
        animal.name = scanner.nextLine();
        System.out.println("动物状态，0代表死亡，1代表濒危，2代表病重，3代表生病，4代表健康");
        System.out.print("动物状态>>>");
        animal.status = scanner.nextInt();
        return AnimalDao.add(animal);
    }

    public void update() {
        System.out.print("请输入修改动物信息的动物id>>>");
        int id = scanner.nextInt();
        scanner.nextLine();
        Animal animal = AnimalDao.select(id);
        if(animal==null){
            System.out.println("动物不存在");
            return;
        }
        String preMsg = animal.toString();
        System.out.println(animal);
        System.out.println("请输入修改的信息");
        System.out.println("1、种类");
        System.out.println("2、亚种");
        System.out.println("3、年龄");
        System.out.println("4、名字");
        System.out.println("5、状态");
        System.out.println("6、确认修改");
        while(true){
            int n = scanner.nextInt();
            if(n==1){
                String msg = animal.type;
                System.out.print("动物种类>>>");
                animal.type = scanner.nextLine();
                System.out.println("type:"+msg+"→"+ animal.type);
            }else if(n==2){
                String msg = animal.subspecies;
                System.out.print("动物亚种>>>");
                animal.type = scanner.nextLine();
                System.out.println("subspecies:"+msg+"→"+ animal.subspecies);
            }else if(n==3){
                int msg = animal.age;
                System.out.print("年龄>>>");
                animal.age = scanner.nextInt();
                System.out.println("age:"+msg+"→"+ animal.age);
            }else if(n==4){
                String msg = animal.name;
                System.out.print("动物名字>>>");
                animal.name = scanner.nextLine();
                System.out.println("name:"+msg+"→"+ animal.name);
            }else if(n==5){
                int msg = animal.status;
                System.out.print("状态>>>");
                animal.status = scanner.nextInt();
                System.out.println("status:"+msg+"→"+ animal.status);
            }else if(n==6){
                boolean ans = AnimalDao.update(animal);
                if(!ans){
                    System.out.println("未知原因修改失败");
                    return;
                }
                System.out.println("修改前："+preMsg);
                System.out.println("修改后:"+animal);
                return;
            }
        }
    }

    public void find() {
        System.out.println("请按照指引添加查找动物信息");
        Animal animal = new Animal();
        System.out.print("动物id，未知填写0>>>");
        animal.id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("动物种类，未知填写null>>>");
        animal.type = scanner.nextLine();
        System.out.print("动物亚种，未知填写null>>>");
        animal.subspecies = scanner.nextLine();
        System.out.print("动物年龄，未知填写0>>>");
        animal.age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("动物名字，未知填写null>>>");
        animal.name = scanner.nextLine();
        System.out.println("动物状态，0代表死亡，1代表濒危，2代表病重，3代表生病，4代表健康");
        System.out.print("动物状态,未知填写-1>>>");
        animal.status = scanner.nextInt();
        List<Animal>  animals = AnimalDao.select(animal);
        display(animals);
    }
    public void display(List<Animal> animals){
        for(Animal animal:animals){
            System.out.println(animal);
        }
    }
}
