package com.example.jms;

import com.example.model.MikeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MikeMessageConsumer {

    @JmsListener(destination = "${activemq.destination}", containerFactory = "jmsFactory")
    public void processToDo(MikeMessage mikeMessage) {
        log.info("Consumer> : {}", mikeMessage);
    }
}
