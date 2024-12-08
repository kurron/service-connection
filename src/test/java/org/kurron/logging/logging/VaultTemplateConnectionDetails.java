package org.kurron.logging.logging;

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;

public interface VaultTemplateConnectionDetails extends ConnectionDetails {
    /**
     * Connection string useful as a base RestClient path.
     * @return host, port and path to use.
     */
    String getBaseURI();
}
