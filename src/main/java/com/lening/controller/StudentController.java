package com.lening.controller;

import com.lening.entity.Grade;
import com.lening.entity.Student;
import com.lening.entity.Teacher;
import com.lening.mapper.GradeMapper;
import com.lening.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {
    @Resource
    private StudentService studentService;



    @RequestMapping("/list")
    public List<Student> allStu(){
     return   studentService.allStu();
    }

    @RequestMapping("/getGradeBySid")
    public Student getGradeBySid(Integer sid){
        Student gradeBySid = studentService.getGradeBySid(sid);
        return gradeBySid;

    }
    @RequestMapping("/getGradeAll")
    public List<Grade> getGradeAll(){
        return studentService.getGradeAll();
    }

    @RequestMapping("/saveGrade")
    public  String saveGrade(@RequestBody Student student){
        String s = studentService.saveGrade(student);
        return s;
    }

    @RequestMapping("/show")
    public List<Grade> show(){
        List<Grade> show = studentService.show();
        return show;
    }

    @RequestMapping("/getTeacherList")
    public List<Teacher> getTeacherList(){
        return studentService.getTeacherList();
    }

   @RequestMapping("/getTeacherByGid")
    public Grade  getTeacherByGid(Integer gid){
        return studentService.getTeacherByGid(gid);
    }

    @RequestMapping("/funcTeacherByTid")
    public int funcTeacherByTid(Integer tid){
        System.out.println(tid);
        int i = studentService.funcTeacherByTid(tid);
        System.out.println(i);
        return i;
    }
}
