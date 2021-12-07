package day1206;

import java.util.Arrays;
import java.util.Comparator;

class Stu{
    String name;
    String number;
    double score;
    public Stu(String name, String number, double score) {
        this.name = name;
        this.number = number;
        this.score = score;
    }

    @Override
    public String toString() {
        return "TestStu{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", score=" + score +
                '}';
    }
}
class ScoreComparator implements Comparator<Stu>{
    @Override
    public int compare(Stu o1, Stu o2) {
        if(o1.score> o2.score){
            return -1;
        }else if(o1.score==o2.score){
            return 0;
        }else{
            return 1;
        }
    }
}
class NameComparator implements Comparator<Stu>{
    @Override
    public int compare(Stu o1, Stu o2) {
        return o1.name.compareTo(o2.name);
    }
}
class NumberCompartor implements Comparator<Stu>{
    @Override
    public int compare(Stu o1, Stu o2) {
        return o1.number.compareTo(o2.number);
    }
}
public class Main {
    public static void printArr(Stu[] studengts){
        for (Stu numbers: studengts) {
            System.out.println(numbers);
        }
        System.out.println("---------------------------------");
    }
    public static void main(String[] args) {
        Stu[] students=new Stu[5];
        students[0]=new Stu("张三","0002",98.76);
        students[1]=new Stu("李四","0001",98.45);
        students[2]=new Stu("王五","0003",78.56);
        students[3]=new Stu("王二麻子","0005",89.56);
        students[4]=new Stu("马牛逼","0004",90.87);
        ScoreComparator scoreComparator=new ScoreComparator();
        NameComparator nameComparator=new NameComparator();
        NumberCompartor numberCompartor=new NumberCompartor();
        Arrays.sort(students,scoreComparator);
        printArr(students);
        Arrays.sort(students,numberCompartor);
        printArr(students);
        Arrays.sort(students,nameComparator);
        printArr(students);
    }
}