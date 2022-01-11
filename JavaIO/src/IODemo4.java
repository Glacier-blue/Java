import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IODemo4 {
    public static void main(String[] args) throws IOException {
        copyFile();
        copyFile2();
    }
    public static void copyFile() throws IOException {
        FileReader fileReader=new FileReader("D:\\汪福明\\Desktop\\1.txt");
        FileWriter fileWriter=new FileWriter("D:\\汪福明\\Desktop\\2.txt");
        char[] buffer=new char[1024];
        int len=-1;
        while ((len=fileReader.read(buffer))!=-1){
            System.out.println("len>>"+len);
            fileWriter.write(buffer,0,len);
        }
        fileReader.close();
        fileWriter.close();
    }
    public static void copyFile2(){
        try(
                FileReader fileReader=new FileReader("D:\\汪福明\\Desktop\\1.txt");
                FileWriter fileWriter=new FileWriter("D:\\汪福明\\Desktop\\3.txt");
                ){
            int len=-1;
            char[] buffer=new char[1024];
            while((len=fileReader.read(buffer))!=-1){
                fileWriter.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
