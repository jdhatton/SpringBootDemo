package org.jd.dataprocessing.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static com.google.common.collect.Lists.newArrayList;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.jd.dataprocessing.api.controllers"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(securityScheme()))
                .globalResponses(HttpMethod.GET, newArrayList(
                        new ResponseBuilder().code("500")
                                .description("Internal Server Error").build(),
                        new ResponseBuilder().code("403")
                                .description("Forbidden!!!!!").build(),
                        new ResponseBuilder().code("401")
                                .description("Access Denied!!!!!").build()
                ));
    }

    private ApiKey securityScheme() {
        return new ApiKey("JWT Token", "Authorization", "header");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("DATAENTRY REST API")
                .description("API FOR PERSISTING/RETRIEVING DATA FOR JD DEMO")
                .version("LATEST")
                .license("")
                .licenseUrl("API license URL")
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(
                        Collections.singletonList(new SecurityReference("JWT Token", authScope()))
                ).build();
    }

    AuthorizationScope[] authScope() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "Access API");
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = authorizationScope;
        return authScopes;
    }

}
