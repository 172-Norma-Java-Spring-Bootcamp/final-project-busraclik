package com.example.finalproject1.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean   //spring in bunun icin bir instance olusturması icin
    public ModelMapper getModelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        //olsturulan instance'in esleştirme stratejisi belirlenir
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;

    }
}
