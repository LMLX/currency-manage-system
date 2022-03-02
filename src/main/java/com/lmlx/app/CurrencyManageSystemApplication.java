package com.lmlx.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class CurrencyManageSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyManageSystemApplication.class, args);
    }
}
