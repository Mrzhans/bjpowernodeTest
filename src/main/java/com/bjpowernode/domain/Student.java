package com.bjpowernode.domain;

public class Student {
    private String no;
    private String name;
    private int age;
    private int classroomid;


    public Student() {
    }

    public Student(String no, String name, int age,int classroomid) {
        this.name = name;
        this.no = no;
        this.age = age;
        this.classroomid = classroomid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClassroomid() {
        return classroomid;
    }

    public void setClassroomid(int classroomid) {
        this.classroomid = classroomid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classroomid=" + classroomid +
                '}';
    }
}
