package com.lening.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name="t_room")
public class Room {
    @Id
    private Integer rid;
    private String rname;
}
