package com.lening.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

@Data
public class gradeVo implements Serializable {

    private String gname;

    private String rname;

    private String cname;

}
