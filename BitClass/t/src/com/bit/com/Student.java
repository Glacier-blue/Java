package com.bit.com;

public class Student implements Comparable<Student> {
    public int age;
    public double score;
    public String name;
    Student(int age,Double score,String name){
        this.age=age;
        this.score=score;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

    public int compareTo(Student o){
        return (int)this.age-o.age;
    }
}
