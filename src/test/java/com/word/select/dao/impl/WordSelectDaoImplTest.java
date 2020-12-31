package com.word.select.dao.impl;

import com.word.select.exception.domain.WordSelectException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class WordSelectDaoImplTest {

    @InjectMocks
    private WordSelectDaoImpl wordSelectDao;
    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getFromCacheTest() {
        ReflectionTestUtils.setField(wordSelectDao, "filePath", "../wordselect/src/main/resources/words_alpha.txt");
        wordSelectDao.getFromCache();
    }

    @Test(expected= WordSelectException.class)
    public void getFromCacheExceptionTest() {
        ReflectionTestUtils.setField(wordSelectDao, "filePath", "words_alpha.txt");
        wordSelectDao.getFromCache();
    }
}
