package com.soumen.poc.signmicroservice;

import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

/**
 * @author Soumen Karmakar
 * @Date 22/04/2021
 */
@Component
public class ProducerMessageSerializer extends JsonSerializer<Payload> {

}
