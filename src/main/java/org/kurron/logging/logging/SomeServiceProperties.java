package org.kurron.logging.logging;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="service-connection")
public record SomeServiceProperties(String url, String token) {
}
