package com.curtain.domaindrivendesign.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Curtain
 * @date 2018/12/21 10:40
 */
@Component
@Slf4j
public class KafkaSender {

//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    //发送消息方法
//    public void send(String msg) {
//        log.info("kafka send message = {}",msg);
//        kafkaTemplate.send("test", msg);
//    }
//
//    @KafkaListener(topics = {"test"})
//    public void listen(ConsumerRecord<?, ?> record) {
//
//        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
//
//        if (kafkaMessage.isPresent()) {
//
//            Object message = kafkaMessage.get();
//
//            log.info("kafka record =" + record);
//            log.info("kafka message =" + message);
//        }
//
//    }


}
