package com.example.finalproject1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2
@EnableWebMvc
@Import(SpringDataRestConfiguration.class)
public class SwaggerConfig implements WebMvcConfigurer{

//    private ApiInfo initApiInfo(){
//        return new ApiInfoBuilder()
//            .title("API's")
//            .description("Busra Celik")
//            .version("1.0")
//            .build();
//        }


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }



//        @Bean
//        public Docket configure(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(initApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.finalproject1.controller"))
//                .paths(PathSelectors.any())
//                .build();
//        }


//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //enabling swagger-ui part for visual documentation
////        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
////        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//    }


}
