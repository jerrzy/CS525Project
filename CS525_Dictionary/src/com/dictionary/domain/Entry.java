/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dictionary.domain;

/**
 *
 * @author feifei
 */
public class Entry {

    private String word;
    private String type;
    private String definition;

    public Entry() {
    }

    public Entry(String word, String type, String definition) {
        this.word = word;
        this.type = type;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

}
