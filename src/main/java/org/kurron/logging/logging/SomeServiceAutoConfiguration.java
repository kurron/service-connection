package org.kurron.logging.logging;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;

@AutoConfiguration
@EnableConfigurationProperties(SomeServiceProperties.class)
public class SomeServiceAutoConfiguration {
    @Bean
    SomeServiceClient someServiceClient(SomeServiceProperties properties, RestClient.Builder restClientBuilder) {
        return new SomeServiceClient(restClientBuilder.baseUrl(properties.url()).build());
    }
}
