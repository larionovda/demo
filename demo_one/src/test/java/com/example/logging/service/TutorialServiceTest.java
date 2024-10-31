package com.example.logging.service;

import com.example.logging.repository.TutorialRepository;
import com.example.logging.service.config.TutorialConfigurationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
//@Import(TutorialConfigurationTest.class)
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class TutorialServiceTest {

    @Autowired
    MockMvc mvc;

    // Интеграционный тест. Флоу от контроллера до реального взаимадействия с БД.
    @Test
    void getAllTutorials() throws Exception {
        var result = mvc.perform(get("/api/tutorials")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString();

        Assertions.assertEquals("[{\"id\":1,\"title\":\"title1\",\"description\":\"description1\",\"published\":true},{\"id\":2,\"title\":\"title2\",\"description\":\"description2\",\"published\":true},{\"id\":3,\"title\":\"title3\",\"description\":\"description3\",\"published\":true}]", result);
    }

    @TestConfiguration
    public static class TutorialConfigurationTest {

        @Bean
        public TutorialService tutorialService(TutorialRepository tutorialRepository) {
            var service =  new TutorialService(tutorialRepository);
            service.setLine("TEST");
            return service;
        }


    }

}