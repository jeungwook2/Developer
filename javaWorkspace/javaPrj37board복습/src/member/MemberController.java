package member;

import java.util.ArrayList;
import java.util.List;
import main.Main;

public class MemberController {
	
	private List<MemberVo> voList;
	private int seq;
	
	public void MemberController() {
		voList = new ArrayList<MemberVo>();
		seq = 1;
	}
	
	//menu
	public void menu() {
		System.out.println("1. JOIN");
		System.out.println("2. LOGIN");
		System.out.print("번호입력 : ");
		String num = Main.sc.nextLine();
		
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		}
	}
	
	//join
	public void join() {
		System.out.println("----- JOIN -----");
		
		//data input
		System.out.print("id : ");
		String id = Main.sc.nextLine();
		
		System.out.print("pwd : ");
		String pwd = Main.sc.nextLine();

		System.out.print("nick : ");
		String nick = Main.sc.nextLine();
	
		String no = seq + "";
		
		//data -> obj
		MemberVo vo = new MemberVo(no, id, pwd, nick);
		
		//save
		voList.add(vo);
		seq++;
		System.out.println("회원가입 성공!");
	}
	
	//login
	public void login() {
		System.out.println("----- LOGIN -----");
		
		System.out.println("id : ");
		String id = Main.sc.nextLine();

		System.out.println("pwd : ");
		String pwd = Main.sc.nextLine();
		
		for(MemberVo vo : voList) {
			if(vo.getId().equals(id) && vo.getPwd().equals(pwd)) {
				Main.loginMemberVo = vo;
				System.out.println("로그인성공");
				return;
			}
		}
		System.out.println("로그인실패...");
	
	}//login

}//class
