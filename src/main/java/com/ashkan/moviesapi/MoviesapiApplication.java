package com.ashkan.moviesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class MoviesapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviesapiApplication.class, args);
    }

}
