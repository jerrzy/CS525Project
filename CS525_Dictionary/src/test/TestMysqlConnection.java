package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

class TestMysqlConnection {

	@Test
	void test() {
//		fail("Not yet implemented");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Connection conn = DriverManager.getConnection(
//                "jdbc:" + dbms + "://"
//                + serverName
//                + ":" + portNumber + "/" + dbName,
//                connectionProps);
	}

}
