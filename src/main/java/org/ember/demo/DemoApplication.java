package org.ember.demo;

import org.ember.demo.service.IStudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        final var ctx = SpringApplication.run(DemoApplication.class, args);
        final var studentService = ctx.getBean(IStudentService.class);
        final var result = studentService.query().eq("name", "mizuki").list();
        System.out.println(result);
    }

}
