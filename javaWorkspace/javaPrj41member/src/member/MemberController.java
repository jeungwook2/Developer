package member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberController {

	private Scanner sc;
	private List<MemberVo> voList;
	
	public MemberController() {
		sc = new Scanner(System.in);
		voList = new ArrayList<MemberVo>();
	}
	
	//menu
	public void menu() throws Exception {
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.print("번호 입력 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : join(); break;
		case "2" : login(); break;
		}
	}
	
	//join
	public void join() throws Exception {
		System.out.println("----- JOIN -----");
		System.out.print("ID : ");
		String id = sc.nextLine();
		
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		
		MemberVo vo = new MemberVo(id, pwd);
		
		System.out.println("회원가입 성공!");

		//save
		
		//"D:\member.txt" 파일을 객체로 준비
		File f = new File("D:" + File.separator + "member.txt");
		
		//통로 준비
		FileWriter fw = new FileWriter(f, true);
		
		//문자열 내보내기
		fw.write(id +"/"+pwd+"\n");
		fw.close();
	}
	
	//login
	public void login() throws Exception {
		System.out.println("----- LOGIN -----");
		System.out.print("ID : ");
		String id = sc.nextLine();
		
		System.out.print("PWD : ");
		String pwd = sc.nextLine();
		
		//find from 메모장
		
		//파일 객체 준비
		File f = new File("D:" + File.separator + "member.txt");
		
		//통로 준비
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		while(true) {
			//데이터 읽어오기
			String str = br.readLine();
			if(str == null) {
				break;
			}
			
			//일치하는 데이터 찾기
			String memoId = str.substring(0,str.indexOf("/"));
			String memoPwd = str.substring(str.indexOf("/")+1);
			
			if(	id.equals(memoId) && pwd.equals(memoPwd)) {
				System.out.println("로그인 성공!");
				return;
			}
		}
		System.out.println("로그인 실패...");
	}
	
}
