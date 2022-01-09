package org.chengbing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan("org.chengbing.dao")
@SpringBootApplication

public class MarketPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketPlatformApplication.class, args);
    }

}
