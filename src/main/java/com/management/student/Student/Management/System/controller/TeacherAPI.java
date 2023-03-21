package com.management.student.Student.Management.System.controller;

import com.management.student.Student.Management.System.repository.Student;
import com.management.student.Student.Management.System.repository.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class TeacherAPI {
    HashMap<String,Teacher> teacherDB=new HashMap<>();
    @PostMapping("/addTeacher")
        public String addTeacher(@RequestParam("empID") String empID,@RequestParam("name") String name,@RequestParam("dept")String dept,@RequestParam("age") Integer age,@RequestParam("salary")Integer salary){
        Teacher teacher = new Teacher(empID,name,dept,age,salary);

        if(!teacherDB.containsKey(empID)){
            teacherDB.put(empID,teacher);
            return "Teacher Added successfully";
        }
        return "Some Error Occured";
    }
    @GetMapping("/searchTeacher")
    public List<Teacher> search(@RequestParam("name")String name){
        List<Teacher> stuReq = new ArrayList<>();

        for(Teacher st:teacherDB.values()){
            if(st.getName().equals(name)){
                stuReq.add(st);
            }
        }
        return stuReq;
    }
    @GetMapping("/highSalary")
    public List<Teacher> search(){
        List<Teacher> stuReq = new ArrayList<>();

        for(Teacher st:teacherDB.values()){
            if(st.getSalary()>=18000){
                stuReq.add(st);
            }
        }
        return stuReq;
    }

    @PutMapping("/updateSalary")
    public String updateSalary(@RequestParam("empID")String empID,@RequestParam("newSalary")Integer newSalary){
        if(teacherDB.containsKey(empID)){
            Teacher teacher=teacherDB.get(empID);

            teacher.setSalary(newSalary);

            teacherDB.put(empID,teacher);

            return "Badhhhhh gyiii Bhaaiiiiii!!!! bs ab fook mt diyoooo";
        }
        return "Kuch nhi bda bhaiii!!! Sb Doglapan h!!!";
    }

}
