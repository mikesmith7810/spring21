package com.example.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MikeMessageConsumer {

    @JmsListener(destination = "${activemq.destination}", containerFactory = "jmsFactory")
    public void processMessage(String mikeMessage) {
        log.info("Consumer> : {}", mikeMessage);
    }
}
