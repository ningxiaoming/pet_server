package com.pet.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pet.home.**.mapper")
public class PetHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetHomeApplication.class, args);
    }

}
