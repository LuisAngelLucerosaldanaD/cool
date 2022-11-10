package com.estrellitas.cool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication(scanBasePackages = {
        "com.estrellitas.cool.generate",
        "com.estrellitas.cool.endpoints",
        "com.estrellitas.cool.services",
        "com.estrellitas.cool.configurations",
        "com.estrellitas.cool.domain",
})
public class CoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoolApplication.class, args);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
