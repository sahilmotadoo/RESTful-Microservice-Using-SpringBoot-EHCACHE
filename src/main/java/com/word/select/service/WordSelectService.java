package com.word.select.service;

import com.word.select.domain.Word;

/*
 * Interface which contains @Service layer methods
 * For this use case, we defined one method which calls the @DAO and Utility method to get the random word
 * */
public interface WordSelectService {

    Word selectRandomWord();


}
