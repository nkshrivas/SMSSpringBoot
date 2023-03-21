package com.management.student.Student.Management.System.repository;

public class Teacher {
    private String empID;
    private String name;
    private String Dept;
    private int age;
    private int salary;


    public Teacher(String empID, String name, String dept, int age, int salary) {
        this.empID = empID;
        this.name = name;
        Dept = dept;
        this.age = age;
        this.salary = salary;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String dept) {
        Dept = dept;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
