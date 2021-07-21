package com.blackapple.parsingmodule.kafka;

import com.blackapple.parsingmodule.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;


public class ItemProducer {

    @Autowired
    private KafkaTemplate<String, Item> itemKafkaTemplate;

    public void sendItem(Item item){
        ListenableFuture<SendResult<String, Item>> future = itemKafkaTemplate.send("items", item);
        future.addCallback(System.out::println,System.err::println);
        itemKafkaTemplate.flush();
    }
}
