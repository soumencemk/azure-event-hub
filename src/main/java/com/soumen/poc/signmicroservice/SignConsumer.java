package com.soumen.poc.signmicroservice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Soumen Karmakar
 * @Date 22/04/2021
 */
@Service
@Slf4j
@AllArgsConstructor
public class SignConsumer {

    private final ResponseProducer producer;

    @KafkaListener(topics = "${topic.sign}")
    public void receiveSign(String payload) {
        log.info("Received Sign message from kafka topic: {}", payload);
        log.info("DOING HSM SIGN");
        Payload response = dummySign(payload);
        log.info("SIGNATURE CONTENT : {}", response.getSignature());
        log.info("PRODUCING MESSAGE to Kafka Response topic");
        producer.produce(response);
    }

    private Payload dummySign(String payload) {
        return Payload.builder().txnId("txn_1").body("koqdpiqninqfjioqhiqnci").signature(UUID.randomUUID().toString()).build();
    }
}
