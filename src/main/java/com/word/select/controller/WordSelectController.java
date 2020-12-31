package com.word.select.controller;

import com.word.select.domain.Word;
import com.word.select.service.WordSelectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * REST Controller class for the word select application
 * It contains the GET method to select a word at random
 * Other verbs such as PUT, POST, DELETE can be defined in this file
 * */
@RestController
public class WordSelectController {

    private WordSelectService wordSelectService;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    WordSelectController(WordSelectService wordSelectService) {
        this.wordSelectService = wordSelectService;
    }
    @GetMapping("/word/select")
    public ResponseEntity<Word> selectRandomWordController() {
        logger.debug("Calling GET method for word-select");
        return new ResponseEntity<>(wordSelectService.selectRandomWord(), HttpStatus.OK);
    }
}
