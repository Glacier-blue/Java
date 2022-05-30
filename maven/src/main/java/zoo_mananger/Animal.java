package zoo_mananger;

public class Animal implements Cloneable{
    public int id;
    public String type;
    public String subspecies;
    public int age;
    public String name;
    public int status;
    private String getStatus(){
        if(status==0){
            return "已死亡";
        }else if(status==1){
            return "濒危";
        }else if(status==2){
            return "病重";
        }else if(status==3){
            return "生病";
        }else if(status==4){
            return "健康";
        }else{
            return "请添加对应的状态";
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", subspecies='" + subspecies + '\'' +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", status=" + getStatus() +
                '}';
    }
}
