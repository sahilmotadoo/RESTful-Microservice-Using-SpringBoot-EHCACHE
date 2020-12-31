package com.word.select.service.impl;


import com.word.select.dao.impl.WordSelectDaoImpl;
import com.word.select.domain.Word;
import com.word.select.utility.WordSelectUtility;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/*
*
*
*
*
*
* */

@RunWith(MockitoJUnitRunner.class)
public class WordSelectServiceImplTest {

    private List<String> listOfWords;
    private Word word;


    @Mock
    private WordSelectDaoImpl wordSelectDao;
    @Mock
    private WordSelectUtility wordSelectUtility;
    @InjectMocks
    private WordSelectServiceImpl wordSelectService;

    @Before
    public void init() {
        listOfWords = new ArrayList<>();
        listOfWords.add("example");
        listOfWords.add("excellent");
        listOfWords.add("apple");
        listOfWords.add("banana");

        word = new Word();
        word.setRandomWord("apple");

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void selectRandomWordTest() {
        when(wordSelectDao.getFromCache()).thenReturn(listOfWords);
        when(wordSelectUtility.pickRandomWord(listOfWords)).thenReturn(word);

        assertThat(listOfWords, hasItems(wordSelectService.selectRandomWord().getRandomWord()));
    }
}
