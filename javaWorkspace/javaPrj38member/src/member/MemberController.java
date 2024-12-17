package member;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberController {

	private Scanner sc;
	private List<MemberVo> voList;
	private int seq;
	
	public MemberController() {
		sc = new Scanner(System.in);
		voList = new ArrayList<MemberVo>();
		seq = 1;
	}
	
	// 메뉴
	public boolean menu() {
		System.out.println("----- Menu -----");
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 목록조회");
		System.out.println("3. 회원 상세조회");
		System.out.println("4. 회원 정보수정");
		System.out.println("5. 회원 삭제");
		System.out.println("9. 프로그램 종료");
		System.out.print("번호를 입력하세요 : ");
		String num = sc.nextLine();
		
		switch(num){
		case "1" : join(); break;
		case "2" : selectUserList(); break;
		case "3" : selectUserListOne(); break;
		case "4" : selectUserEdit(); break;
		case "5" : selectUserDelete(); break;
		case "9" : System.out.println("exit..."); return false;
		default : System.out.println("잘못된 번호입니다.");
		}
		return true;
	}
	
	// 회원가입
	public void join() {
		System.out.println("----- 회원 가입 -----");
		System.out.print("ID : ");
		String id = sc.nextLine();

		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		
		System.out.print("NICK : ");
		String nick = sc.nextLine();
		
		MemberVo vo = new MemberVo(seq+"", id, pwd, nick);
		
		voList.add(vo);
		seq++;
	}
	
	// 회원 목록조회
	public void selectUserList() {
		System.out.println("----- User List -----");
		for(MemberVo vo : voList) {
			System.out.println(vo);
		}
	}
	
	// 회원 상세조회
	public void selectUserListOne() {
		System.out.println("----- User Detail -----");
		System.out.print("조회할 회원 번호 : ");
		String num = sc.nextLine();
		
		for(MemberVo vo : voList) {
			if(vo.getNo().equals(num)) {
				System.out.println(vo);
				break;
			}
		}
	}
	
	// 회원 정보수정
	public void selectUserEdit() {
		System.out.println("----- Edit User Info -----");
		System.out.print("수정할 회원 번호 : ");
		String num = sc.nextLine();
		
		System.out.print("수정할 비밀번호 : ");
		String newPwd = sc.nextLine();
		
		System.out.println("수정할 닉네임 : ");
		String newNick = sc.nextLine();
		
		for(MemberVo vo : voList) {
			if(vo.getNo().equals(num)) {
				vo.setPwd(newPwd);
				vo.setNick(newNick);
				System.out.println("수정 완료!");
				break;
			}
		}
	}
	
	// 회원 삭제
	public void selectUserDelete() {
		System.out.println("----- User Delete -----");
		System.out.print("삭제할 회원 번호 : ");
		String num = sc.nextLine();
		
		for(MemberVo vo : voList) {
			if(vo.getNo().equals(num)) {
				voList.remove(vo);
				System.out.println("삭제 완료!");
				break;
			}
		}
	}
}
