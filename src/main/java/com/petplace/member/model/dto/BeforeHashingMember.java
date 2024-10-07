package com.petplace.member.model.dto;

/**
 * packageName    : com.petplace.member.model.dto
 * fileName       : BeforeHashingMember
 * author         : jun
 * date           : 2024. 10. 4.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 10. 4.        jun       최초 생성
 */
public class BeforeHashingMember {
    private String memberId;
    private String memberPwd;
    private String memberName;
    private String SSN1;
    private String SSN2;
    private String phone;
    private String nickname;
    private String address;

    public BeforeHashingMember() {
    }

    public BeforeHashingMember(String memberId, String memberPwd, String memberName, String SSN1, String SSN2, String phone, String nickname, String address) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
        this.SSN1 = SSN1;
        this.SSN2 = SSN2;
        this.phone = phone;
        this.nickname = nickname;
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

    public String getSSN1() {
        return SSN1;
    }

    public void setSSN1(String SSN1) {
        this.SSN1 = SSN1;
    }

    public String getSSN2() {
        return SSN2;
    }

    public void setSSN2(String SSN2) {
        this.SSN2 = SSN2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BeforeHashingMember{" +
                "memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", memberName='" + memberName + '\'' +
                ", SSN1='" + SSN1 + '\'' +
                ", SSN2='" + SSN2 + '\'' +
                ", phone='" + phone + '\'' +
                ", nickname='" + nickname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
