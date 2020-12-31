package com.word.select.utility;

import com.word.select.exception.domain.WordSelectException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class WordSelectUtilityTest {

    @InjectMocks
    WordSelectUtility wordSelectUtility;
    private List<String> listOfWords;

    @Before
    public void init() {
        listOfWords = new ArrayList<>();
        listOfWords.add("example");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void pickRandomWordTest() {
        List<String> listOfWords = new ArrayList<>();
        listOfWords.add("example");
        wordSelectUtility.pickRandomWord(listOfWords);
    }

    @Test(expected= WordSelectException.class)
    public void pickRandomWordExceptionTest() {
        List<String> emptyList = null;
        wordSelectUtility.pickRandomWord(emptyList);
    }
}
