package com.example.logging.configuration;

import com.example.logging.repository.TutorialRepository;
import com.example.logging.service.TutorialService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTutorial {

    @Bean
    public TutorialService tutorialService(TutorialRepository tutorialRepository) {
        var service =  new TutorialService(tutorialRepository);
        service.setLine("DEV");
        return service;
    }

}
