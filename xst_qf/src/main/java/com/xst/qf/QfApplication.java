package com.xst.qf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QfApplication {
    public static void main(String[] args) {
        SpringApplication.run(QfApplication.class, args);
    }

}
