package com.pet.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.pet.home.**.mapper")
@EnableCaching
public class PetHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetHomeApplication.class, args);
    }

}
