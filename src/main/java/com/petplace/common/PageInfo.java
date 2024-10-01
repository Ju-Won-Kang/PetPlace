package com.petplace.common;

public class PageInfo {
	int listCount; //현재 총 게시글 수
	int currentPage; //현재 페이지(사용자가 요청한 페이지)
	int pageLimit = 10; //페이지 하단에 보여질 페이징바의 수
	int boardLimit = 10; //한 페이지 내에 보여질 게시글 최대 갯수
	//위 4개의 값을 기준으로 아래 3개의 값을 구할 수 있다
	
	int maxPage; //가장 마지막 페이지(총 페이지의 수)
	int startPage; //페이징바의 시작 수
	int endPage; //페이징바의 마지막 수
	
	public PageInfo() {
		super();
	}

	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", boardLimit=" + boardLimit + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit){
		int maxPage = (int) Math.ceil((double) listCount / boardLimit);
		int startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1;
		int endPage = startPage + pageLimit - 1;
		endPage = (endPage > maxPage) ? maxPage : endPage;
		return new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);

	}
}
