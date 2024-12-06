package org.kurron.logging.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.web.client.RestClient;
import org.testcontainers.containers.output.Slf4jLogConsumer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.wiremock.integrations.testcontainers.WireMockContainer;

import static org.junit.Assert.assertNotNull;

@SpringBootTest(classes = TestcontainersWiremockExampleApplicationTests.SpringWantsThis.class)
@Testcontainers
public class TestcontainersWiremockExampleApplicationTests {
    private static final Logger LOGGER = LoggerFactory.getLogger("wiremock");

    @Configuration
    @EnableConfigurationProperties(SomeServiceProperties.class)
    static class SpringWantsThis {
        @Bean
        SomeServiceClient someServiceClient(SomeServiceProperties properties) {
            var url = properties.url() + "/some-service/hello";
            return new SomeServiceClient(RestClient.builder().baseUrl(url).build());
        }

        @Bean
        SomeService someService(SomeServiceClient client) {
            return new SomeService(client);
        }
    }

    @Container
    static WireMockContainer wireMock = new WireMockContainer("wiremock/wiremock:3.2.0-alpine")
            .withMappingFromResource("some-service-mapping", "some-service-mapping.json")
            .withLogConsumer(new Slf4jLogConsumer(LOGGER));

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("service-connection.url", wireMock::getBaseUrl);
        registry.add("service-connection.token", () -> "test");
    }

    @Autowired
    private SomeService sut;

    @Test
    void contextLoads() {
        assertNotNull(sut);
        var response = sut.randomText();
        System.out.println("Response is " + response);
        assertNotNull(response);
    }
}
