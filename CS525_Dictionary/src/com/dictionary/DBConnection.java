/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.dictionary.dao.WordDAO;

/**
 *
 * @author feifei
 */
public class DBConnection {

	/**
	 * factory method pattern
	 */
	private static DBConnection instance;

	private final String dbms = "mysql";
	private final String userName = "root";
	private final String password = "983315";
	private final String serverName = "localhost";
	private final String dbName = "entries";
	private final String portNumber = "3306";
	private Connection conn;
	private static Object mutualObject = new Object();

	private DBConnection() {
		try {
			connect();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static DBConnection getInstance() {
		if (instance == null) {
			synchronized (mutualObject) {
				instance = new DBConnection();
			}
		}
		return instance;
	}

	public void connect() throws SQLException, ClassNotFoundException {
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("password", password);
		if (dbms.equals("mysql")) {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:" + dbms + "://" + serverName + ":" + portNumber + "/" + dbName,
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

	public List<Object[]> query(String sql) {

		List<Object[]> result = new ArrayList<>();
		try (Statement statement = conn.createStatement(); ResultSet rs = statement.executeQuery(sql)) {
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
		return result;
	}

	public int add(String sqlTemplate, Object[] parameters) {
		try (PreparedStatement statement = conn.prepareStatement(sqlTemplate)) {

			for (int i = 0; i < parameters.length; i++) {
				statement.setObject(i + 1, parameters[i]);
			}
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sqlTemplate);
			return 0;
		}
	}

	public List<Object[]> query(String sqlTemplate, Object[] parameters) {
		List<Object[]> result = new ArrayList<>();
		try (PreparedStatement statement = conn.prepareStatement(sqlTemplate)) {

			for (int i = 0; i < parameters.length; i++) {
				statement.setObject(i + 1, parameters[i]);
			}
			ResultSet rs = statement.executeQuery();
			int colCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				Object[] row = new Object[colCount];
				for (int i = 0; i < colCount; i++) {
					row[i] = rs.getObject(i + 1);
				}

				result.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sqlTemplate);
		}
		return result;
	}

	public int delete(String sqlTemplate, Object[] parameters) {

		try (PreparedStatement statement = conn.prepareStatement(sqlTemplate)) {

			for (int i = 0; i < parameters.length; i++) {
				statement.setObject(i + 1, parameters[i]);
			}
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sqlTemplate);
			return 0;
		}
	}
}
