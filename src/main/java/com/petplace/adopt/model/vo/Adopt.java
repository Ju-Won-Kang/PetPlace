package com.petplace.adopt.model.vo;

import java.sql.Date;

public class Adopt {
	private String boardNo;
	private String memberId;
	private String boardTitle;
	private String boardDetail;
	private Date boardDate;
	private int boardViews;
	private String place;
	private Date findDate;
	
	public Adopt() {
		super();
	}

	public Adopt(String boardNo, String memberId, String boardTitle, String boardDetail, Date boardDate, int boardViews,
			String place, Date findDate) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.boardTitle = boardTitle;
		this.boardDetail = boardDetail;
		this.boardDate = boardDate;
		this.boardViews = boardViews;
		this.place = place;
		this.findDate = findDate;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardDetail() {
		return boardDetail;
	}

	public void setBoardDetail(String boardDetail) {
		this.boardDetail = boardDetail;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardViews() {
		return boardViews;
	}

	public void setBoardViews(int boardViews) {
		this.boardViews = boardViews;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getFindDate() {
		return findDate;
	}

	public void setFindDate(Date findDate) {
		this.findDate = findDate;
	}

	@Override
	public String toString() {
		return "Adopt [boardNo=" + boardNo + ", memberId=" + memberId + ", boardTitle=" + boardTitle + ", boardDetail="
				+ boardDetail + ", boardDate=" + boardDate + ", boardViews=" + boardViews + ", place=" + place
				+ ", findDate=" + findDate + "]";
	}
	
	
}