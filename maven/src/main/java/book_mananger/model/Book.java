package book_mananger.model;

public class Book {
    // id,数据库自增，用户系统内部识别
    public int id;
    // 书的编号
    public String number;
    // 书的名字
    public String name;
    // 书的状态 0表示可借，1表示解除，2表示下架
    public int status;
    private String getState(){
        if(status==0){
            return "可借";
        }else if(status==1){
            return "已借出";
        }else if(status==2){
            return "下架";
        }else {
            return "未知";
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", status=" + getState() +
                '}';
    }
}
