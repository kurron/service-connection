package org.kurron.logging.logging;

import org.springframework.boot.testcontainers.service.connection.ContainerConnectionDetailsFactory;
import org.springframework.boot.testcontainers.service.connection.ContainerConnectionSource;
import org.wiremock.integrations.testcontainers.WireMockContainer;

/**
 * This object is registered in spring.factories, understanding how to get connection details from a WireMock container.
 * This information can be then be used by the ServiceConnection annotation.
 */
@SuppressWarnings("unused")
class WireMockContainerConnectionDetailsFactory extends ContainerConnectionDetailsFactory<WireMockContainer, SomeServiceConnectionDetails> {
    // need a default constructor for Spring to use
    WireMockContainerConnectionDetailsFactory() {}

    protected SomeServiceConnectionDetails getContainerConnectionDetails(ContainerConnectionSource<WireMockContainer> source) {
        return new WireMockContainerConnectionDetails(source);
    }

    /**
     * Creates connection details by interrogating the WireMock container.
     */
    private static final class WireMockContainerConnectionDetails extends ContainerConnectionDetailsFactory.ContainerConnectionDetails<WireMockContainer> implements SomeServiceConnectionDetails {
        private WireMockContainerConnectionDetails(ContainerConnectionSource<WireMockContainer> source) {
            super(source);
        }

        @Override
        public String url() {
            return getContainer().getBaseUrl();
        }

        @Override
        public String token() {
            return "wire-mock-token";
        }
    }
}
