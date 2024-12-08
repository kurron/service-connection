package org.kurron.logging.logging;

import org.springframework.boot.testcontainers.service.connection.ContainerConnectionDetailsFactory;
import org.springframework.boot.testcontainers.service.connection.ContainerConnectionSource;

/**
 * This object is registered in spring.factories, understanding how to get connection details from a CustomVault container.
 * This information can be then be used by the ServiceConnection annotation, simplifying test setup.
 */
@SuppressWarnings("unused")
class CustomVaultContainerConnectionDetailsFactory extends ContainerConnectionDetailsFactory<CustomVaultContainer, VaultTemplateConnectionDetails> {
    // need a default constructor for Spring to use
    CustomVaultContainerConnectionDetailsFactory() {
    }

    protected VaultTemplateConnectionDetails getContainerConnectionDetails(ContainerConnectionSource<CustomVaultContainer> source) {
        return new CustomVaultContainerTemplateConnectionDetails(source);
    }

    /**
     * Creates connection details by interrogating the WireMock container.
     */
    private static final class CustomVaultContainerTemplateConnectionDetails extends ContainerConnectionDetailsFactory.ContainerConnectionDetails<CustomVaultContainer> implements VaultTemplateConnectionDetails {
        private CustomVaultContainerTemplateConnectionDetails(ContainerConnectionSource<CustomVaultContainer> source) {
            super(source);
        }

        @Override
        public String getHttpHostAddress() {
            return getContainer().getHttpHostAddress();
        }
    }
}
