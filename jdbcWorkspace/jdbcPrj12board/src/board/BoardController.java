package board;

import static util.KhUtil.sc;

import java.util.List;

public class BoardController {

	// menu
	public void menu(){
		System.out.println("----- MENU -----");
	
		System.out.println("1. 게시글 작성");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 목록조회");
		System.out.println("5. 게시글 상세조회");
		
		System.out.print("원하는 메뉴 번호 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : insertBoard(); break;
		case "2" : updateBoard(); break;
		case "3" : deleteBoardByNo(); break;
		case "4" : selectBoardList(); break;
		case "5" : selectBoardByNo(); break;
		}
	}
	
	// 작성하기
	public void insertBoard(){
		try {
			System.out.println("===== insertBoard =====");
			
			// data
			System.out.print("title : ");
			String title = sc.nextLine();
			System.out.print("content : ");
			String content = sc.nextLine();
			
			BoardVo vo = new BoardVo(null, title, content, null);
			
			BoardService bs = new BoardService();
			int result = bs.insertBoard(vo);
			
			// 결과처리
			if(result == 1) {
				System.out.println("작성하기 성공 !");
			}else {
				throw new Exception("result 값이 1이 아님...");
			}
			
		}catch(Exception e) {
			System.out.println("작성하기 실패 ...");
			e.printStackTrace();
		}
		
	}
	
	// 수정하기(제목, 내용 모두)
	public void updateBoard() {
		try {
			System.out.println("===== updateBoard =====");
			
			// data
			System.out.print("title : ");
			String title = sc.nextLine();
			System.out.print("content : ");
			String content = sc.nextLine();
			System.out.print("no : ");
			String no = sc.nextLine();
			
			BoardVo vo = new BoardVo(no, title, content, null);
			
			BoardService bs = new BoardService();
			int result = bs.updateBoard(vo);
			
			//결과처리
			if(result == 1) {
				System.out.println("수정하기 성공 !");
			}else {
				throw new Exception("result 값이 1이 아님...");
			}
			
		}catch(Exception e){
			System.out.println("수정하기 실패 ...");
			e.printStackTrace();
		}
		
	}
	
	// 삭제하기 (번호 이용해서)
	public void deleteBoardByNo() {
		try {
			System.out.println("===== deleteBoard =====");
			
			// data
			System.out.print("삭제할 게시글 no : ");
			String no = sc.nextLine();
			
			// service
			BoardService bs = new BoardService();
			int result = bs.deleteBoardByNo(no);
			
			//결과처리
			if(result == 1) {
				System.out.println("삭제하기 성공 !");
			}else {
				throw new Exception("result 값이 1이 아님...");
			}
			
		}catch(Exception e) {
			System.out.println("삭제하기 실패 ...");
			e.printStackTrace();
		}
	}
	
	// 조회하기 (상세)
	public void selectBoardByNo() {
		try {

			System.out.println("===== selectBoardByNo =====");
			
			// data
			System.out.println("조회할 게시글 번호 : ");
			String no = sc.nextLine();
			
			BoardService service = new BoardService();
			BoardVo vo = service.selectBoardByNo(no);
			
			// result
			System.out.println("번호 : " + vo.getNo());
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("작성일시 : " + vo.getEnrollDate());
			System.out.println("내용 : " + vo.getContent());
			
		}catch(Exception e) {
			System.out.println("게시글 상세조회 중 에러발생...");
			e.printStackTrace();
		}
		
	}
	
	// 조회하기 (목록)
	public void selectBoardList() {
		try {
			
			System.out.println("===== selectBoardList =====");
			
			BoardService service = new BoardService();
			List<BoardVo> voList = service.selectBoardList();
			
			// result
			System.out.println("번호 || 제목");
			for(BoardVo vo : voList) {
				System.out.println(vo);
			}
			
		}catch(Exception e) {
			System.out.println("게시글 목록 조회 중 에러 발생 ...");
			e.printStackTrace();
		}
		
	}//method
	
}// class
