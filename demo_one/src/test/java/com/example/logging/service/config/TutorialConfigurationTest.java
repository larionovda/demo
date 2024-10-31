package com.example.logging.service.config;

import com.example.logging.repository.TutorialRepository;
import com.example.logging.service.TutorialService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TutorialConfigurationTest {

    @Bean
    public TutorialService tutorialService(TutorialRepository tutorialRepository) {
        var service =  new TutorialService(tutorialRepository);
        service.setLine("TEST");
        return service;
    }


}
