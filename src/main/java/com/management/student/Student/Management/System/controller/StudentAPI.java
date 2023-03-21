package com.management.student.Student.Management.System.controller;

import com.management.student.Student.Management.System.StudentManagementSystemApplication;
import com.management.student.Student.Management.System.repository.Student;
import org.hibernate.collection.spi.PersistentBag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class StudentAPI {
    HashMap<String, Student> studentDb = new HashMap<>();

    @PostMapping("/addStudentViaParams")
    public String addStudentViaParams(@RequestParam("rollNo") String rollNo, @RequestParam("studentName") String studentName, @RequestParam("studentAge") Integer studentAge, @RequestParam("studentCourse") String studentCourse) {
        Student student = new Student(rollNo, studentName, studentAge, studentCourse);
        if(!studentDb.containsKey(rollNo)){
            studentDb.put(rollNo, student);
//            System.out.println(student);
            return studentName+" is added to "+studentDb.get(rollNo).getCourse()+" Course";
        } else{
            return "User already exists 2";
        }
    }
    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student){
        return "Student Added successfully";
    }
    @GetMapping("/search")
    public List<Student> search(@RequestParam("name")String name){
        List<Student> stuReq = new ArrayList<>();

        for(Student st:studentDb.values()){
            if(st.getName().equals(name)){
                stuReq.add(st);
            }
        }
        return stuReq;
    }
    @GetMapping("/isVoter")
    public List<Student> search(){
        List<Student> stuReq = new ArrayList<>();

        for(Student st:studentDb.values()){
            if(st.getAge()>=18){
                stuReq.add(st);
            }
        }
        return stuReq;
    }

}
