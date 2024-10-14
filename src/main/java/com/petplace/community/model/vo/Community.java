package com.petplace.community.model.vo;

public class Community {
	private int communityNo;
	private String memberId;
	private String communityCategory;
	private String communityTitle;
	private String communityDetail;
	private String communityDate;
	private int communityView;
	private int communityGood;
	private int communityBad;
	private String nickname;
	
	public Community() {
		super();
	}

	public Community(int communityNo, String memberId, String communityCategory, String communityTitle,
			String communityDetail, String communityDate, int communityView, int communityGood, int communityBad,
			String nickname) {
		super();
		this.communityNo = communityNo;
		this.memberId = memberId;
		this.communityCategory = communityCategory;
		this.communityTitle = communityTitle;
		this.communityDetail = communityDetail;
		this.communityDate = communityDate;
		this.communityView = communityView;
		this.communityGood = communityGood;
		this.communityBad = communityBad;
		this.nickname = nickname;
	}

	public int getCommunityNo() {
		return communityNo;
	}

	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCommunityCategory() {
		return communityCategory;
	}

	public void setCommunityCategory(String communityCategory) {
		this.communityCategory = communityCategory;
	}

	public String getCommunityTitle() {
		return communityTitle;
	}

	public void setCommunityTitle(String communityTitle) {
		this.communityTitle = communityTitle;
	}

	public String getCommunityDetail() {
		return communityDetail;
	}

	public void setCommunityDetail(String communityDetail) {
		this.communityDetail = communityDetail;
	}

	public String getCommunityDate() {
		return communityDate;
	}

	public void setCommunityDate(String communityDate) {
		this.communityDate = communityDate;
	}

	public int getCommunityView() {
		return communityView;
	}

	public void setCommunityView(int communityView) {
		this.communityView = communityView;
	}

	public int getCommunityGood() {
		return communityGood;
	}

	public void setCommunityGood(int communityGood) {
		this.communityGood = communityGood;
	}

	public int getCommunityBad() {
		return communityBad;
	}

	public void setCommunityBad(int communityBad) {
		this.communityBad = communityBad;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Community [communityNo=" + communityNo + ", memberId=" + memberId + ", communityCategory="
				+ communityCategory + ", communityTitle=" + communityTitle + ", communityDetail=" + communityDetail
				+ ", communityDate=" + communityDate + ", communityView=" + communityView + ", communityGood="
				+ communityGood + ", communityBad=" + communityBad + ", nickname=" + nickname + "]";
	}
	
}
