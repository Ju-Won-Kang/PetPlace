package com.petplace.community.model.vo;

public class BoardComment {
	private int commentNo;
	private int communityNo;
	private int boardNo;
	private String memberId;
	private String commentDetail;
	private String commentDate;
	private String nickname;
	
	public BoardComment() {
		super();
	}

	public BoardComment(int commentNo, int communityNo, int boardNo, String memberId, String commentDetail,
			String commentDate, String nickname) {
		super();
		this.commentNo = commentNo;
		this.communityNo = communityNo;
		this.boardNo = boardNo;
		this.memberId = memberId;
		this.commentDetail = commentDetail;
		this.commentDate = commentDate;
		this.nickname = nickname;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCommentDetail() {
		return commentDetail;
	}

	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "BoardComment [commentNo=" + commentNo + ", communityNo=" + communityNo + ", boardNo=" + boardNo
				+ ", memberId=" + memberId + ", commentDetail=" + commentDetail + ", commentDate=" + commentDate
				+ ", nickname=" + nickname + "]";
	}
	
	
}
