import java.io.*;

public class IODemo5 {
    public static void main(String[] args) {
        copyFile();
    }
    public static void copyFile(){
        try(
                BufferedReader bufferedReader=new BufferedReader(new FileReader("D:\\汪福明\\Desktop\\1.txt"));
                BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("D:\\汪福明\\Desktop\\4.txt"));
                ){
            int len=-1;
            char[] buffer=new char[1024];
            while((len=bufferedReader.read(buffer))!=-1){
                bufferedWriter.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
