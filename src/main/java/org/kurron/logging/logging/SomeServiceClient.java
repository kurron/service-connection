package org.kurron.logging.logging;

import org.springframework.web.client.RestClient;

/**
 * Showcase how to automatically configure the RestClient via ServiceConnection annotation.
 */
public class SomeServiceClient {

    private final RestClient client;

    public SomeServiceClient(RestClient client) {
        this.client = client;
    }

    String randomText() {
        return client.get().retrieve().body(String.class);
    }
}
