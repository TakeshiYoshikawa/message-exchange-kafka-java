package com.base.clicker.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;

@ConfigurationProperties(prefix="kafka")
@Getter
public class KafkaConfiguration {

    @Value("${kafka.topic}")
    private String topic;
    
    @Value("${kafka.groupId}")
    private String groupId;
    
    @Value("${kafka.bootstrapServer}")
    private String bootstrapServer;
}
