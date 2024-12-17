package board;

import java.util.Scanner;

public class BoardController {

	private Scanner sc;
	private int no;
	private int idx;
	private BoardVo[] voArr;
	
	public BoardController() {
		sc = new Scanner(System.in);
		no = 1;
		idx = 0;
		voArr = new BoardVo[100];
	}
	
	// 메뉴출력
	public boolean menu() {
		System.out.println("----- Menu -----");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 목록 조회");
		System.out.println("3. 게시글 상세 조회");
		System.out.println("4. 게시글 삭제");
		System.out.println("9. 프로그램 종료");
		System.out.print("번호 입력 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : insertBoard(); break;
		case "2" : selectBoardList(); break;
		case "3" : selectBoardListOne(); break;
		case "4" : deleteBoard(); break;
		case "9" : System.out.println("exit ..."); return false;
		default : System.out.println("잘못된 입력입니다.");
		}
		return true;
	}
	
	
	// 게시글 작성
	public void insertBoard() {
		System.out.print("Title : ");
		String title = sc.nextLine();

		System.out.print("Content : ");
		String content = sc.nextLine();
		
		System.out.print("Writer : ");
		String writer = sc.nextLine();
		
		BoardVo vo = new BoardVo(no+"", title, content, writer);
		
		voArr[idx] = vo;
		idx++;
		no++;
	}
	
	// 게시글 목록 조회
	public void selectBoardList() {
		System.out.println("----- Board List -----");
		for(int i=0; i<idx; i++) {
			System.out.println(voArr[i]);
		}
	}
	
	// 게시글 상세 조회
	public void selectBoardListOne() {
		System.out.println("----- 상세 조회 -----");
		System.out.print("번호 입력 : ");
		String num = sc.nextLine();
		
		for(int i=0; i<idx; i++) {
			if(voArr[i].getNo().equals(num)) {
				System.out.println(voArr[i]);
				break;
			}
		}
	}
	
	// 게시글 삭제
	public void deleteBoard() {
		System.out.println("----- 게시글 삭졔 -----");
		System.out.print("번호 입력 : ");
		String num = sc.nextLine();
		
		for(int i=0; i<idx; i++) {
			if(voArr[i].getNo().equals(num)) {
				voArr[i] = null;
				System.out.println("삭제 완료!");
				break;
			}
		}
	}
}
