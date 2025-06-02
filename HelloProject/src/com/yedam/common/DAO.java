package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 데이터베이스의 연결정보를 활용해서 세션획득
 */

public class DAO {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "scott";
	String pass = "tiger";
	Connection conn;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	
	// connection 반환하는 메소드
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	} // end of getConnect()
	
	
	
	public void disconnect() {
		try {
			if (conn != null) conn.close();  // conn를 사용했으면(conn != null) -> close해라
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		} catch(SQLException e){
			
		}
	}
}
