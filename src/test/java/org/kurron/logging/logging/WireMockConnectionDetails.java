package org.kurron.logging.logging;

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;

public interface WireMockConnectionDetails extends ConnectionDetails {
    String url();
    String token();
}
