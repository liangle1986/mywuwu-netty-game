package com.mywuwu.hall;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.mywuwu.hall", "com.mywuwu.core"})
@Configuration
@EnableAsync
public class MywuwuHallApplication {

    public static void main(String[] args) {
//		SpringApplication.run(MywuwuHallApplication.class, args);
        new SpringApplicationBuilder(MywuwuHallApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }

}

