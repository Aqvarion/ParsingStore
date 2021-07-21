package com.blackapple.downloadmodule.config;

import com.blackapple.downloadmodule.model.Item;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {


    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @Value("${spring.kafka.consumer.group-id}")
    private String kafkaGroupId;

    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String offsetReset;

    @Bean
    public ConsumerFactory<String, Item> consumerFactory() {
        JsonDeserializer<Item> itemJsonDeserializer = new JsonDeserializer<>(Item.class);
        itemJsonDeserializer.addTrustedPackages("*");
        itemJsonDeserializer.setUseTypeMapperForKey(true);
        itemJsonDeserializer.setRemoveTypeHeaders(false);


        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServer);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, itemJsonDeserializer);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,offsetReset);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaGroupId);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), itemJsonDeserializer);
    }

    @Bean
    public KafkaListenerContainerFactory<?> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Item> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}