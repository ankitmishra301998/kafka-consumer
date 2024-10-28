package com.kafka.consumer.service;

import com.kafka.consumer.dto.Employee;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {

    @KafkaListener(topics = "javatechie-custom-topic", groupId = "jt-group-1")   //group id is needed to be mentioned even if there's only one consumer
    public void consume(String message) {
        System.out.println("Message recieved : " + message);
    }

    @KafkaListener(topics = "javatechie-custom-topic", groupId = "jt-group-1")
    public void consume1(String message) {
        System.out.println("Message recieved1 : " + message);
    }

    @KafkaListener(topics = "javatechie-custom-topic", groupId = "jt-group-1")
    public void consume2(String message) {
        System.out.println("Message recieved2 : " + message);
    }


//    each consumer of the same group will be assigned a partition and if consumer count > partition count the extra consumer will sit idle
    @KafkaListener(topics = "javatechie-custom-topic", groupId = "jt-group-1")
    public void consume3(String message) {
        System.out.println("Message recieved3 : " + message);
    }

    @KafkaListener(topics = "javatechie-custom-topic", groupId = "jt-group-2")
    public void consumeEmployee(Employee employee) {
        System.out.println("employee recieved3 : " + employee.toString());
    }
}
