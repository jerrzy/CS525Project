/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dictionary.service;

import com.dictionary.dao.WordDAO;
import com.dictionary.domain.Entry;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author feifei
 */
public class LookupService {

    private final WordDAO wordDAO;

    public LookupService() {
        wordDAO = new WordDAO();
        try {
            wordDAO.connect();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(LookupService.class.getName()).log(Level.SEVERE, null, ex);
        }
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
