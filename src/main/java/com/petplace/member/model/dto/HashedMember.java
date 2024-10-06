package com.petplace.member.model.dto;

/**
 * packageName    : com.petplace.member.model.dto
 * fileName       : HashedMember
 * author         : jun
 * date           : 2024. 10. 4.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 4.        jun       최초 생성
 */
public class HashedMember {
    private String memberId;
    private String memberPwd;
    private String salt;
    private String memberName;
    private String memberNo;
    private String phone;
    private String nickName;
    private String address;

    public HashedMember() {
    }

    public HashedMember(String memberId, String memberPwd, String salt, String memberName, String memberNo, String phone, String nickname, String address) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.salt = salt;
        this.memberName = memberName;
        this.memberNo = memberNo;
        this.phone = phone;
        this.nickName = nickname;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "HashedMember{" +
                "memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", salt='" + salt + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberNo='" + memberNo + '\'' +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
