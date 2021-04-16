package com.lening.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="t_grade")
public class Grade {
    @Id
    private  Integer gid;
    private  String  gname;
    private  Integer gcount;
    private  Integer rid;
    private  Integer tid;
    private  Integer cid;


    /* 教室和班级一对一 */
    private Room room = new Room();
    /* 班级和教师多对一 */
    private Teacher teacher = new Teacher();
    /* 课程和教师多对一 */
    private Course course = new Course();

}
