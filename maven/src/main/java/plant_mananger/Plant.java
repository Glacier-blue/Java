package plant_mananger;

import java.util.Date;

public class Plant {
    public int id;
    public String name;
    public int number;
    public String type;
    public int status;
    public String createtime;
    public String updatetime;
    private String getStatue(){
        if(status==1){
            return "健康";
        }else if(status==2){
            return "生病";
        }else if(status==3){
            return "濒危";
        }else{
            return "未定义";
        }
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", 数量=" + number +
                ", 类型='" + type + '\'' +
                ", 状态=" + getStatue() +
                ", 进园时间=" + createtime +
                ", 更新时间=" + updatetime +
                '}';
    }
}
