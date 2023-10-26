package org.jd.dataprocessing.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class RequestLoggingFilterConfig {

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        //adds REST request url and payload to logs automatically
        CustomCommonsRequestLoggingFilter filter = new CustomCommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(false);
        return filter;
    }

    public static class CustomCommonsRequestLoggingFilter extends CommonsRequestLoggingFilter {
        @Override
        protected boolean shouldLog(HttpServletRequest request) {
            return !request.getRequestURL().toString().contains("actuator");
        }
    }
}
