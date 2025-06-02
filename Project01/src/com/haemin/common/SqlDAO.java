
package com.haemin.common;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.haemin.ClassApp;
import com.haemin.person.Member;
import com.haemin.person.Teacher;




public class SqlDAO extends Sql {
	
	public static List<Member> memberTable() {
		String sql = "SELECT * FROM 회원정보 order by 회원번호";
	    getConnect();

	    List<Member> list = new ArrayList<>();
	    try {
	        psmt = conn.prepareStatement(sql);
	        rs = psmt.executeQuery();

	        while (rs.next()) {
	            Member member = new Member();
	            member.setId(rs.getInt("회원번호"));
	            member.setName(rs.getString("이름"));
	            member.setLoginId(rs.getString("로그인아이디"));
	            member.setLoginPw(rs.getString("로그인비밀번호"));
	            member.setBirth(rs.getString("주민번호"));
	            member.setPhone(rs.getString("전화번호"));
	            member.setClassName(rs.getString("수강강좌"));
	            member.setClassLevel(rs.getString("분반"));
	            list.add(member);
	        }
	        return list;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return null;
	}
	
	public static List<Teacher> teacherTable() {
		String sql = "SELECT * FROM 강사정보";
	    getConnect();

	    List<Teacher> list = new ArrayList<>();
	    try {
	        psmt = conn.prepareStatement(sql);
	        rs = psmt.executeQuery();

	        while (rs.next()) {
	            Teacher teacher = new Teacher();
	            teacher.setTeacherName(rs.getString("이름"));
	            teacher.setTeacherLoginId(rs.getString("로그인아이디"));
	            teacher.setTeacherLoginPw(rs.getString("로그인비밀번호"));
	            teacher.setTeacherBirth(rs.getString("주민번호"));
	            teacher.setTeacherPhone(rs.getString("전화번호"));
	            teacher.setTeacherClass(rs.getString("담당과목"));
	            list.add(teacher);
	        }
	        return list;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return null;
	}
	
	public static List<ClassApp> classTable() {
		String sql = "SELECT * FROM 강좌";
		getConnect();
		
		List<ClassApp> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				ClassApp classApp = new ClassApp();
				classApp.setClassCenter(rs.getString("센터"));
				classApp.setClassName(rs.getString("과목"));
				classApp.setClassLevel(rs.getString("분반"));
				classApp.setClassDate(rs.getString("요일"));
				classApp.setClassTime(rs.getString("시간"));
				classApp.setClassFee(rs.getString("금액"));
				classApp.setClassTeacher(rs.getString("강사"));
				classApp.setClassNow(rs.getInt("수강신청인원"));
				classApp.setClassLimit(rs.getString("수강가능인원"));
				list.add(classApp);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null;
	}
	
	public static int selectMemberId() {
	    String sql = "SELECT MAX(회원번호) AS max_id FROM 회원정보";
	    getConnect();

	    try {
	        psmt = conn.prepareStatement(sql);
	        rs = psmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt("max_id");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return 0;
	}
	
// 회원가입
	public static int insert(Member member) {
		
		String sql = "insert into 회원정보(회원번호, 이름, 권한, 로그인아이디, 로그인비밀번호, 주민번호, 전화번호) "
				+ "values(?,?,?,?,?,?,?)";
		getConnect();
	
		try {
			psmt = conn.prepareStatement(sql); 
			psmt.setInt(1, member.getId()); 
			psmt.setString(2, member.getName()); 
			psmt.setString(3, "회원"); 
			psmt.setString(4, member.getLoginId()); 
			psmt.setString(5, member.getLoginPw());
			psmt.setString(6, member.getBirth()); 
			psmt.setString(7, member.getPhone());
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
	public static boolean selecUser(Member member){
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
	
	
	public static Member findPw(Member member) {
		String sql = "select 이름, 권한, 로그인아이디, 로그인비밀번호, 주민번호, 전화번호 \n"
				+ "from 회원정보\n"
				+ "where 이름 = ? and 로그인아이디 = ?\n"
				+ "union\n"
				+ "select 이름, 권한, 로그인아이디, 로그인비밀번호, 주민번호, 전화번호 \n"
				+ "from 강사정보\n"
				+ "where 이름 =? and 로그인아이디 = ?\n"
				+ "union\n"
				+ "select 이름, 권한, 로그인아이디, 로그인비밀번호, 주민번호, 전화번호\n"
				+ "from 관리자정보\n"
				+ "where 이름 =? and 로그인아이디 = ?";
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, member.getName()); 
			psmt.setString(2, member.getLoginId());
			psmt.setString(3, member.getName()); 
			psmt.setString(4, member.getLoginId());
			psmt.setString(5, member.getName()); 
			psmt.setString(6, member.getLoginId());
			
			rs = psmt.executeQuery();
			if (rs.next()) {
				Member user = new Member(rs.getString("이름"),rs.getString("권한"),rs.getString("로그인아이디"),rs.getString("로그인비밀번호"),rs.getString("주민번호"),rs.getString("전화번호"));
				return user;
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		} 
		finally {
			disconnect();
		}
		return null;
	}
	
	
// user 정보 확인
	public static Member selectUser(Member member){
		String sql = "select 이름, 권한, 로그인아이디, 로그인비밀번호, 주민번호, 전화번호 \n"
				+ "from 회원정보\n"
				+ "where 로그인아이디 = ? and 로그인비밀번호 = ?\n"
				+ "union\n"
				+ "select 이름, 권한, 로그인아이디, 로그인비밀번호, 주민번호, 전화번호 \n"
				+ "from 강사정보\n"
				+ "where 로그인아이디 = ? and 로그인비밀번호 = ?\n"
				+ "union\n"
				+ "select 이름, 권한, 로그인아이디, 로그인비밀번호, 주민번호, 전화번호\n"
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
				Member user = new Member(rs.getString("이름"),rs.getString("권한"),rs.getString("로그인아이디"),rs.getString("로그인비밀번호"),rs.getString("주민번호"),rs.getString("전화번호"));
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
	            cla.setClassFee(rs.getString("금액"));
	            cla.setClassTeacher(rs.getString("강사"));
	            cla.setClassNow(rs.getInt("수강신청인원"));
	            cla.setClassLimit(rs.getString("수강가능인원"));
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

	
	public static List<ClassApp> selectCenter(String className) {
	    String sql = "select distinct 과목 from 강좌 where 센터 = ?";
	    getConnect();

	    List<ClassApp> list = new ArrayList<>();
	    try {
	        psmt = conn.prepareStatement(sql);
	        psmt.setString(1, className);
	        rs = psmt.executeQuery();

	        while (rs.next()) {
	            ClassApp cla = new ClassApp();
	            cla.setClassName(rs.getString("과목"));
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
	
	public static List<ClassApp> Center() {
	    String sql = "select distinct 센터 from 강좌";
	    getConnect();

	    List<ClassApp> list = new ArrayList<>();
	    try {
	        psmt = conn.prepareStatement(sql);
	        rs = psmt.executeQuery();

	        while (rs.next()) {
	            ClassApp cla = new ClassApp();
	            cla.setClassCenter(rs.getString("센터"));
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
	public static int appInsertSql(Member member) {
		String sql = "UPDATE 회원정보 SET 수강강좌 = ?, 분반 = ? WHERE 이름 = ?";
		String sql2 = "UPDATE 강좌 SET 수강신청인원 = 수강신청인원+1 WHERE 과목 = ? AND 분반 = ?";

		getConnect();
		
		try {
			// 회원정보의 수강과목변경
			psmt = conn.prepareStatement(sql); 
			psmt.setString(1, member.getClassName()); 
			psmt.setString(2, member.getClassLevel()); 
			psmt.setString(3, member.getName()); 

			int r = psmt.executeUpdate();
			
			// 수강인원변경
			disconnect();
			getConnect();
			psmt = conn.prepareStatement(sql2); 
			psmt.setString(1, member.getClassName()); 
			psmt.setString(2, member.getClassLevel()); 
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
		
	    String sql = "SELECT DISTINCT m.회원번호, m.이름, m.주민번호, m.전화번호, m.수강강좌, m.분반\r\n"
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
	            member.setId(rs.getInt("회원번호"));
	            member.setName(rs.getString("이름"));
	            member.setBirth(rs.getString("주민번호"));
	            member.setPhone(rs.getString("전화번호"));
	            member.setClassName(rs.getString("수강강좌"));
	            member.setClassLevel(rs.getString("분반"));
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
	            teacher2.setTeacherPermission(rs.getString("권한"));
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
	            cla.setClassFee(rs.getString("금액"));
	            cla.setClassTeacher(rs.getString("강사"));
	            cla.setClassNow(rs.getInt("수강신청인원"));
	            cla.setClassLimit(rs.getString("수강가능인원"));
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

public static List<ClassApp> selectProg(String center) {
	String sql = "select * from 강좌 where 센터 = ?";
    getConnect();

    List<ClassApp> list = new ArrayList<>();
    try {
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, center);
        rs = psmt.executeQuery();

        while (rs.next()) {
        	ClassApp cla = new ClassApp();
            cla.setClassCenter(rs.getString("센터"));
            cla.setClassName(rs.getString("과목"));
            cla.setClassLevel(rs.getString("분반"));
            cla.setClassDate(rs.getString("요일"));
            cla.setClassTime(rs.getString("시간"));
            cla.setClassFee(rs.getString("금액"));
            cla.setClassTeacher(rs.getString("강사"));
            cla.setClassNow(rs.getInt("수강신청인원"));
            cla.setClassLimit(rs.getString("수강가능인원"));
            list.add(cla);
        }
        return list;

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        disconnect();
    }
    return null;
}


public static List<ClassApp> updateProg(String className, String classLevel, String col, String newData) {
    String sql = "UPDATE 강좌 SET " + col + " = ? WHERE 과목 = ? AND 분반 = ?";
    getConnect();

    try {
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, newData);
        psmt.setString(2, className);
        psmt.setString(3, classLevel);
        psmt.executeUpdate(); // UPDATE 실행

        // 업데이트 후 해당 강좌를 다시 조회
        String selectSql = "SELECT * FROM 강좌 WHERE 과목 = ? AND 분반 = ?";
        psmt = conn.prepareStatement(selectSql);
        psmt.setString(1, className);
        psmt.setString(2, classLevel);
        rs = psmt.executeQuery();

        List<ClassApp> list = new ArrayList<>();
        while (rs.next()) {
            ClassApp cla = new ClassApp();
            cla.setClassCenter(rs.getString("센터"));
            cla.setClassName(rs.getString("과목"));
            cla.setClassLevel(rs.getString("분반"));
            cla.setClassDate(rs.getString("요일"));
            cla.setClassTime(rs.getString("시간"));
            cla.setClassFee(rs.getString("금액"));
            cla.setClassTeacher(rs.getString("강사"));
            cla.setClassNow(rs.getInt("수강신청인원"));
            cla.setClassLimit(rs.getString("수강가능인원"));
            list.add(cla);
        }

        return list;

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        disconnect();
    }

    return null;
}


public static List<Member> updateMember(String name, String col, String newData) {
    String sql = "UPDATE 회원정보 SET " + col + " = ? WHERE 이름 = ?";
    getConnect();

    List<Member> list = new ArrayList<>();
    try {
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, newData);
        psmt.setString(2, name);
        psmt.executeUpdate(); 

        String selectSql = "SELECT * FROM 회원정보 WHERE 이름 = ?";
        psmt = conn.prepareStatement(selectSql);
        psmt.setString(1, name);
        rs = psmt.executeQuery();

        while (rs.next()) {
            Member member = new Member();
            member.setId(rs.getInt("회원번호"));
            member.setName(rs.getString("이름"));
            member.setLoginId(rs.getString("로그인아이디"));
            member.setLoginPw(rs.getString("로그인비밀번호"));
            member.setBirth(rs.getString("주민번호"));
            member.setPhone(rs.getString("전화번호"));
            member.setClassName(rs.getString("수강강좌"));
            member.setClassLevel(rs.getString("분반"));
            list.add(member);
        }

        return list;

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        disconnect();
    }
    return null;
}


public static List<Teacher> updateTeacher(String name, String col, String newData) {
    String sql = "UPDATE 강사정보 SET " + col + " = ? WHERE 이름 = ?";
    getConnect();

    List<Teacher> list = new ArrayList<>();
    try {
        psmt = conn.prepareStatement(sql);
        psmt.setString(1, newData);
        psmt.setString(2, name);
        psmt.executeUpdate();

        String selectSql = "SELECT * FROM 강사정보 WHERE 이름 = ?";
        psmt = conn.prepareStatement(selectSql);
        psmt.setString(1, name);
        rs = psmt.executeQuery();

        while (rs.next()) {
            Teacher teacher = new Teacher();
            teacher.setTeacherName(rs.getString("이름"));
            teacher.setTeacherLoginId(rs.getString("로그인아이디"));
            teacher.setTeacherLoginPw(rs.getString("로그인비밀번호"));
            teacher.setTeacherBirth(rs.getString("주민번호"));
            teacher.setTeacherPhone(rs.getString("전화번호"));
            teacher.setTeacherClass(rs.getString("담당과목"));
            list.add(teacher);
        }
        return list;

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        disconnect();
    }
    return null;
}

public static int insertTeacher(Teacher teacher) {
	
	String sql = "insert into 강사정보(이름, 권한, 로그인아이디, 로그인비밀번호, 주민번호, 전화번호) "
			+ "values(?,?,?,?,?,?)";
	getConnect();

	try {
		psmt = conn.prepareStatement(sql); 
		psmt.setString(1, teacher.getTeacherName()); 
		psmt.setString(2, "강사"); 
		psmt.setString(3, teacher.getTeacherLoginId()); 
		psmt.setString(4, teacher.getTeacherLoginPw());
		psmt.setString(5, teacher.getTeacherBirth()); 
		psmt.setString(6, teacher.getTeacherPhone());
		int r = psmt.executeUpdate();
		return r;
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		disconnect();
	}
	return 0;
} 

public static int deleteTeacher(String name) {
	
	String sql = "delete 강사정보 where 이름 = ? ";
	getConnect();

	try {
		psmt = conn.prepareStatement(sql); 
		psmt.setString(1, name); 
		int r = psmt.executeUpdate();
		return r;
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		disconnect();
	}
	return 0;
} 

public static int deleteMember(String name) {
	
	String sql = "delete 회원정보 where 이름 = ? ";
	getConnect();
	
	try {
		psmt = conn.prepareStatement(sql); 
		psmt.setString(1, name); 
		int r = psmt.executeUpdate();
		return r;
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		disconnect();
	}
	return 0;
} 
	

	
	
} // end of class
