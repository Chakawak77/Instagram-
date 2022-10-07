package com.kurdistan.instagram;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class InstagramApp {
    public static void main(String[] args) {
        SpringApplication.run(InstagramApp.class);
    }
}