
package com.haemin.common;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.haemin.ClassApp;
import com.haemin.User;
import com.haemin.person.Member;
import com.haemin.person.Teacher;




public class SqlDAO extends Sql {
	
// 회원가입
	public static int insert(Member member) {
		String sql = "insert into 회원정보(회원번호, 이름, 로그인아이디, 로그인비밀번호, 주민번호, 전화번호) "
				+ "values(?,?,?,?,?,?)";
		getConnect();
	
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setInt(1, member.getMemberId()); 
			psmt.setString(2, member.getMemberName()); 
			psmt.setString(3, member.getLoginId()); 
			psmt.setString(4, member.getLoginPw());
			psmt.setInt(5, member.getMemberBirth()); 
			psmt.setString(6, member.getMemberPhone());
			int r = psmt.executeUpdate();
			return r;
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		return 0;
	} // end of insert()
	
	
// 로그인
	public static boolean selectLogin(Member member){
		String sql = "select 로그인아이디 loginId, 로그인비밀번호 loginPw\r\n"
				+ "from 회원정보\r\n"
				+ "where 로그인아이디 = ? and 로그인비밀번호 = ?\r\n"
				+ "union\r\n"
				+ "select 로그인아이디, 로그인비밀번호\r\n"
				+ "from 강사정보\r\n"
				+ "where 로그인아이디 = ? and 로그인비밀번호 = ?\r\n"
				+ "union\r\n"
				+ "select 로그인아이디, 로그인비밀번호\r\n"
				+ "from 관리자정보\r\n"
				+ "where 로그인아이디 = ? and 로그인비밀번호 = ?";
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getLoginId()); 
			psmt.setString(2, member.getLoginPw());
			psmt.setString(3, member.getLoginId()); 
			psmt.setString(4, member.getLoginPw());
			psmt.setString(5, member.getLoginId()); 
			psmt.setString(6, member.getLoginPw());
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				return true;
				
			} 
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} 
		finally {
			disconnect();
		}
		return false;
	} // end of selectLogin()
	
	
// user 정보 확인
	public static User selectUser(Member member){
		String sql = "select 이름, 로그인아이디, 로그인비밀번호, 등급 \n"
				+ "from 회원정보\n"
				+ "where 로그인아이디 = ? and 로그인비밀번호 = ?\n"
				+ "union\n"
				+ "select 이름, 로그인아이디, 로그인비밀번호, 등급 \n"
				+ "from 강사정보\n"
				+ "where 로그인아이디 = ? and 로그인비밀번호 = ?\n"
				+ "union\n"
				+ "select 이름, 로그인아이디, 로그인비밀번호, 등급\n"
				+ "from 관리자정보\n"
				+ "where 로그인아이디 = ? and 로그인비밀번호 = ?";
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getLoginId()); 
			psmt.setString(2, member.getLoginPw());
			psmt.setString(3, member.getLoginId()); 
			psmt.setString(4, member.getLoginPw());
			psmt.setString(5, member.getLoginId()); 
			psmt.setString(6, member.getLoginPw());
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				User user = new User(rs.getString("이름"),rs.getString("등급"));
				return user;
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} 
		finally {
			disconnect();
		}
		return null;
	} // end of selectLogin()

	
// 강좌일정
	public static List<ClassApp> selectClass(String className) {
	    String sql = "select * from 강좌 where 과목 = ?";
	    getConnect();

	    List<ClassApp> list = new ArrayList<>();
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, className);
	        rs = psmt.executeQuery();

	        while (rs.next()) {
	            ClassApp cla = new ClassApp();
	            cla.setClassCenter(rs.getString("센터"));
	            cla.setClassName(rs.getString("과목"));
	            cla.setClassLevel(rs.getString("분반"));
	            cla.setClassDate(rs.getString("요일"));
	            cla.setClassTime(rs.getString("시간"));
	            cla.setClassFee(rs.getInt("금액"));
	            cla.setClassTeacher(rs.getString("강사"));
	            cla.setClassNow(rs.getInt("수강신청인원"));
	            cla.setClassLimit(rs.getInt("수강가능인원"));
	            list.add(cla);
	        }
	        return list;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return null;
	} // end of selectClass()


	
// 수강신청
	public static int appInsertSql(User user) {
		String sql = "UPDATE 회원정보 SET 수강강좌 = ?, 분반 = ? WHERE 이름 = ?";
		String sql2 = "UPDATE 강좌 SET 수강신청인원 = 수강신청인원+1 WHERE 과목 = ? AND 분반 = ?";

		getConnect();
		
		try {
			// 회원정보의 수강과목변경
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, user.getUserClassName()); 
			psmt.setString(2, user.getUserClassLevel()); 
			psmt.setString(3, user.getName()); 

			int r = psmt.executeUpdate();
			
			// 수강인원변경
			disconnect();
			getConnect();
			psmt = conn.prepareStatement(sql2); 
			psmt.setString(1, user.getUserClassName()); 
			psmt.setString(2, user.getUserClassLevel()); 
			r = psmt.executeUpdate();

			return r; 
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		return 0;
	} // end of appInsertSql()
	
	
	
	public static List<Member> t2Sql(String className) {
		
		System.out.println(className);
	    String sql = "SELECT DISTINCT m.회원번호, m.이름, m.전화번호, m.수강강좌, m.분반\r\n"
	    		+ "FROM   회원정보 m, 강좌 l\r\n"
	    		+ "WHERE  m.수강강좌 = l.과목\r\n"
	    		+ "AND    l.과목 = ?";
	    getConnect();

	    List<Member> list = new ArrayList<>();
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, className);
	        rs = psmt.executeQuery();

	        while (rs.next()) {
	            Member member = new Member();
	            member.setMemberId(rs.getInt("회원번호"));
	            member.setMemberName(rs.getString("이름"));
	            member.setMemberPhone(rs.getString("전화번호"));
	            member.setMemberClassName(rs.getString("수강강좌"));
	            member.setMemberClassLevel(rs.getString("분반"));
	            list.add(member);
	        }
	        return list;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return null;
	} // end of selectClass()
	
	
// teacher 정보	
	public static Teacher teacherInfo(Teacher teacher) {
		String sql = "SELECT * FROM 강사정보 WHERE 이름 = ?";

		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, teacher.getTeacherName()); 
			rs = psmt.executeQuery();

	        while (rs.next()) {
	            Teacher teacher2 = new Teacher();
	            teacher2.setTeacherName(rs.getString("이름"));
	            teacher2.setTeacherPermission(rs.getString("등급"));
	            teacher2.setTeacherLoginId(rs.getString("로그인아이디"));
	            teacher2.setTeacherLoginPw(rs.getString("로그인비밀번호"));
	            teacher2.setTeacherPhone(rs.getString("전화번호"));
	            teacher2.setTeacherClass(rs.getString("담당과목"));
	           
	            return teacher2; 
	        }

			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disconnect();
		}
		return null;
	} // end of teacherInfo()
	
	
	
public static List<ClassApp> t1Sql(String name) {
		
	    String sql = "select * from 강좌 where 강사 = ?";
	    getConnect();

	    List<ClassApp> list = new ArrayList<>();
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, name);
	        rs = psmt.executeQuery();

	        while (rs.next()) {
	        	ClassApp cla = new ClassApp();
	            cla.setClassCenter(rs.getString("센터"));
	            cla.setClassName(rs.getString("과목"));
	            cla.setClassLevel(rs.getString("분반"));
	            cla.setClassDate(rs.getString("요일"));
	            cla.setClassTime(rs.getString("시간"));
	            cla.setClassFee(rs.getInt("금액"));
	            cla.setClassTeacher(rs.getString("강사"));
	            cla.setClassNow(rs.getInt("수강신청인원"));
	            cla.setClassLimit(rs.getInt("수강가능인원"));
	            list.add(cla);
	        }
	        return list;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return null;
	} // end of t1Sql()
	
	
} // end of class
