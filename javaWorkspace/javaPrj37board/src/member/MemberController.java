package member;

import java.util.ArrayList;
import java.util.List;

import exception.MemberIdException;
import exception.MemberPwdException;

import static main.Main.sc;

import main.Main;

public class MemberController {

	private int seq;
	private List<MemberVo> voList;
	
	public MemberController() {
		seq = 1;
		voList = new ArrayList<MemberVo>();
	}
	
	// menu
	public void menu() {
		System.out.println("1. JOIN");
		System.out.println("2. LOGIN");
		System.out.print("번호 입력 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		}
	}
	
	private void checkId(String id) throws MemberIdException {
		if(id.length() < 4) {
			throw new MemberIdException("아이디 짧음");
		}
	}
	
	private void checkPwd(String pwd) throws MemberPwdException {
		if(pwd.length() < 4) {
			throw new MemberPwdException("비번 짧음");
		}
	}
	
	// join
	public void join() {
		System.out.println("----- JOIN -----");
		
		//data input
		System.out.print("ID : ");
		String id = Main.sc.nextLine();

		System.out.print("PWD : ");
		String pwd = Main.sc.nextLine();
		
		System.out.print("NICK : ");
		String nick = Main.sc.nextLine();
		
		String no = seq + "";
		
		//validate
		try {
			checkId(id);
			checkPwd(pwd);
		}catch(Exception e){
			String msg = e.getMessage();
			System.out.println(msg);
			return;
		}
		
//		try {
//			checkId(id);
//		}catch(Exception e){
//			String msg = e.getMessage();
//			System.out.println(msg);
//			return;
//		}
//		
//		try {
//			checkPwd(pwd);
//		}catch(Exception e){
//			String msg = e.getMessage();
//			System.out.println(msg);
//			return;
//		}
		
		//data -> obj
		MemberVo vo = new MemberVo(no, id, pwd, nick);
		
		//save
		voList.add(vo);
		seq++;
		System.out.println("회원가입 성공 !");
	}
	
	// login
	public void login() {
		System.out.println("----- LOGIN -----");
		
		System.out.print("ID : ");
		String id = Main.sc.nextLine();

		System.out.print("PWD : ");
		String pwd = Main.sc.nextLine();
		
		for(MemberVo vo : voList) {
			if(vo.getId().equals(id) && vo.getPwd().equals(pwd)) {
				Main.loginMemberVo = vo;
				System.out.println("로그인 성공 !");
				return;
			}
		}
		System.out.println("로그인 실패 ...");
	}
	
}//class