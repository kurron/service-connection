package org.kurron.logging.logging;

import org.springframework.web.client.RestClient;

/**
 * Implementation using RestClient to do the heavy lifting.
 */
public class SomeServiceTemplate implements SomeServiceOperations {

    private final RestClient client;

    public SomeServiceTemplate(RestClient client) {
        this.client = client;
    }

    @Override
    public String sayHello() {
        return client.get().uri("/some-service/hello").retrieve().body(String.class);
    }
}
