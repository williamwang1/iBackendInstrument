package org.springframework.amqp.tutorials.tut1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut1Sender {

    @Autowired
    private RabbitTemplate template;
   // private AmqpTemplate amqpTemplate;
    @Autowired
    private Queue queue;
    
    @Autowired
    private Exchange exchange;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!";
       this.template.convertAndSend(queue.getName(), message);
       // this.template.convertAndSend(exchange, routingKey, object);
        //this.amqpTemplate.convertAndSend(exchange.getName(), queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}