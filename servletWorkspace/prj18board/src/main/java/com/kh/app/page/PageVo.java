package com.kh.app.page;

public class PageVo {

	private int listCount; 				// 게시글 총개수
	private int currentPage;			//현재 페이지(사용자가 요청한페이지)
	private int pageLimit;				//하단에 보여줄 페이지 영역 페이지 개수
	private int boardLimit;				//한페이지에 보여줄 게시글 최대갯수
	
	private int maxPage;				//마지막 페이지
	private int startPage;				//페이징 영역 시작값
	private int endPage;				//페이지 영역 마지막 값
	private int offset;					//select 쿼리에서 몇개를 건너뛸지
	public PageVo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		this.maxPage = (int)Math.ceil((double)listCount / boardLimit);
//		     10페이지                                 100        10
		this.startPage = (currentPage -1) / pageLimit*pageLimit+1 ;
//          14페이지              2-1 = 1 /       5 *5+1   26
		this.endPage = startPage + pageLimit -1;
		if(this.endPage > this.maxPage) {
			endPage = maxPage;
		}
//                       14       +    5 - 1 = 4  18page
 		this.offset = boardLimit *(currentPage -1);
// 		  40              10 *4      5-1 =4;
	}
	public int getListCount() {
		return listCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageLimit() {
		return pageLimit;
	}
	public int getBoardLimit() {
		return boardLimit;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getOffset() {
		return offset;
	}
	
	
	
}
