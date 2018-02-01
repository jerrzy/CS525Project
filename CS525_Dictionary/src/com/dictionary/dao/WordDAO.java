/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dictionary.dao;

import java.util.ArrayList;
import java.util.List;

import com.dictionary.DBConnection;
import com.dictionary.domain.Entry;

/**
 *
 * @author feifei
 */
public class WordDAO {

	private final String tableName = "entries";
	private final String queryWordSQLTemplate = "SELECT wordtype, definition from " + tableName + " WHERE word=? ";
	private final String fuzzyQueryWordSQLTemplate = "SELECT word from " + tableName + " WHERE word REGEXP ?";

	public List<Entry> queryWord(String word) {

		List<Object[]> queryResult = DBConnection.getInstance().query(queryWordSQLTemplate, new Object[] { word });
		List<Entry> result = new ArrayList<Entry>();
		for (Object[] objects : queryResult) {
			Entry entry = new Entry();
			try {
				entry.setWord(word);
				entry.setType(objects[0].toString());
				entry.setDefinition(objects[1].toString());
			} catch (Exception e) {
			}
			result.add(entry);
		}
		return result;
	}

	public List<String> querySimilarWords(String input) {

		List<Object[]> queryResult = DBConnection.getInstance().query(fuzzyQueryWordSQLTemplate,
				new Object[] { input });
		List<String> result = new ArrayList<String>();
		for (Object[] objects : queryResult) {
			String cur = objects[0].toString();
			if (!result.contains(cur) && !cur.equalsIgnoreCase(input)) {
				result.add(objects[0].toString());
			}
		}

		return result;
	}
}
