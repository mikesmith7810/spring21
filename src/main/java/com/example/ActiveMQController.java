package com.example;

import com.example.jms.MikeMessageProducer;
import com.example.model.MikeMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ActiveMQController {


    private JmsTemplate jmsTemplate;

    private MikeMessageProducer mikeMessageProducer;

    @Value("${activemq.destination}")
    private String destination;

    public ActiveMQController(
        JmsTemplate jmsTemplate,
        MikeMessageProducer mikeMessageProducer
    ) {
        this.jmsTemplate = jmsTemplate;
        this.mikeMessageProducer = mikeMessageProducer;
    }

    @GetMapping("/message")
    public String addMessage(@RequestBody final MikeMessage personalDetails) {
        try {
            log.info("Adding a message");
            mikeMessageProducer.sendTo(destination, personalDetails);
        }
        catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return "DONE";
    }

}
