package org.kurron.logging.logging;

/**
 * Supported service gateway functions.
 */
public interface SomeServiceOperations {
    /**
     * Tickle the system with an HTTP GET call.
     * @return response from the /hello resource.
     */
    String sayHello();
}
