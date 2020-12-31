package com.word.select.dao;

import java.util.List;

/*
 * Interface which contains @DAO layer methods
 * For this use case, we defined two methods: one to get information from the cache and the other to actually construct the
 * word list and populate the cache
 * */
public interface WordSelectDao {
    List<String> getWordList();
    List<String> getFromCache();

}
