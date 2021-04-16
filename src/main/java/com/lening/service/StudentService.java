package com.lening.service;

import com.lening.entity.Grade;
import com.lening.entity.Student;
import com.lening.entity.Teacher;

import java.util.List;

public interface StudentService {

    public List<Student> allStu();

    Student getGradeBySid(Integer sid);

    List<Grade> getGradeAll();

    String saveGrade(Student student);

    List<Grade> show();

    List<Teacher> getTeacherList();

    Grade getTeacherByGid(Integer gid);

    int funcTeacherByTid(Integer tid);
}
