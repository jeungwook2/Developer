package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardController {

	private Scanner sc;
	private int seq;
	private List voList;
	
	public BoardController() {
		sc = new Scanner(System.in);
		seq = 1;
		voList = new ArrayList();
	}
	
	// 메뉴
	public void menu() {
		System.out.println("----- menu -----");
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 목록 조회");
		System.out.println("3. 게시글 상세 조회");
		System.out.println("4. 게시글 삭제");
		System.out.println("9. 종료하기");
		System.out.print("번호 입력 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : insertBoard(); break;
		case "2" : selectBoardList(); break;
		case "3" : selectBoardOneByNo(); break;
		case "4" : deleteBoardByNo(); break;
		case "9" : System.out.println("exit !!!"); return;
		default : System.out.println("잘못된 번호입니다.");
		}
	}

	// 게시글 작성
	public void insertBoard() {
		System.out.println("----- Board Insert -----");
		
		// data input
		System.out.println("Title : ");
		String title = sc.nextLine();

		System.out.println("Content : ");
		String content = sc.nextLine();
		
		System.out.println("Writer : ");
		String writer = sc.nextLine();
		
		// data -> object
		String no = seq + "";
		BoardVo vo = new BoardVo(no, title, content, writer);
		
		// save
		voList.add(vo);
		seq++;
	}
	
	// 게시글 목록 조회
	public void selectBoardList() {
		System.out.println("----- Board List -----");
		for(int i=0; i<voList.size(); ++i) {
			System.out.println(voList.get(i));
		}
		
	}

	// 게시글 상세 조회 (번호)
	public void selectBoardOneByNo() {
		
	}
	
	// 게시글 삭제 (번호)
	public void deleteBoardByNo() {
		
	}
	
}//class
