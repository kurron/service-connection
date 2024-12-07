package org.kurron.logging.logging;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.wiremock.integrations.testcontainers.WireMockContainer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Showcase how configure gateway templates to automatically connect to WireMock containers during testing.
 * A variation of <a href="https://www.docker.com/blog/building-spring-boots-serviceconnection-for-testcontainers-wiremock/">Building Spring Boot’s ServiceConnection for Testcontainers WireMock</a>
 */
@SpringBootTest(classes = TestcontainersWiremockExampleApplicationTests.ExampleConfiguration.class)
@Testcontainers
public class TestcontainersWiremockExampleApplicationTests {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestcontainersWiremockExampleApplicationTests.class);

    @Configuration
    @EnableConfigurationProperties(SomeServiceProperties.class)
    static class ExampleConfiguration {
        @Bean
        SomeServiceOperations someServiceOperations(SomeServiceTemplateConnectionDetails connectionDetails) {
            var url = connectionDetails.url();
            var token = connectionDetails.token();
            LOGGER.info("Connection details contains {}, {}", token, url);
            return new SomeServiceTemplate(RestClient.builder().baseUrl(url).build());
        }
    }

    @Container
    @ServiceConnection // connection information is obtained automagically via WireMockContainerConnectionDetailsFactory.
    static WireMockContainer wireMock = new WireMockContainer("wiremock/wiremock:3.2.0-alpine").withMappingFromResource("some-service-mapping", "some-service-mapping.json");

    @Autowired
    private SomeServiceOperations subjectUnderTest;

    @Test
    @DisplayName("verify we can talk to WireMock")
    void contextLoads() {
        assertNotNull(subjectUnderTest);
        var response = subjectUnderTest.randomText();
        LOGGER.info("Response is {}", response);
        assertNotNull(response);
    }
}
