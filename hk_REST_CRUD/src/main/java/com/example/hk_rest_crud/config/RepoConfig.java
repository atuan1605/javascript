package com.example.hk_rest_crud.config;

import com.example.hk_rest_crud.repository.PersonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepoConfig {
    @Bean
    public PersonDao personDao(){
        return new PersonDao("person.csv");
    }
}
