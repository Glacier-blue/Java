import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo2 {
    public static void main(String[] args) throws IOException {
        copyFile("D:\\汪福明\\Desktop\\3.jpg","D:\\汪福明\\Desktop\\2.jpg");
    }
    public static void copyFile(String srcPath,String destPath) throws IOException {
        //首先需要打开文件
        FileInputStream fileInputStream=new FileInputStream(srcPath);
        FileOutputStream fileOutputStream=new FileOutputStream(destPath);
        byte[] buffer =new byte[1024];
        int len=-1;
        while((len=fileInputStream.read(buffer))!=-1){
            System.out.println("len>>"+len);
            fileOutputStream.write(buffer,0,len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
    private static void copyFile2(String srcPath, String destPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            // 0. 先打开文件, 才能够读写. (创建 InputStream / OutputStream 对象的过程)
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            // 1. 需要读取 srcPath 对应的文件内容.
            byte[] buffer = new byte[1024];
            // 单次读取的内容是存在上限(缓冲区的长度), 要想把文件整个都读完, 需要搭配循环来使用.
            int len = -1;
            // 如果读到的 len 是 -1 说明读取结束. 循环就结束了.
            while ((len = fileInputStream.read(buffer)) != -1) {
                // 读取成功, 就把读到的内容写入到另外一个文件中即可.
                // 因为 len 的值不一定就是和缓冲区一样长~
                // 2. 把读取到的内容写入到 destPath 对应的文件中.
                System.out.println("len>>"+len);
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void copyFile3(String srcPath, String destPath){
        try(FileInputStream fileInputStream=new FileInputStream(srcPath);
        FileOutputStream fileOutputStream=new FileOutputStream(destPath)){
            byte[] buffer=new byte[1024];
            int len=-1;
            while((len=fileInputStream.read(buffer))!=-1){
                fileOutputStream.write(buffer,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
