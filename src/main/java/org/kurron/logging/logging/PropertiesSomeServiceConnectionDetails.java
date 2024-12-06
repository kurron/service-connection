package org.kurron.logging.logging;

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
