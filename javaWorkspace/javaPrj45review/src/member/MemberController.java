package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberController {

	private int seq;
	private Scanner sc;
	private List<MemberVo> voList;
	
	public MemberController() {
		sc = new Scanner(System.in);
		seq = 1;
		voList = new ArrayList<MemberVo>();
	}
	
	// 회원가입
	public void join() {
		System.out.println("----- join -----");
		
		//data
		String no = seq + "";
		seq++;
		System.out.print("id : ");
		String id = sc.nextLine();
		System.out.print("pwd : ");
		String pwd = sc.nextLine();
		System.out.print("nick : ");
		String nick = sc.nextLine();
		
		
		
		//data -> obj
		MemberVo vo = new MemberVo(no, id, pwd, nick);
		
		//save
		voList.add(vo);
		
	}
	
	// 로그인
	public void login() {
		
	}
	
}
