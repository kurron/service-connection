package org.kurron.logging.logging;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Normally, this object would be packaged as part of an AutoConfiguration but, we don't need it for this example.
 * @param url URL to the service.
 * @param token fake security token.
 */
@ConfigurationProperties(prefix="service-connection")
public record SomeServiceProperties(String url, String token) {}
