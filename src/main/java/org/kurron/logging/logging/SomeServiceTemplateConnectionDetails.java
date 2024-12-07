package org.kurron.logging.logging;

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;

/**
 * Modern way of transferring connection properties to beans.
 */
public interface SomeServiceTemplateConnectionDetails extends ConnectionDetails {

    /**
     * Obtains the URL to use for the connection.
     * @return connection URL.
     */
    String url();

    /**
     * Obtains the required security token.
     * @return required authentication token.
     */
    String token();
}
