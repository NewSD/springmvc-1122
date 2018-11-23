package com.niu.controller;

import com.niu.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ami on 2018/11/23.
 */
@Controller
public class EmployeeController {


//  http://localhost:8082/add.action?employee=caoyc-18-male
    @RequestMapping("/add")
    public String add(@RequestParam("employee") Employee employee){
        System.out.println(employee);
//        Employee [name=caoyc, age=18, gender=male]
        return "add";
    }

}
