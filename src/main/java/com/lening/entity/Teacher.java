package com.lening.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="t_teacher")
public class Teacher {
    @Id
    private Integer tid;
    private String  tname;
}
