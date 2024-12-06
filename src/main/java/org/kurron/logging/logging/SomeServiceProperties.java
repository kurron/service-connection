package org.kurron.logging.logging;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for our service client.
 * @param url URL to the service.
 * @param token fake security token.
 */
@ConfigurationProperties(prefix="service-connection")
public record SomeServiceProperties(String url, String token) {}
