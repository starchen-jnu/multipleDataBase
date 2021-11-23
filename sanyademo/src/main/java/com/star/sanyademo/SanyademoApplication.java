package com.star.sanyademo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = {"com.star.sanyademo.mapper.db1","com.star.sanyademo.mapper.db2","com.star.sanyademo.mapper.db3"})
@EnableTransactionManagement(order = 10)
public class SanyademoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanyademoApplication.class, args);
    }

}
