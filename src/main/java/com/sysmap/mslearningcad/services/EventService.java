package com.sysmap.mslearningcad.services;

import com.sysmap.mslearningcad.services.models.CreatedStudentEventDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private String topic;

    private KafkaTemplate<String, CreatedStudentEventDTO> kafkaTemplate;

    public EventService(
        @Value("${kafka-topic-name}")
        String topic,
        KafkaTemplate<String, CreatedStudentEventDTO> kafkaTemplate
    ) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCreatedStudentEvent(CreatedStudentEventDTO dto) {
        System.out.println("Emited Event: " + dto.toString());
        this.kafkaTemplate.send(this.topic, dto);
    }
}
