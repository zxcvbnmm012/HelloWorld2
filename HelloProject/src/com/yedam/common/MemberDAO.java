package com.yedam.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.vo.Member;

/*
 * Database에 insert, update, delete, select
 */

public class MemberDAO extends DAO {
	public int insert(Member member) {
		String sql = "insert into tbl_member(member_id, member_name, phone, point)"
				+ "values(?,?,?,?)";  // 쿼리 안에 파라미터 ? 전달
		
		// 접속
		getConnect();
		try {
			// stmt = conn.createStatement();
			psmt = conn.prepareStatement(sql); // 쿼리를 매개값으로 전달
			psmt.setString(1, member.getMemberId()); // 첫번째 파라미터의 위치에 memberId 넣음
			psmt.setString(2, member.getMemberName()); // 두번째 파라미터의 위치에 memberName 넣음
			psmt.setString(3, member.getPhone()); // 두번째 파라미터의 위치에 memberName 넣음
			psmt.setInt(4, member.getPoint()); // 두번째 파라미터의 위치에 memberName 넣음
			int r = psmt.executeUpdate();
			return r; // 처리한 건수 반환
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		return 0; // 한 건도 반영 x
		
		
	} // end of insert()
	
	
	
	public int update(Member member) {
		String sql = "update tbl_member "
				+ "set phone = ?"
				+ "  , point = ?"
				+ "where member_id = ?";  // 쿼리 안에 파라미터 ? 전달
		
		// 접속
		getConnect();
		try {
			// stmt = conn.createStatement();
			psmt = conn.prepareStatement(sql); // 쿼리를 매개값으로 전달
			psmt.setString(1, member.getPhone()); 
			psmt.setInt(2, member.getPoint()); 
			psmt.setString(3, member.getMemberId());
			int r = psmt.executeUpdate();
			return r; // 처리한 건수 반환
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		return 0; // 한 건도 반영 x
	} // end of update()
	
	
	
	public int delete(String memberId) {
		String sql = "delete from tbl_member "
				+ "where member_id = ?";  // 쿼리 안에 파라미터 ? 전달
		
		// 접속
		getConnect();
		try {
			// stmt = conn.createStatement();
			psmt = conn.prepareStatement(sql); // 쿼리를 매개값으로 전달
			psmt.setString(1, memberId);
			int r = psmt.executeUpdate(); 
			return r; // 처리한 건수 반환
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		return 0; // 한 건도 반영 x
	} // end of delete()
	
	
	// 조회
	public List<Member> select(){
		String sql = "select * from tbl_member";
		getConnect();
		List<Member> list = new ArrayList<>(); // 컬렉션에 저장
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id")); // column 이름
				member.setMemberName(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setPoint(rs.getInt("point"));  // point 칼럼에 있는 값을 int 형태로 불러옴
			
				list.add(member); // 추가
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} return list;
	} // end of select()
	
} // end of class
