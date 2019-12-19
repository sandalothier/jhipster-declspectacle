package com.fisc.declspectacle.web.rest;

import com.fisc.declspectacle.service.DeclspectacleKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/declspectacle-kafka")
public class DeclspectacleKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DeclspectacleKafkaResource.class);

    private DeclspectacleKafkaProducer kafkaProducer;

    public DeclspectacleKafkaResource(DeclspectacleKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
