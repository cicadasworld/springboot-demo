package com.jin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                // 配置分组
                .groupName("develop group")
                .select()
                // 配置扫描接口
                .apis(RequestHandlerSelectors.basePackage("com.jin.controller"))
                // 配置过滤路径
//                .paths(PathSelectors.ant("/hello"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Jin's Swagger API Document",
                "Less is more", "1.0.0" ,
                "",
                ApiInfo.DEFAULT_CONTACT,
                "",
                "",
                new ArrayList<>());
    }
}
