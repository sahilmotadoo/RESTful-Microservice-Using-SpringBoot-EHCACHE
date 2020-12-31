package com.word.select.controller;

import com.word.select.domain.Word;
import com.word.select.service.WordSelectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WordSelectControllerTest {

    private Word word;


    @Mock
    private WordSelectService wordSelectService;

    @InjectMocks
    private WordSelectController wordSelectController;

    @Before
    public void init() {
        word = new Word();
        word.setRandomWord("random");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void selectRandomWordTest() {
        when(wordSelectService.selectRandomWord()).thenReturn(word);
        wordSelectController.selectRandomWordController();
    }

    @Test
    public void selectRandomWordTestForHttpStatus() {
        when(wordSelectService.selectRandomWord()).thenReturn(word);
        assertEquals(wordSelectController.selectRandomWordController().getStatusCode(), HttpStatus.OK);

    }
}
