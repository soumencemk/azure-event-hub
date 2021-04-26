package com.soumen.poc.signmicroservice;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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
    public Mono<Response> testResponsePublish() {
        log.info("--- Initiating sample Sign request ---");
        Payload payload = Payload.builder().body("{\"Hello\":\"Good-bye\"}").txnId("txn_1").build();
        responseProducer.publishSign(payload);
        return Mono.just(Response.builder().tag("status").desc("SUCCESS").build());

    }

}

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Response {
    private String tag;
    private String desc;
}
