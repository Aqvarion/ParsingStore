package com.blackapple.parsingmodule;

import com.blackapple.parsingmodule.kafka.ItemProducer;
import com.blackapple.parsingmodule.service.ParsingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParsingModuleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ParsingModuleApplication.class, args);

        ParsingService parsingService = context.getBean(ParsingService.class);
        parsingService.parsinger();

        context.close();
    }

    @Bean
    public ItemProducer itemProducer(){
        return new ItemProducer();
    }


}
