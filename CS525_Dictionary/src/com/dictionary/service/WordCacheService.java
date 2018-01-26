/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dictionary.service;

import java.util.HashMap;

/**
 *
 * @author feifei
 */
public class WordCacheService {

    private final HashMap<String, String> wordCacheHashMap;

    public WordCacheService() {
        wordCacheHashMap = new HashMap<>();
    }

    public boolean cached(String word) {
        return wordCacheHashMap.containsKey(word);
    }

    public String get(String word) {
        return wordCacheHashMap.get(word);
    }

    public void set(String word, String explain) {
        wordCacheHashMap.put(word, explain);
    }
}
