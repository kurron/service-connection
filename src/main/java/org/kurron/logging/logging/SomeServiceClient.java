package org.kurron.logging.logging;

import org.springframework.web.client.RestClient;

public class SomeServiceClient {

    private final RestClient client;

    public SomeServiceClient(RestClient client) {
        this.client = client;
    }

    RestClient connection() {
        return client;
    }
}
