package com.example.logging.service;

import com.example.logging.model.Tutorial;
import com.example.logging.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//@Service
public class TutorialService {

    private String line;

    @Autowired
    TutorialRepository tutorialRepository;

    public TutorialService(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    public List<Tutorial> getAllTutorials(@RequestParam(required = false) String title) {
        if (title == null) {
            System.out.println("SERVICE TUTORIAL AND " + line);
            return tutorialRepository.findAll();
        } else {
            return tutorialRepository.findByTitleContaining(title);
        }

    }

    public void setLine(String line) {
        this.line = line;
    }
}
