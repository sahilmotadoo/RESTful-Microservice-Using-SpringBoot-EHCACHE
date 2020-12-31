package com.word.select.cache;

import org.apache.log4j.Logger;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * CacheEventLogger class logs cache events such as CREATED, UPDATED, EXPIRED, EVICTED
 * These events can be configured in the ehcache.xml file
 * Populating the cache will trigger a cache hit (CREATED) event
 * After TTL, a cache miss will trigger (EXPIRED) event and @Cacheable will repopulate the cache
 * */

public class CacheEventLogger implements CacheEventListener<Object, Object> {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void onEvent(CacheEvent cacheEvent) {
        logger.debug("Logging ehcache event");
        List<String> listOfWords = (ArrayList)cacheEvent.getNewValue();
        int size = Objects.isNull(listOfWords) ? 0 : listOfWords.size();
        logger.info("Cache event = {"+cacheEvent.getType()+"}, Key = {"+cacheEvent.getKey()+"}, List size = {"+size+"}");
    }
}