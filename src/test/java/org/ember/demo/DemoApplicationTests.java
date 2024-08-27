package org.ember.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.ember.demo.entity.Student;
import org.ember.demo.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private IStudentService studentService;

    @Test
    void testStudentService() {
        final var result = studentService.query().eq("name", "mizuki").list();
        final var idSet = result.stream().map(Student::getId).collect(Collectors.toSet());
        final var expectedIdSet = Set.of(2, 3);
        assert idSet.equals(expectedIdSet);
    }


    @Autowired
    private HikariDataSource dataSource;

    @Test
    void mybatisPlusGenerator() {
        FastAutoGenerator.create(new DataSourceConfig.Builder(dataSource))
                .globalConfig(builder -> {
                    builder.author("eden").outputDir("src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("org.ember.demo");
                })
                .strategyConfig(builder -> {
                    builder.mapperBuilder()
                            .mapperAnnotation(Mapper.class)
                            .entityBuilder()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .enableChainModel()
                            .controllerBuilder()
                            .enableRestStyle()
                            .build();
                })
                .execute();
    }

}
