package com.blackapple.downloadmodule;

import com.blackapple.downloadmodule.kafka.ItemListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DownloadModuleApplication {

    

    public static void main(String[] args){
        SpringApplication.run(DownloadModuleApplication.class, args);
    }

    @Bean
    public ItemListener itemListener(){
        return new ItemListener();
    }
}
