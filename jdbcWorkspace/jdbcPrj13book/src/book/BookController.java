package book;

import static util.KhUtil.sc;

import java.util.List;

public class BookController {

	// 메뉴
	public void menu() {
		System.out.println("----- MENU -----");
		
		System.out.println("1. 작성하기");
		System.out.println("2. 가격변경");
		System.out.println("3. 대여하기");
		System.out.println("4. 반납하기");
		System.out.println("5. 삭제하기");
		System.out.println("6. 상세조회");
		System.out.println("7. 목록조회");
		System.out.println("8. 도서검색 (제목)");
		System.out.println("9. 도서검색 (장르)");
		System.out.println("10. 도서검색 (저자)");
		
		System.out.print("메뉴 번호 입력 : ");
		String num = sc.nextLine();
		
		switch(num) {
		case "1" : insertBook(); break;
		case "2" : editPrice(); break;
		case "3" : rentBook(); break;
		case "4" : returnBook(); break;
		case "5" : deleteBook(); break;
		case "6" : selectBookByNo(); break;
		case "7" : selectBookAll(); break;
		case "8" : selectBookByTitle(); break;
		case "9" : selectBookByGenre(); break;
		case "10" : selectBookByAuthor(); break;
		default :
		}
	}
	
	//  작성하기
	public void insertBook() {
		try {
			
			System.out.println("----- insertBook -----");
			
			//data
			System.out.print("title : ");
			String title = sc.nextLine();
			System.out.print("genre : ");
			String genre = sc.nextLine();
			System.out.print("author : ");
			String author = sc.nextLine();
			System.out.print("price : ");
			String price = sc.nextLine();
			
			BookVo vo = new BookVo();
			vo.setTitle(title);
			vo.setGenre(genre);
			vo.setAuthor(author);
			vo.setPrice(price);
			
			//service - DAO
			BookService service = new BookService();
			int result = service.insertBook(vo);
			
			//result
			if(result == 1) {
				System.out.println("도서 등록 성공 !");
			}else {
				System.out.println("도서 등록 실패 ...");
			}
			
		}catch(Exception e) {
			System.out.println("도서 등록 실패 ...");
			e.printStackTrace();
		}
	
	}
	
	//  수정하기 (가격변경)
	public void editPrice() {
		
		try {
			
			System.out.println("---- editPrice -----");
			
			//data
			System.out.print("no :");
			String no = sc.nextLine();
			System.out.print("price :");
			String price = sc.nextLine();
			
			BookVo vo = new BookVo();
			vo.setNo(no);
			vo.setPrice(price);
			
			//service - DAO
			BookService service = new BookService();
			int result = service.editPrice(vo);
			
			//result
			if(result == 1) {
				System.out.println("가격 변경 완료 !");
			}else {
				throw new Exception("result 0 이라고함 ,,,");
			}
			
		}catch(Exception e) {
			System.out.println("가격 변경 실패 ...");
			e.printStackTrace();
		}
		
		
		
		
	}
	
	//  대여하기 == 수정하기 (렌탈가능여부)
	public void rentBook() {}
	
	//  반납하기 == 수정하기 (렌탈가능여부)
	public void returnBook() {}
	
	//  삭제하기
	public void deleteBook() {

		try {
			
			System.out.println("----- deleteBook -----");
			
			//data
			System.out.println("삭제할 도서 번호 : ");
			String no = sc.nextLine();
			
			//service - DAO
			BookService service = new BookService();
			int result = service.deleteBook(no);
			
			//result
			if(result == 1) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
			
		}catch(Exception e) {
			System.out.println("삭제 실패");
			e.printStackTrace();
		}
		
	}

	//  상세조회
	public void selectBookByNo() {
		
		try {
			System.out.println("----- selectBookByNo -----");
			
			//data
			System.out.println("상세조회할 도서 번호");
			String no = sc.nextLine();
			
			//service
			BookService service = new BookService();
			BookVo vo = service.selectBookByNo(no);
			
			//result
			if(vo == null) {
				throw new Exception("해당 도서는 존재하지 않음");
			}
			System.out.println("제목 : " + vo.getTitle());
			System.out.println("지은이 : " + vo.getAuthor());
			System.out.println("장르 : " + vo.getGenre());
			System.out.println("가격 : " + vo.getPrice());
			System.out.println("대여가능여부 : " + vo.getRentalYn());
			System.out.println("출판일 : " + vo.getPublicationDate());
			
		}catch(Exception e) {
			System.out.println("상세조회 실패 ...");
			e.printStackTrace();
		}
		
		
	}
	
	//  목록조회 (최신순)
	public void selectBookAll() {
		
		try {
			System.out.println("----- selectBookAll -----");
			
			//data
			
			//service
			BookService service = new BookService();
			List<BookVo> voList = service.selectBookAll();
			
			//result
			System.out.println("번호 |  제 목  |  지은이  | 대여가능여부");
			for(BookVo vo : voList) {
				System.out.println("");
				System.out.print(vo.getNo());
				System.out.print(" | ");
				System.out.print(vo.getTitle());
				System.out.print(" | ");
				System.out.print(vo.getAuthor());
				System.out.print(" | ");
				System.out.print(vo.getRentalYn() + "\n");
			
			}
			
		}catch(Exception e) {
			System.out.println("목록조회 실패 ...");
			e.printStackTrace();
		}
		
	}
	
	//  도서 검색 (제목)
	public void selectBookByTitle() {}
	
	//  도서 검색 (장르)
	public void selectBookByGenre() {}
	
	//  도서 검색 (저자)
	public void selectBookByAuthor() {}
	
}
