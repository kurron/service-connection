package org.kurron.logging.logging;

import org.springframework.boot.autoconfigure.service.connection.ConnectionDetails;

/**
 * Using this form to obtain connection details allows us to use the convenient @ServiceConnection annotation in our tests.
 */
public interface SomeServiceConnectionDetails extends ConnectionDetails {
    String url();
    String token();
}
