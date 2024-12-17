package member;

import static util.KhUtil.sc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.JDBCTemplate;
import main.Main;

public class MemberController {
	
	//메뉴
	public void menu() throws Exception {
		System.out.println("----- MENU -----");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 비밀번호 수정");
		System.out.println("4. 닉네임 수정");
		System.out.println("5. 회원탈퇴");
		System.out.println("6. 회원 목록 조회 (관리자)");
		System.out.println("7. 회원 상세 조회 (관리자)");
		
		System.out.print("원하는 메뉴 번호 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		case "3" : updatePwd(); break;
		case "4" : updateNick(); break;
		case "5" : delete(); break;
		case "6" : findMemberAll(); break;
		case "7" : findMemberById(); break;
		default : System.out.println("잘못된 번호입니다.");
		}
	}
	
	//--회원가입
	public void join() throws Exception {
		System.out.println("----- JOIN -----");
		//data
		System.out.print("id : ");
		String id = sc.nextLine();
		System.out.print("pwd : ");
		String pwd = sc.nextLine();
		System.out.print("nick : ");
		String nick = sc.nextLine();
		
		//biz
		if(id.length() < 4) {
			throw new Exception("아이디 길이 짧음");
		}
		
		if(pwd.length() < 4) {
			throw new Exception("패스워드 길이 짧음");
		}
		
		if(nick.contains("관리자")) {
			throw new Exception("관리자 사칭 ㄴㄴ");
		}
		
		//db
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				INSERT INTO MEMBER
				(
				    NO
				    ,ID
				    ,PWD
				    ,NICK
				)
				VALUES
				(
				    SEQ_MEMBER.NEXTVAL
				    ,?
				    ,?
				    ,?
				)
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		pstmt.setString(3, nick);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("회원가입 성공 !");
		}else {
			System.out.println("회원가입 실패 ...");
		}
	}
	
	
	
	
	//--로그인
	public void login() throws Exception {
		System.out.println("----- LOGIN -----");
		
		//data
		System.out.print("id : ");
		String id = sc.nextLine();
		System.out.print("pwd : ");
		String pwd = sc.nextLine();
		
		//biz
		if(id.length() < 4) {
			throw new Exception("로그인 실패 (아이디를 올바르게 입력하세요-4글자 이상)");
		}
		if(pwd.length() < 4) {
			throw new Exception("로그인 실패 (비밀번호를 올바르게 입력하세요-4글자 이상)");
		}
		
		//db
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				SELECT *
				FROM MEMBER
				WHERE ID = ?
				AND PWD = ?
				AND DEL_YN = 'N'
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pwd);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String no = rs.getString("NO");
//			String id = rs.getString("ID");
//			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			MemberVo vo = new MemberVo(no, id, pwd, nick, enrollDate, modifyDate, delYn);
			System.out.println(vo.getNick() + " 님 환영합니다 ~ ^^");
			Main.loginMember = vo;
		}else {
			System.out.println("로그인 실패 ...");
		}
		
	}
	
	//--비밀번호 수정
	public void updatePwd() throws Exception {
		System.out.println("----- edit pwd -----");
	
		//data
		System.out.print("기존 비밀번호 : ");
		String oldPwd = sc.nextLine();
		System.out.print("신규 비밀번호 : ");
		String newPwd = sc.nextLine();
		String memberNo = Main.loginMember.getNo();
		
		//biz
		if(newPwd.length() < 4) {
			throw new Exception("비밀번호는 4글자 이상");
		}
		
		//db
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				UPDATE MEMBER
				SET
				    PWD = ?
				    , MODIFY_DATE = SYSDATE
				WHERE NO = ?
				AND PWD = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, newPwd);
		pstmt.setString(2, memberNo);
		pstmt.setString(3, oldPwd);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("비밀번호 변경 성공 !");
		}else {
			System.out.println("비밀번호 변경 실패 ...");
		}
		
	}
	
	//--닉네임 수정
	public void updateNick() throws Exception {
		System.out.println("----- edit nick -----");
		//data
		System.out.print("변경할 닉네임 : ");
		String nick = sc.nextLine();
		
		//biz
		if(nick.contains("관리자")) {
			throw new Exception("관리자 사칭 ㄴㄴ");
		}
		
		//db
		Connection conn = JDBCTemplate.getConnection();
		
		String sql = """
				UPDATE MEMBER
				SET
				    NICK = ?
				    , MODIFY_DATE = SYSDATE
				WHERE NO = ?
				""";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nick);
		pstmt.setString(2, Main.loginMember.getNo());
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("닉네임 변경 성공 !");
			Main.loginMember.setNick(nick);
		}else {
			System.out.println("닉네임 변경 실패 ...");
		}
	}
	
	//--회원탈퇴
	public void delete() throws Exception {
		System.out.println("----- quit -----");
		
		//data
		System.out.println("비밀번호를 입력하시면 탈퇴처리가 진행됩니다.");
		String pwd = sc.nextLine();
		
		//biz
		if(pwd.length() < 4) {
			throw new Exception("비밀번호 길이는 4글자 이상이어야 합니다.");
		}
		
		//db
		String sql = """
				UPDATE MEMBER
				SET
				    DEL_YN = 'Y'
				    , MODIFY_DATE = SYSDATE
				WHERE NO = ?
				AND PWD = ?
				""";
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, Main.loginMember.getNo());
		pstmt.setString(2, pwd);
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			System.out.println("회원 탈퇴 성공 !");
			Main.loginMember = null;
		}else {
			System.out.println("회원 탈퇴 실패 ...");
		}
	}
	
	//--회원 목록 조회 (관리자)
	public void findMemberAll() throws Exception {
		System.out.println(" ----- MEMBER LIST -----");
		//data
		//biz
		//db
		String sql = """
				SELECT *
				FROM MEMBER
				ORDER BY NO DESC
				""";
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		while( rs.next() ) {
			String no = rs.getString("NO");
			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			MemberVo vo = new MemberVo(no, id, pwd, nick, enrollDate, modifyDate, delYn);
			System.out.println(vo);
		}
	}
	
	//--회원 상세 조회 (관리자)
	public void findMemberById() throws Exception {
		System.out.println("----- MEMBER DETAIL -----");
		//data
		System.out.println("조회할 아이디 : ");
		String id = sc.nextLine();
		//biz
		if(id.length() < 4) {
			throw new Exception("아이디는 4글자 이상입니다.");
		}
		//db
		String sql = """
				SELECT *
				FROM MEMBER
				WHERE ID = ?
				""";
		Connection conn = JDBCTemplate.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			String no = rs.getString("NO");
//			String id = rs.getString("ID");
			String pwd = rs.getString("PWD");
			String nick = rs.getString("NICK");
			String enrollDate = rs.getString("ENROLL_DATE");
			String modifyDate = rs.getString("MODIFY_DATE");
			String delYn = rs.getString("DEL_YN");
			
			MemberVo vo = new MemberVo(no, id, pwd, nick, enrollDate, modifyDate, delYn);
			System.out.println(vo);
		}else {
			System.out.println("해당 아이디는 존재하지 않습니다.");
		}
	}

}//class