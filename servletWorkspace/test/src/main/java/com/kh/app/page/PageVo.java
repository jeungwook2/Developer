package com.kh.app.page;

public class PageVo {

	private int listCount; 				
	private int currentPage;			
	private int pageLimit;				
	private int boardLimit;			
	
	private int maxPage;			
	private int startPage;				
	private int endPage;				
	private int offset;					
	public PageVo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		this.maxPage = (int)Math.ceil((double)listCount / boardLimit);
		this.startPage = (currentPage -1) / pageLimit*pageLimit+1 ;
		this.endPage = startPage + pageLimit -1;
		if(this.endPage > this.maxPage) {
			endPage = maxPage;
		}
 		this.offset = boardLimit *(currentPage -1);
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
