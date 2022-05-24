package io;

import java.io.File;
import java.io.IOException;

public class IODemo1 {

    public static void main(String[] args) {
        File file=new File("D:\\Github\\Java\\JavaIO\\io");
        listAllFile(file);
    }
    private static void listAllFile(File file){
        if(file.isDirectory()){
            File[] list=file.listFiles();
            if(list!=null){
                for(File f:list){
                    listAllFile(f);
                }
            }
        }else{
            System.out.println(file);
        }
    }
    public static void main3(String[] args) {
        File file=new File("D:\\Github\\Java\\JavaIO\\io\\io1\\io2\\io3\\io4");
        System.out.println("文件是否存在>>"+file.exists());
        if(!file.exists()){
            file.mkdirs();
        }
        System.out.println(file.getParent());
    }
    public static void main2(String[] args) {
        File file=new File("D:\\Github\\Java\\JavaIO\\io");
        System.out.println("文件是否存在>>"+file.exists());
        if(!file.exists()){
            file.mkdir();
        }
        System.out.println("是否是目录>>"+file.isDirectory());
    }
    public static void main1(String[] args) throws IOException{
        File file=new File("D:\\Github\\Java\\JavaIO\\io.txt");
        System.out.println("文件是否存在>>"+file.exists());
        System.out.println("文件是否时普通文件>>"+file.isFile());
        System.out.println("文件是否是目录>>"+file.isDirectory());
        file.delete();
        System.out.println("文件是否存在>>"+file.exists());
        System.out.println("文件创建是否成功>>"+file.createNewFile());
        System.out.println("文件是否存在>>"+file.exists());
    }
}
