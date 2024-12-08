package org.kurron.logging.logging;

import org.springframework.boot.testcontainers.service.connection.ContainerConnectionDetailsFactory;
import org.springframework.boot.testcontainers.service.connection.ContainerConnectionSource;
import org.wiremock.integrations.testcontainers.WireMockContainer;

/**
 * This object is registered in spring.factories, understanding how to get connection details from a WireMock container.
 * This information can be then be used by the ServiceConnection annotation, simplifying test setup.
 */
@SuppressWarnings("unused")
class WireMockContainerConnectionDetailsFactory extends ContainerConnectionDetailsFactory<WireMockContainer, RestClientConnectionDetails> {
    // need a default constructor for Spring to use
    WireMockContainerConnectionDetailsFactory() {}

    protected RestClientConnectionDetails getContainerConnectionDetails(ContainerConnectionSource<WireMockContainer> source) {
        return new WireMockContainerTemplateConnectionDetails(source);
    }

    /**
     * Creates connection details by interrogating the WireMock container.
     */
    private static final class WireMockContainerTemplateConnectionDetails extends ContainerConnectionDetailsFactory.ContainerConnectionDetails<WireMockContainer> implements RestClientConnectionDetails {
        private WireMockContainerTemplateConnectionDetails(ContainerConnectionSource<WireMockContainer> source) {
            super(source);
        }

        @Override
        public String getHttpHostAddress() {
            return getContainer().getBaseUrl();
        }
    }
}
