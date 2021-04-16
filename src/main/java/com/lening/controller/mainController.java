package com.lening.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/main")
public class mainController {

    @RequestMapping("/stu")
    public String goStudnet(){
        return "stu-list";
    }
}
