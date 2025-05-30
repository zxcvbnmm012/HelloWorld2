
package com.haemin.common;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql {
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String id = "project1";
	static String pass = "project1";
	static Connection conn;
	static Statement stmt;
	static PreparedStatement psmt;
	static ResultSet rs;
	
	// connection 반환하는 메소드
	public static void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
			
		} catch (Exception e) {
			System.out.println(" !! getConnect() 메소드 오류.");
			e.printStackTrace();
			
			
		}
	} // end of getConnect()
	
	
	
	public static void disconnect() {
		try {
			if (conn != null) conn.close();  // conn를 사용했으면(conn != null) -> close해라
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		} catch(SQLException e){
			System.out.println("!! disconnect() 메소드 오류.");
			e.printStackTrace();
		}
	}
}
