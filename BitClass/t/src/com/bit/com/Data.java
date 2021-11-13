package com.bit.com;

import java.util.Comparator;

public class Data {
    int age;
    double score;
    String name;

    @Override
    public String toString() {
        return "Data{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }
    public Data(int age,double score,String name){
        this.age=age;
        this.name=name;
        this.score=score;
    }
}
class AgeComparator implements Comparator<Data>{
    public int compare(Data o,Data j){
        return o.age-j.age;
    }
}
class NameComparator implements Comparator<Data>{
    public int compare(Data o,Data j){
        return (int)o.name.compareTo(j.name);
    }
}

