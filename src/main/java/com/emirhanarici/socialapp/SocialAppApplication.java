package com.emirhanarici.socialapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SocialAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocialAppApplication.class, args);
    }

}
