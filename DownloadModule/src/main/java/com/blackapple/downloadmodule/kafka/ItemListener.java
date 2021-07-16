package com.blackapple.downloadmodule.kafka;

import com.blackapple.downloadmodule.model.Item;
import com.blackapple.downloadmodule.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
public class ItemListener {

    @Autowired
    private ItemRepository itemRepository;

    @KafkaListener(topics = "items")
    public void listenItem(Item item){
        System.out.println(item);
        itemRepository.save(item);

    }
}
