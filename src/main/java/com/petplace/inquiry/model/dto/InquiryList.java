package com.petplace.inquiry.model.dto;

/**
 * packageName    : com.petplace.inquiry.model.dto
 * fileName       : InquiryList
 * author         : jun
 * date           : 2024. 9. 29.
 * description    : 문의 리스트용 객체
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 29.        jun       최초 생성
 */
public class InquiryList {
    private int inquiryNo;
    private String memberId;
    private int productNo;
    private String productName;
    private String inquiryTitle;
    private String inquiryDetail;
    private String inquiryDate;
    private String answer;

    public InquiryList() {
    }


    public InquiryList(int inquiryNo, String memberId, int productNo, String productName, String inquiryTitle, String inquiryDetail, String inquiryDate, String answer) {
        this.inquiryNo = inquiryNo;
        this.memberId = memberId;
        this.productNo = productNo;
        this.productName = productName;
        this.inquiryTitle = inquiryTitle;
        this.inquiryDetail = inquiryDetail;
        this.inquiryDate = inquiryDate;
        this.answer = answer;
    }

    public int getInquiryNo() {
        return inquiryNo;
    }

    public void setInquiryNo(int inquiryNo) {
        this.inquiryNo = inquiryNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getInquiryTitle() {
        return inquiryTitle;
    }

    public void setInquiryTitle(String inquiryTitle) {
        this.inquiryTitle = inquiryTitle;
    }

    public String getInquiryDetail() {
        return inquiryDetail;
    }

    public void setInquiryDetail(String inquiryDetail) {
        this.inquiryDetail = inquiryDetail;
    }

    public String getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(String inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
    }

    @Override
    public String toString() {
        return "InquiryList{" +
                "inquiryNo='" + inquiryNo + '\'' +
                ", memberId='" + memberId + '\'' +
                ", productNo='" + productNo + '\'' +
                ", productName='" + productName + '\'' +
                ", inquiryTitle='" + inquiryTitle + '\'' +
                ", inquiryDetail='" + inquiryDetail + '\'' +
                ", inquiryDate='" + inquiryDate + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
