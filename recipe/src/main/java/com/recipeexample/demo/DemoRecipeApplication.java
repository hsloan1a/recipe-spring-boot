package com.recipeexample.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRecipeApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoRecipeApplication.class, args);
    }

    @Override
    public void run(String... args) {

    }
}
