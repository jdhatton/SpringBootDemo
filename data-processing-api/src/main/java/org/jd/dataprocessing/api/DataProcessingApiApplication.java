package org.jd.dataprocessing.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {
        DataProcessingApiApplication.BASE_PACKAGE})
@EnableAsync
@EnableWebMvc
@EnableCaching
@EnableFeignClients(basePackages = {"org.jd.domain.feign"})
@ConfigurationPropertiesScan(DataProcessingApiApplication.BASE_PACKAGE)
@ComponentScan({DataProcessingApiApplication.BASE_PACKAGE})
@EnableJpaRepositories(value = "org.jd.dataprocessing.core")
@EntityScan("org.jd.dataprocessing.core")
public class DataProcessingApiApplication {
    public static final String BASE_PACKAGE = "org.jd.dataprocessing";

    public static void main(String[] args) {
        SpringApplication.run(DataProcessingApiApplication.class, args);
    }

    // docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=Password123" -p 1433:1433 -d mcr.microsoft.com/mssql/server:2022-latest

}