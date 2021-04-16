package com.lening.service.impl;

import com.lening.entity.*;
import com.lening.mapper.*;
import com.lening.service.StudentService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;
    @Resource
    private GradeMapper gradeMapper;
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private RoomMapper roomMapper;
    @Resource
    private CourseMapper courseMapper;


    public List<Student> allStu(){
       List<Student> students = studentMapper.selectAll();

       for (Student student :students){
            if(student.getGid()!=null){
                Grade grade = gradeMapper.selectByPrimaryKey(student.getGid());
                student.setGrade(grade);
                if(grade.getRid()!=null){
                    Room room = roomMapper.selectByPrimaryKey(grade.getRid());
                    grade.setRoom(room);
                }
                if(grade.getTid()!=null){
                    Teacher teacher = teacherMapper.selectByPrimaryKey(grade.getTid());
                    grade.setTeacher(teacher);
                }
                if(grade.getCid()!=null){
                    Course course = courseMapper.selectByPrimaryKey(grade.getCid());
                    grade.setCourse(course);
                }
            }
       }
        return students;
    }

    @Override
    public Student getGradeBySid(Integer sid) {
        return  studentMapper.selectByPrimaryKey(sid);
    }

    @Override
    public List<Grade> getGradeAll() {
        return  gradeMapper.selectAll();
    }

    @Override
    public String saveGrade(Student student) {

        int i = studentMapper.updateByPrimaryKeySelective(student);
        if(i>0){
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    @Override
    public List<Grade> show() {
        List<Grade> grades = gradeMapper.selectAll();

        if(grades!=null&&grades.size()>=1){
            for(Grade grade : grades){
                if(grade.getRid()!=null && grade.getRid()>=1){
                    Room room = roomMapper.selectByPrimaryKey(grade.getRid());
                    grade.setRoom(room);
                }
                if(grade.getCid()!=null && grade.getCid()>=1){
                    Course course = courseMapper.selectByPrimaryKey(grade.getCid());
                    grade.setCourse(course);
                }
            }
        }
    return grades;
    }

    @Override
    public List<Teacher> getTeacherList() {
        return teacherMapper.selectAll();
    }

    @Override
    public Grade getTeacherByGid(Integer gid) {
     /*   Grade grade = gradeMapper.selectByPrimaryKey(gid);
        Integer tid1 = grade.getTid();
        Example example = new Example(Teacher.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("tid",tid1);
        List<Teacher> teachers = teacherMapper.selectByExample(example);
        return teachers.size();*/
        Grade grade = gradeMapper.selectByPrimaryKey(gid);
        return grade;
    }

    @Override
    public int funcTeacherByTid(Integer tid) {
        Example example = new Example(Grade.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("tid",tid);
        List<Grade> grades = gradeMapper.selectByExample(criteria);
        System.out.println(grades.size());
        return grades.size();

    }
}
