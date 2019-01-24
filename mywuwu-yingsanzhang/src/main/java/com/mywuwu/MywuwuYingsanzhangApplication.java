package com.mywuwu;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = {"com.mywuwu.yingsanzhang", "com.mywuwu.core"})
//,exclude = DataSourceAutoConfiguration.class)
//@EnableMongoRepositories("com.mywuwu.data") , "com.mywuwu.data"
@EnableAsync
public class MywuwuYingsanzhangApplication {

    public static void main(String[] args) {
//		SpringApplication.run(MywuwuYingsanzhangApplication.class, args);
        new SpringApplicationBuilder(MywuwuYingsanzhangApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }


}

