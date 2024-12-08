package org.kurron.logging.logging;

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;

public interface VaultTemplateConnectionDetails extends ConnectionDetails {
    String getHttpHostAddress();
}
