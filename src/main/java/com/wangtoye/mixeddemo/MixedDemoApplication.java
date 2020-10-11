package com.wangtoye.mixeddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class MixedDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MixedDemoApplication.class, args);
    }
}
