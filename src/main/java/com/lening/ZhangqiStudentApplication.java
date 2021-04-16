package com.lening;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.lening.mapper"})
public class ZhangqiStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhangqiStudentApplication.class, args);
    }

}
