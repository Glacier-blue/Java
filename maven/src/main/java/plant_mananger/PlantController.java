package plant_mananger;


import java.util.List;
import java.util.Scanner;

public class PlantController {
    Scanner scanner = new Scanner(System.in);
    public void add(){
        System.out.println("新进园植物信息,请按照系统提示填写");
        Plant plant = new Plant();
        System.out.print("植物种类>>>");
        plant.type = scanner.nextLine();
        System.out.print("植物名称>>>");
        plant.name = scanner.nextLine();
        System.out.print("植物数量>>>");
        plant.number = scanner.nextInt();
        scanner.nextLine();
        System.out.println("1代表健康，2代表生病，3代表濒危，4代表死亡");
        System.out.print("植物状态>>>");
        plant.status = scanner.nextInt();
        scanner.nextLine();
        boolean ans = PlantDao.add(plant);
        if(ans){
            System.out.println("新增成功");
        }else{
            System.out.println("新增失败");
        }
    }
    public void update() {
        System.out.print("请输入修改植物信息的动物id>>>");
        int id = scanner.nextInt();
        scanner.nextLine();
        Plant plant = PlantDao.select(id);
        if(plant==null){
            System.out.println("植物不存在");
            return;
        }
        String preMsg = plant.toString();
        System.out.println("--------------查询信息如下-----------");
        System.out.println(preMsg);
        System.out.println("-----------------------------------");
        System.out.println("请输入修改的信息");
        System.out.println("1、种类");
        System.out.println("2、名字");
        System.out.println("3、状态");
        System.out.println("4、数量");
        System.out.println("5、确认修改");
        System.out.println("------------------------------------");
        while(true){
            int n = scanner.nextInt();
            scanner.nextLine();
            if(n==1){
                String msg = plant.type;
                System.out.print("植物种类>>>");
                plant.type = scanner.nextLine();
                System.out.println("type:"+msg+"→"+ plant.type);
            }else if(n==2){
                String msg = plant.name;
                System.out.print("植物名字>>>");
                plant.name = scanner.nextLine();
                System.out.println("name:"+msg+"→"+ plant.name);
            }else if(n==3){
                int msg = plant.status;
                System.out.print("植物状态>>>");
                plant.status = scanner.nextInt();
                scanner.nextLine();
                System.out.println("status:"+msg+"→"+ plant.status);
            } else if(n==4){
                int msg = plant.number;
                System.out.print("植物数量>>>");
                plant.number = scanner.nextInt();
                scanner.nextLine();
                System.out.println("status:"+msg+"→"+ plant.number);
            }else if(n==5){
                boolean ans = PlantDao.update(plant);
                if(!ans){
                    System.out.println("未知原因修改失败");
                    return;
                }
                System.out.println("修改前："+preMsg);
                System.out.println("修改后:"+plant);
                return;
            }
        }
    }
    public void find() {
        System.out.println("请按照指引添加查找植物信息");
        Plant plant = new Plant();
        System.out.print("植物id，未知填写0>>>");
        plant.id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("植物种类，未知填写null>>>");
        plant.type = scanner.nextLine();
        System.out.print("植物名字，未知填写null>>>");
        plant.name = scanner.nextLine();
        List<Plant> plants = PlantDao.select(plant);
        display(plants);
    }

    public void select(){
        List<Plant> plants = PlantDao.select();
        display(plants);
    }
    public void display(List<Plant> plants){
        System.out.println("-----------查找信息如下---------------");
        for(Plant plant:plants){
            System.out.println(plant);
        }
        System.out.println("-------------------------------------");
    }
}
