package org.kurron.logging.logging;

import org.springframework.stereotype.Service;

@Service
public class SomeService {
    private final SomeServiceClient client;

    public SomeService(SomeServiceClient connection) {
        this.client = connection;
    }

    public String randomText() {
        return client.connection().get().retrieve().body(String.class);
    }
}
