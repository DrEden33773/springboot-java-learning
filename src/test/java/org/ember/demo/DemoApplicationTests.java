package org.ember.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private HikariDataSource dataSource;

    @Test
    void mybatisFlexGenerator() {
        final var globalConfig = new GlobalConfig();

        globalConfig.getJavadocConfig()
                .setAuthor("Eden");
        globalConfig.getPackageConfig()
                .setBasePackage("org.ember.demo");
        globalConfig.enableEntity()
                .setWithLombok(true)
                .setJdkVersion(21);
        globalConfig.enableMapper()
                .setMapperAnnotation(true);
        globalConfig.enableService();
        globalConfig.enableServiceImpl()
                .setCacheExample(true);
        globalConfig.enableController()
                .setRestStyle(true);
        globalConfig.enableMapperXml();

        final var generator = new Generator(dataSource, globalConfig);

        generator.generate();
    }

    @Test
    void mybatisPlusGenerator() {
        FastAutoGenerator.create(new DataSourceConfig.Builder(dataSource))
                .globalConfig(builder -> builder.author("eden").outputDir("src\\main\\java"))
                .packageConfig(builder -> builder.parent("org.ember.demo"))
                .strategyConfig(builder -> builder.mapperBuilder()
                        .mapperAnnotation(Mapper.class)
                        .entityBuilder()
                        .enableLombok()
                        .enableTableFieldAnnotation()
                        .enableChainModel()
                        .controllerBuilder()
                        .enableRestStyle()
                        .build())
                .execute();
    }

}
