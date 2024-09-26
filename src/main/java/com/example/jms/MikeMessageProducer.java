package com.example.jms;

import com.example.model.MikeMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MikeMessageProducer {

    private final JmsTemplate jmsTemplate;

    public MikeMessageProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendTo(
        String destination,
        MikeMessage mikeMessage
    ) throws JsonProcessingException {
        jmsTemplate.convertAndSend(destination, mikeMessage);


        ObjectMapper objectMapper = new ObjectMapper();
        MikeMessage message = new MikeMessage("John");
        String jsonMessage = objectMapper.writeValueAsString(message);

        log.info("Producer> Message Sent : {}", jsonMessage);
    }

}
