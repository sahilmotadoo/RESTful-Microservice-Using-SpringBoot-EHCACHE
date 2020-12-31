package com.word.select.service.impl;

import com.word.select.dao.WordSelectDao;
import com.word.select.domain.Word;
import com.word.select.service.WordSelectService;
import com.word.select.utility.WordSelectUtility;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Class which implements @Service interface
 * Contains the method definition which calls the @DAO and Utility method to get the random word
 * */

@Service
public class WordSelectServiceImpl implements WordSelectService {

    private WordSelectDao wordSelectDao;
    private WordSelectUtility wordSelectUtility;
    private Logger logger = Logger.getLogger(this.getClass().getName());


    @Autowired
    WordSelectServiceImpl(WordSelectDao wordSelectDao, WordSelectUtility wordSelectUtility) {
        this.wordSelectDao = wordSelectDao;
        this.wordSelectUtility = wordSelectUtility;
    }

    @Override
    public Word selectRandomWord() {
        logger.debug("Calling selectRandomWord() method within @Service layer");
        logger.info("Reading from cache using @Cacheable");
        List<String> listOfWords = wordSelectDao.getFromCache();
        return wordSelectUtility.pickRandomWord(listOfWords);

    }
}
