package org.ember.demo;

import org.ember.demo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.ember.demo.entity.table.StudentTableDef.STUDENT;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        final var ctx = SpringApplication.run(DemoApplication.class, args);
        final var studentService = ctx.getBean(StudentService.class);
        studentService.queryChain()
                .select(STUDENT.ALL_COLUMNS)
                .where(STUDENT.NAME.eq("mizuki"))
                .list()
                .forEach(System.out::println);
    }

}
