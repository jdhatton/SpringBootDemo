package org.jd.dataprocessing.api.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class JacksonConfiguration {

    @Bean
    public SimpleModule emptyStringAsNullModule() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(String.class, new EmptyStringAsNullDeserializer());
        return module;
    }

    private static class EmptyStringAsNullDeserializer extends JsonDeserializer<String> {
        @Override
        public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String result = StringDeserializer.instance.deserialize(p, ctxt);
            return Strings.isBlank(result) ? null : result;
        }
    }
}
