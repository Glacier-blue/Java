import java.io.*;

public class IODemo3 {
    public static void main(String[] args) throws IOException {
        copyFile();
        copyFile2();
    }
    public static void copyFile() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("D:\\汪福明\\Desktop\\1.jpg");
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\汪福明\\Desktop\\2.jpg");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedoutputStream=new BufferedOutputStream(fileOutputStream);
        byte[] buffer =new byte[1024];
        int len=-1;
        while((len=bufferedInputStream.read(buffer))!=-1){
            System.out.println("len>>"+len);
            bufferedoutputStream.write(buffer,0,len);
        }
        bufferedInputStream.close();
        bufferedoutputStream.close();
    }
    public static void copyFile2(){
        try(
                BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream("D:\\汪福明\\Desktop\\1.jpg"));
                BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("D:\\汪福明\\Desktop\\3.jpg"));
                ){
            int len=-1;
            byte[] buffer=new byte[1024];
            while((len=bufferedInputStream.read(buffer))!=-1){
                System.out.println("len>>"+len);
                bufferedOutputStream.write(buffer,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
