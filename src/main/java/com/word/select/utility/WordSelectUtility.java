package com.word.select.utility;

import com.word.select.domain.Word;
import com.word.select.exception.domain.WordSelectException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/*
 * Utility class which uses a Random class function to generate a random index and pick a word from the word list
 * The size of the word list is used as a upper bound so we do not generate index values outside the word list range
 * The result is then wrapped into a Word object and returned as a result
 * */

@Component
public class WordSelectUtility {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public Word pickRandomWord(List<String> listOfWords) {
        logger.debug("Calling pickRandomWord() method within Utility class");
        if(listOfWords == null) {
            throw new WordSelectException("Encountered NULL array list","List<String> listOfWords is NULL");
        }
        logger.info("Generating random index for word selection");
        Random rand = new Random();
        Word selectedWord = new Word();
        selectedWord.setRandomWord(listOfWords.get(rand.nextInt(listOfWords.size())));
        return selectedWord;
    }
}
