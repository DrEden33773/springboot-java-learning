package org.ember.demo;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeGen {
    public static void main(String[] args) {
        try (final var dataSource = new HikariDataSource()) {
            dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/spring_learning_db");
            dataSource.setUsername("spring_learning");
            dataSource.setPassword("12345678");

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
        } catch (Exception e) {
            log.error("Error occurred:", e);
        }
    }
}
