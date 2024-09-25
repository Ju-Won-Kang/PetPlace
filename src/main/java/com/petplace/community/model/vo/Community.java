package com.petplace.community.model.vo;

import java.sql.Date;

public class Community {
	private int cummunity_no;
	private String member_id;
	private String community_category;
	private String community_title;
	private String community_detail;
	private String community_date;
	private int community_views;
	private int community_good;
	private int community_bad;
	private String nickname;
	
	public Community() {
		super();
	}

	public Community(int cummunity_no, String member_id, String community_category, String community_title,
			String community_detail, String community_date, int community_views, int community_good, int community_bad,
			String nickname) {
		super();
		this.cummunity_no = cummunity_no;
		this.member_id = member_id;
		this.community_category = community_category;
		this.community_title = community_title;
		this.community_detail = community_detail;
		this.community_date = community_date;
		this.community_views = community_views;
		this.community_good = community_good;
		this.community_bad = community_bad;
		this.nickname = nickname;
	}

	public int getCummunity_no() {
		return cummunity_no;
	}

	public void setCummunity_no(int cummunity_no) {
		this.cummunity_no = cummunity_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getCommunity_category() {
		return community_category;
	}

	public void setCommunity_category(String community_category) {
		this.community_category = community_category;
	}

	public String getCommunity_title() {
		return community_title;
	}

	public void setCommunity_title(String community_title) {
		this.community_title = community_title;
	}

	public String getCommunity_detail() {
		return community_detail;
	}

	public void setCommunity_detail(String community_detail) {
		this.community_detail = community_detail;
	}

	public String getCommunity_date() {
		return community_date;
	}

	public void setCommunity_date(String community_date) {
		this.community_date = community_date;
	}

	public int getCommunity_views() {
		return community_views;
	}

	public void setCommunity_views(int community_views) {
		this.community_views = community_views;
	}

	public int getCommunity_good() {
		return community_good;
	}

	public void setCommunity_good(int community_good) {
		this.community_good = community_good;
	}

	public int getCommunity_bad() {
		return community_bad;
	}

	public void setCommunity_bad(int community_bad) {
		this.community_bad = community_bad;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Community [cummunity_no=" + cummunity_no + ", member_id=" + member_id + ", community_category="
				+ community_category + ", community_title=" + community_title + ", community_detail=" + community_detail
				+ ", community_date=" + community_date + ", community_views=" + community_views + ", community_good="
				+ community_good + ", community_bad=" + community_bad + ", nickname=" + nickname + "]";
	}
		
}
