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
	private String findDate;
	private String boardType;
	private String adoptImg;
	private String adoptCategory;
	
	public Adopt() {
		super();
	}

	public Adopt(String boardNo, String memberId, String boardTitle, String boardDetail, Date boardDate, int boardViews,
			String place, String findDate, String boardType, String adoptImg, String adoptCategory) {
		super();
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.boardTitle = boardTitle;
		this.boardDetail = boardDetail;
		this.boardDate = boardDate;
		this.boardViews = boardViews;
		this.place = place;
		this.findDate = findDate;
		this.boardType = boardType;
		this.adoptImg = adoptImg;
		this.adoptCategory = adoptCategory;
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

	public String getFindDate() {
		return findDate;
	}

	public void setFindDate(String findDate) {
		this.findDate = findDate;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getAdoptImg() {
		return adoptImg;
	}

	public void setAdoptImg(String adoptImg) {
		this.adoptImg = adoptImg;
	}

	public String getAdoptCategory() {
		return adoptCategory;
	}

	public void setAdoptCategory(String adoptCategory) {
		this.adoptCategory = adoptCategory;
	}

	@Override
	public String toString() {
		return "Adopt [boardNo=" + boardNo + ", memberId=" + memberId + ", boardTitle=" + boardTitle + ", boardDetail="
				+ boardDetail + ", boardDate=" + boardDate + ", boardViews=" + boardViews + ", place=" + place
				+ ", findDate=" + findDate + ", boardType=" + boardType + ", adoptImg=" + adoptImg + ", adoptCategory="
				+ adoptCategory + "]";
	}

	
}