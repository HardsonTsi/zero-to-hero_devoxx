package com.hardtech.devoxx.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


@SpringBootTest
class HomeControllerIntegrationTest {


    private final int port = 8080;
    String url = "http://localhost:" + port + "/";

    @Test
    void runAndInvokeHome() {

        String body = new TestRestTemplate("user", "user").getForObject(url, String.class);
        System.out.println(body);
    }

}