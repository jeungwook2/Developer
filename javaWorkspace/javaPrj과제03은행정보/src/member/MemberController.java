package member;

import java.util.ArrayList;
import java.util.List;

import main.Main;

public class MemberController {

	private int seq;
	private List<MemberVo> voList;
	
	public MemberController() {
		seq = 1;
		voList = new ArrayList<MemberVo>();
	}

	//menu
	public void menu() {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 아이디 찾기");
		System.out.println("4. 패스워드 찾기");
		System.out.println("5. 패스워드 변경");
		System.out.print("번호 입력 : ");
		String num = Main.sc.nextLine();
		
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		case "3" : findId(); break;
		case "4" : findPwd(); break;
		case "5" : changePwd(); break;
		default: System.out.println("잘못 누르셨습니다.");
		}
	}
	
	//join
	public void join() {
		System.out.println("----- 회원가입 -----");
		
		System.out.print("ID : ");
		String id = Main.sc.nextLine();

		System.out.print("PWD : ");
		String pwd = Main.sc.nextLine();
		
		System.out.print("이름 : ");
		String name = Main.sc.nextLine();

		System.out.print("생년월일 : ");
		String birth = Main.sc.nextLine();
		
		System.out.print("주민번호 뒷자리 : ");
		String registNum = Main.sc.nextLine();
		
		String num = seq + "";

		MemberVo vo = new MemberVo(num, id, pwd, name, birth, registNum);
		
		voList.add(vo);
		seq++;
		System.out.println("회원가입 성공!\n");
	}
	
	//login
	public void login() {
		System.out.println("---- 로그인 -----");
		
		System.out.print("ID : ");
		String id = Main.sc.nextLine();
		
		System.out.print("PWD : ");
		String pwd = Main.sc.nextLine();
		
		for(MemberVo vo : voList) {
			if( vo.getId().equals(id) && vo.getPwd().equals(pwd) ) {
				Main.loginMemberVo = vo;
				System.out.println("로그인 성공 !\n");
				return;
			}
		}
		System.out.println("로그인 실패 ...\n");
	}
	
	//findId
	public void findId() {
		System.out.println("----- 아이디 찾기 -----");
		
		System.out.print("이름 : ");
		String name = Main.sc.nextLine();

		System.out.print("생년월일 : ");
		String birth = Main.sc.nextLine();
		
		for(MemberVo vo : voList) {
			if( vo.getName().equals(name) && vo.getBirth().equals(birth) ) {
				System.out.println(vo.getName() + "님의 ID는 " +  vo.getId() + "입니다.\n");
				return;
			}
		}
	}
	
	//findPwd
	public void findPwd() {
		System.out.println("-----  패스워드 찾기 -----");
		
		System.out.print("ID : ");
		String id = Main.sc.nextLine();

		System.out.print("주민번호 뒷자리 : ");
		String registNum = Main.sc.nextLine();
		
		for(MemberVo vo : voList) {
			if( vo.getId().equals(id) && vo.getRegistNum().equals(registNum) ) {
				System.out.println(vo.getId() + "님의 PWD는 " +  vo.getPwd() + "입니다.\n");
				return;
			}
		}
	}
	
	//changePwd
	public void changePwd() {
		System.out.println("----- 패스워드 변경 -----");
		
		if(Main.loginMemberVo == null) {
			System.out.println("로그인 후 사용할 수 있는 기능입니다.\n");
			return;
		}
		
		
		System.out.print("ID : ");
		String idNow = Main.sc.nextLine();

		System.out.print("현재 PWD : ");
		String pwdNow = Main.sc.nextLine();

		System.out.print("바꿀 PWD : ");
		String pwdAfter = Main.sc.nextLine();

		System.out.print("바꿀 PWD 한 번 더 입력 : ");
		String pwdAfterOneMore = Main.sc.nextLine();
		
	    // 새로운 비밀번호 확인
	    if (!pwdAfter.equals(pwdAfterOneMore)) {
	        System.out.println("비밀번호가 일치하지 않습니다.\n");
	        return;
	    }
	    else if(pwdAfter.equals(pwdAfterOneMore)) {
			for(MemberVo vo : voList) {
				if( vo.getPwd().equals(pwdNow) && vo.getId().equals(idNow) ) {
					voList.indexOf(vo); // id는 보통 중복이 불가능해서 id인덱스로 찾음
					vo = voList.get(voList.indexOf(vo)); // vo 객체에 기존 데이터 잠시 저장
					vo.setPwd(pwdAfter); // 비밀번호 변경
//					voList.add(voList.indexOf(vo), vo); // 리스트에 바뀐 데이터 저장
					Main.loginMemberVo = null;
					System.out.println("비밀번호를 변경했습니다.");
					System.out.println("로그아웃됩니다.\n");
					return;
				}
			}
		}
		
	    // 조건에 맞는 회원을 찾지 못한 경우
	    System.out.println("ID 또는 비밀번호가 일치하지 않습니다.\n");
		
	}
}//class