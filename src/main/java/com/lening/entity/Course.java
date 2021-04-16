package com.lening.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="t_course")
public class Course {
    @Id
    private  Integer cid;
    private  String cname;
}
