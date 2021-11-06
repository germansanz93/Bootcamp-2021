package com.intercorp.pinapper.configuration;

import com.intercorp.pinapper.domain.model.Pinapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class PinapperConfiguration {

    @Bean(name = "pinappers")
    public List<Pinapper> getPinnapers(){
        return Arrays.asList(Pinapper.builder().name("Maria").lastName("Gomez").build(),Pinapper.builder().name("Agustin").lastName("Diaz").build(),Pinapper.builder().name("Miguel").lastName("Perez").build());
    }

}
