package com.niu.entity;

/**
 * Created by ami on 2018/11/23.
 */
public class Employee {

    private String name;
    private Integer age;
    private String gender;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", gender=" + gender
                + "]";
    }

}