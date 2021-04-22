package com.soumen.poc.signmicroservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Soumen Karmakar
 * @Date 22/04/2021
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResponseProducer {

    private final KafkaTemplate<String, Payload> kafkaTemplate;
    @Value("${topic.response}")
    private String RESPONSE_TOPIC_NAME;

    @Value("${topic.sign}")
    private String SIGN_TOPIC_NAME;


    public void produce(Payload payload) {
        this.kafkaTemplate.send(RESPONSE_TOPIC_NAME, payload);
        log.info("Published the message [{}] to the kafka topic: [{}]",
                payload,
                RESPONSE_TOPIC_NAME
        );
    }

    public void publishSign(Payload payload) {
        this.kafkaTemplate.send(SIGN_TOPIC_NAME, payload);
    }

}
