package com.gamboatech.infrastructure.driveradapters.rest.client.config;

import com.gamboatech.infrastructure.driveradapters.rest.client.config.properties.RestTemplateProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;

@Configuration
public class RestTemplateConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.rest-template")
    public RestTemplateProperties getRestTemplateProperties() {
        return new RestTemplateProperties();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateProperties restTemplateProperties) {
        if (restTemplateProperties.getSsl().isEnable()) return new RestTemplate();

        RestTemplateCustomizer customizer = restTemplate -> {
            restTemplate.setRequestFactory(new NoopRequestFactory());
        };
        return new RestTemplateBuilder().additionalCustomizers(customizer).build();
    }

    private static class NoopRequestFactory extends SimpleClientHttpRequestFactory {
        @Override
        protected void prepareConnection(HttpURLConnection connection, String httpMethod) throws IOException {
            if (connection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) connection).setHostnameVerifier((hostname, session) -> true);
            }
            super.prepareConnection(connection, httpMethod);
        }
    }
}
