package com.lsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController //此注解返回json
@EnableAutoConfiguration
public class HelloWorldService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/index")
    public String getUser(){
        System.out.println("come");
        String sql = "select * from user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        System.out.println(list.size());
        return list.toString();
    }


    public static void main(String[] args) {
        SpringApplication.run(HelloWorldService.class,args);
    }
}
