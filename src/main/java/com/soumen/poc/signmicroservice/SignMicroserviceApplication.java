package com.soumen.poc.signmicroservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
@RestController
public class SignMicroserviceApplication {
    private final ResponseProducer responseProducer;

    public static void main(String[] args) {
        SpringApplication.run(SignMicroserviceApplication.class, args);
    }

    @GetMapping("/test-sign")
    public ResponseEntity<Map> testResponsePublish() {
        log.info("--- Initiating sample Sign request ---");
        Payload payload = Payload.builder().body("{\"Hello\":\"Good-bye\"}").txnId("txn_1").build();
        responseProducer.publishSign(payload);
        return new ResponseEntity(Map.entry("status", "SUCCESS"), HttpStatus.OK);

    }

}
