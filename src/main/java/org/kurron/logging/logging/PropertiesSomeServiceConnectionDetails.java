package org.kurron.logging.logging;

/**
 * Normally, this would be part of an AutoConfiguration, pulling values from application.yml. Since we're showcasing
 * a custom ConnectionDetails implementation, this is never used.
 */
public class PropertiesSomeServiceConnectionDetails implements SomeServiceConnectionDetails {
    private final SomeServiceProperties properties;

    public PropertiesSomeServiceConnectionDetails(SomeServiceProperties properties) {
        this.properties = properties;
    }

    @Override
    public String url() {
        return properties.url();
    }

    @Override
    public String token() {
        return properties.token();
    }
}
