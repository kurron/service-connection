package org.kurron.logging.logging;

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;

public interface RestClientConnectionDetails extends ConnectionDetails {
    String getHttpHostAddress();
}
