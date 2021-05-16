package com.stumanager.globel;

/**
 * @author Genius
 * @version 1.0.0
 * @ClassName Student.java
 * @Description TODO 学生类
 * @createTime 2021年04月29日 19:42:00
 */
public class Student {
    private int id;
    private String stu_name;
    private int stu_sex;
    private int stu_age;
    private float stu_score;
    private String stu_tel;
    private String classid;

    public Student() {
    }

    public Student(String stu_name, int stu_sex, int stu_age, float stu_score, String stu_tel, String classid) {
        this.stu_name = stu_name;
        this.stu_sex = stu_sex;
        this.stu_age = stu_age;
        this.stu_score = stu_score;
        this.stu_tel = stu_tel;
        this.classid = classid;
    }

    public Student(int id, String stu_name, int stu_sex, int stu_age, float stu_score, String stu_tel, String classid) {
        this.id = id;
        this.stu_name = stu_name;
        this.stu_sex = stu_sex;
        this.stu_age = stu_age;
        this.stu_score = stu_score;
        this.stu_tel = stu_tel;
        this.classid = classid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public int getStu_sex() {
        return stu_sex;
    }

    public void setStu_sex(int stu_sex) {
        this.stu_sex = stu_sex;
    }

    public int getStu_age() {
        return stu_age;
    }

    public void setStu_age(int stu_age) {
        this.stu_age = stu_age;
    }

    public float getStu_score() {
        return stu_score;
    }

    public void setStu_score(float stu_score) {
        this.stu_score = stu_score;
    }

    public String getStu_tel() {
        return stu_tel;
    }

    public void setStu_tel(String stu_tel) {
        this.stu_tel = stu_tel;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }
}
