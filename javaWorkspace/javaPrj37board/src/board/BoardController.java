package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.Main;

public class BoardController {
	
	private List<BoardVo> voList;
	private int seq;

	public BoardController() {
		Main.sc = new Scanner(System.in);
		voList = new ArrayList<BoardVo>();
		seq = 1;
	}
	
	//메뉴
	public void menu() {
		System.out.println("----- Menu -----");
		System.out.println("1: 게시글 작성");
		System.out.println("2: 게시글 목록조회");
		System.out.println("3: 게시글 상세조회");
		System.out.println("4: 게시글 수정");
		System.out.println("5: 게시글 삭제");
		System.out.print("번호 입력 : ");
		String num = Main.sc.nextLine();
		
		switch(num) {
		case "1" : insertBoard(); break;
		case "2" : selectBoardList(); break;
		case "3" : selectBoardByNo(); break;
		case "4" : editBoard(); break;
		case "5" : deleteBoardByNo(); break;
		default : System.out.println("잘못된 입력입니다.");
		}
	}
	
	//게시글 작성
	public void insertBoard() {
		if(Main.loginMemberVo == null){
			System.out.println("로그인 하고 오세요...");
			return;
		}
		System.out.println("----- 게시글 작성 -----");
		
		System.out.print("Title : ");
		String title = Main.sc.nextLine();
		
		System.out.print("Content : ");
		String content = Main.sc.nextLine();
		
		String writer = Main.loginMemberVo.getNick();
		
		BoardVo vo = new BoardVo(seq+"", title, content, writer);
		
		voList.add(vo);
		seq++;
	}
	
	//게시글 목록조회
	public void selectBoardList() {
		System.out.println("----- BOARD LIST -----");
		System.out.println("NO / TITLE / WRITER");
		for(BoardVo vo : voList) {
			System.out.print (vo.getNo());
			System.out.print (" / ");
			System.out.print (vo.getTitle());
			System.out.print (" / ");
			System.out.print (vo.getWriter());
			System.out.println();
		}
	}
	
	//게시글 상세조회
	public void selectBoardByNo() {
		System.out.println("조회할 게시글 번호 : ");
		String num = Main.sc.nextLine();
		
		for(BoardVo vo : voList) {
			if(vo.getNo().equals(num)) {
				System.out.println(vo);
				break;
			}
		}
	}
	
	//게시글 수정
	public void editBoard() {
		System.out.print("수정할 게시글 번호 : ");
		String num = Main.sc.nextLine();
		
		System.out.print("변경할 제목 : ");
		String newTitle = Main.sc.nextLine();
		System.out.print("변경할 내용 : ");
		String newContent = Main.sc.nextLine();
		
		for(BoardVo vo : voList) {
			if(vo.getNo().equals(num)) {
				vo.setTitle(newTitle);
				vo.setContent(newContent);
				System.out.println("수정 완료!");
				break;
			}
		}
	}
	
	//게시글 삭제
	public void deleteBoardByNo() {
		System.out.println("삭제할 게시글 번호 : ");
		String num = Main.sc.nextLine();
		
		for(BoardVo vo : voList) {
			if(vo.getNo().equals(num)) {
				voList.remove(vo);
				System.out.println("삭제 완료!");
				break;
			}
		}
	}
	
}//class
