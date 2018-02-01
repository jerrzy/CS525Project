/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dictionary.service;

import com.dictionary.dao.WordDAO;
import com.dictionary.domain.Entry;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author feifei
 */
public class LookupService {

    private final WordDAO wordDAO;

    public LookupService() {
        wordDAO = new WordDAO();
    }

    public String lookup(String input) {

        if (wordDAO != null) {

            List<Entry> result = wordDAO.queryWord(input);
            Gson gson = new Gson();
            String json = gson.toJson(result);
            return json;
//            System.out.println(json);
        }
        return "";
    }

    public String lookupSimilarWords(String input) {
        if (wordDAO != null) {
            List<String> result = wordDAO.querySimilarWords(input);
            Gson gson = new Gson();
            String json = gson.toJson(result);
            return json;
        }
        return "";
    }
}
