package com.hardtech.devoxx.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
class HomeControllerIntegrationTest {


    private int port = 8080;

    @Test
    void runAndInvokeHome(){
        String url = "http://localhost:" + port + "/";
        String body = new TestRestTemplate("user", "user").getForObject(url, String.class);
        System.out.println(body);
    }
}