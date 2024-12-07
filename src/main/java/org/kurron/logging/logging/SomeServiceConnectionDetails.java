package org.kurron.logging.logging;

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;

/**
 * Modern way of transferring connection properties to beans.
 */
public interface SomeServiceConnectionDetails extends ConnectionDetails {
    String url();
    String token();
}
