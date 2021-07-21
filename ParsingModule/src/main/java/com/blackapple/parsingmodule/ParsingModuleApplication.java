package com.blackapple.parsingmodule;

import com.blackapple.parsingmodule.kafka.ItemProducer;
import com.blackapple.parsingmodule.service.ParsingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ParsingModuleApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootApplication.class);

    @Autowired
    ParsingService parsingService;

    public static void main(String[] args) {
        SpringApplication.run(ParsingModuleApplication.class, args);
    }

    @Bean
    public ItemProducer itemProducer(){
        return new ItemProducer();
    }


    @Override
    public void run(String... args){


        try {
            LOG.info("Parser started");
            parsingService.parsinger();
            LOG.info("Parser has ended");

        }catch (Exception e){
            LOG.error("Error {}", e.getMessage());
        }
    }
}
