package com.bkb.management.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author big kevin bro
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.bkb.management.backend.domain.mapper")
public class ManagementBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementBackendApplication.class, args);
    }

}
