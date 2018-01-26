/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dictionary.dao;

import com.dictionary.domain.Entry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author feifei
 */
public class WordDAO {

    private final String dbms = "mysql";
    private final String userName = "root";
    private final String password = "983315";
    private final String serverName = "localhost";
    private final String dbName = "entries";
    private final String portNumber = "3306";
    //
    private final String tableName = "entries";
    private Connection conn;

    public void connect() throws SQLException, ClassNotFoundException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", userName);
        connectionProps.put("password", password);
        if (dbms.equals("mysql")) {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:" + dbms + "://"
                    + serverName
                    + ":" + portNumber + "/" + dbName,
                    connectionProps);
        }
    }

    public void disConnect() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException ex) {
                Logger.getLogger(WordDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Entry> queryWord(String word) {

        String sql = "select wordtype, definition from " + tableName + " where word='" + word + "'";

        List<Object[]> queryResult = query(sql);
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
        String sql = "select word from " + tableName + " where word REGEXP '" + input + "'";

        List<Object[]> queryResult = query(sql);
        List<String> result = new ArrayList<String>();
        for (Object[] objects : queryResult) {
            String cur = objects[0].toString();
            if (!result.contains(cur) && !cur.equalsIgnoreCase(input)) {
                result.add(objects[0].toString());
            }
        }

        return result;
    }

    private List<Object[]> query(String sql) {

        List<Object[]> result = new ArrayList<Object[]>();
//        Statement statement = null;
         try (Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery(sql)) {
            int colCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[colCount];
                for (int i = 0; i < colCount; i++) {
                    row[i] = rs.getObject(i + 1);
                }

                result.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println(sql);
        }
//        try (Statement statement = conn.createStatement();
//                ResultSet rs = statement.executeQuery(sql)) {
//            int colCount = rs.getMetaData().getColumnCount();
//            while (rs.next()) {
//                Object[] row = new Object[colCount];
//                for (int i = 0; i < colCount; i++) {
//                    row[i] = rs.getObject(i + 1);
//                }
//
//                result.add(row);
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//            System.out.println(sql);
//        }
        return result;
    }
}
