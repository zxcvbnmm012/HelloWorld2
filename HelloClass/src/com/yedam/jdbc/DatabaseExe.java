package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Driver Manager
 * 2. Connection
 * 3. Statement
 * 4. 실행
 * 5. ResultSet
 * 6. 출력
 */

// jdbc로 db 연결
public class DatabaseExe {
	public static void main(String[] args) {
		// url : 접속할 오라클 정보
		// id, pass : 접속할 오라클에서 사용할 사용자 id, pw

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pass = "tiger";
		
		// 세션 처리
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
			conn.setAutoCommit(false);  // 자동 commit을 false로 함 -> 따로 commit 작업을 해줘야 함; conn.commit;
			System.out.println("연결성공.");
		
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		// Statement 객체
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "insert into product(p_code, p_name, p_price) values(201, '치토스', 1000)";
		String sql2 = "update product set p_price = 4000 where p_code = 201";
		
		// update
		try {
			stmt = conn.createStatement();
			int u = stmt.executeUpdate(sql2);
			if (u > 0) {
				conn.commit(); // commit
				System.out.println(u + "건 수정됨.");
			}
			else {
				conn.rollback(); // rollback
			}
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		
		
		// insert
//		try {
//			int r = stmt.executeUpdate(sql); // r : 처리된 건 수
//			// executeUpdate() : insert, update, delete
//			if (r > 0) {
//				System.out.println(r + "건 등록됨.");
//			}
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
		
		
		
		
		
		try {
			rs = stmt.executeQuery("select * from product");  // 쿼리 실행 결과를 set 컬렉션에 담아줌
			// executeQuery() : select
			System.out.println("상품코드 상품이름    가격");
			System.out.println("-------------------");
			while(rs.next()) {  // 가져올 데이터가 있는지 확인
				System.out.println(rs.getInt("p_code") + " " //
						+ rs.getString("p_name") + " " //
						+ rs.getInt("p_price"));  // 칼럼이름
			}
			System.out.println("-----end of rows-----");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		try {
			if(rs != null) rs.close();  // rs를 사용했으면(rs != null) -> close해라
			if(stmt != null) stmt.close();
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	} // end of main
} // end of class
