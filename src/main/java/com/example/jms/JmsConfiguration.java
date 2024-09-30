package com.example.jms;

import jakarta.jms.ConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
@EnableJms
public class JmsConfiguration {


    @Bean
    public JmsListenerContainerFactory<?> jmsFactory(ConnectionFactory connectionFactory,
        DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        //factory.setMessageConverter(jacksonJmsMessageConverter());
        factory.setMessageConverter(new SimpleMessageConverter());
        configurer.configure(factory, connectionFactory);
        return factory;
    }

    //    @Bean
    //    public MessageConverter jacksonJmsMessageConverter() {
    //        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
    //        converter.setTargetType(MessageType.TEXT);
    //        converter.setTypeIdPropertyName("_mietype");
    //        return converter;
    //    }

}
