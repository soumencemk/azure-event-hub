package com.soumen.poc.signmicroservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Soumen Karmakar
 * @Date 22/04/2021
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payload {
    private String txnId;
    private String body;
    private String signature;
}
