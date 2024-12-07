package org.kurron.logging.logging;

/**
 * Normally, this would be part of an AutoConfiguration, but, we don't need it for this example.
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
