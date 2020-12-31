package com.word.select.dao.impl;

import com.word.select.dao.WordSelectDao;
import com.word.select.exception.domain.WordSelectException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Class which implements @DAO interface
 * Contains the method definitions for constructing word list and populating cache
 * */

@Component
public class WordSelectDaoImpl implements WordSelectDao {

    @Value("${file.path}")
    private String filePath;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Cacheable(cacheNames = "wordlist", key = "'wordlist'")
    public List<String> getFromCache() {
        return getWordList();
    }

    public List<String> getWordList() {
        logger.debug("Calling getWordList() method in @DAO layer");
        Scanner s;
        try {
            logger.info("Reading file from path");
            s = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            logger.error("Error occurred while trying to read file from source");
            throw new WordSelectException("Error occurred while trying to read file from source", e.getMessage());
        }
        List<String> list = new ArrayList<>();
        logger.info("Creating word list array");
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        logger.info("Populating cache with word list array");
        return list;
    }
}
