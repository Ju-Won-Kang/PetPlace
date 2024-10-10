package com.petplace.member.model.vo;

import java.sql.Date;

public class Member {
	private String memberId;
	private String memberPwd;
	private String salt;
	private String memberName;
	private String nickName;
	private String phone;
	private String memberNo;
	private String address;
	private Date memberDate;
	private String staus;
	
	public Member() {
		super();
	}

	public Member(String memberId, String memberPwd, String memberName, String nickName, String phone, String memberNo,
				  String address, Date memberDate, String staus) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.nickName = nickName;
		this.phone = phone;
		this.memberNo = memberNo;
		this.address = address;
		this.memberDate = memberDate;
		this.staus = staus;
	}

	public Member(String memberId, String memberPwd, String salt, String memberName, String nickName, String phone, String memberNo, String address, Date memberDate, String staus) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.salt = salt;
		this.memberName = memberName;
		this.nickName = nickName;
		this.phone = phone;
		this.memberNo = memberNo;
		this.address = address;
		this.memberDate = memberDate;
		this.staus = staus;
	}

	public Member(String memberId, String memberPwd, String salt, String memberName, String nickName, String phone, String memberNo, String address) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.salt = salt;
		this.memberName = memberName;
		this.nickName = nickName;
		this.phone = phone;
		this.memberNo = memberNo;
		this.address = address;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getMemberDate() {
		return memberDate;
	}

	public void setMemberDate(Date memberDate) {
		this.memberDate = memberDate;
	}

	public String getStaus() {
		return staus;
	}

	public void setStaus(String staus) {
		this.staus = staus;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Member{" +
				"memberId='" + memberId + '\'' +
				", memberPwd='" + memberPwd + '\'' +
				", salt='" + salt + '\'' +
				", memberName='" + memberName + '\'' +
				", nickname='" + nickName + '\'' +
				", phone='" + phone + '\'' +
				", memberNo='" + memberNo + '\'' +
				", address='" + address + '\'' +
				", memberDate=" + memberDate +
				", staus='" + staus + '\'' +
				'}';
	}
}
