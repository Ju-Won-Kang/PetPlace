package com.petplace.inquiry.model.vo;

/**
 * packageName    : com.petplace.inquiry.model.vo
 * fileName       : Inquiry
 * author         : jun
 * date           : 2024. 9. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 29.        jun       최초 생성
 */
public class Inquiry {
    private int inquiryNo;
    private String memberId;
    private String productNo;
    private String inquiryTitle;
    private String inquiryDetail;
    private String inquiryDate;
    private String answer;

    public Inquiry() {
    }

    public Inquiry(int inquiryNo, String memberId, String productNo, String inquiryTitle, String inquiryDetail, String inquiryDate, String answer) {
        this.inquiryNo = inquiryNo;
        this.memberId = memberId;
        this.productNo = productNo;
        this.inquiryTitle = inquiryTitle;
        this.inquiryDetail = inquiryDetail;
        this.inquiryDate = inquiryDate;
        this.answer = answer;
    }

    public Inquiry(String inquiryTitle, String inquiryDetail) {
        this.inquiryTitle = inquiryTitle;
        this.inquiryDetail = inquiryDetail;
    }

    public int getInquiryNo() {
        return inquiryNo;
    }

    public String getInquiryTitle() {
        return inquiryTitle;
    }

    public void setInquiryTitle(String inquiryTitle) {
        this.inquiryTitle = inquiryTitle;
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

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
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

    @Override
    public String toString() {
        return "Inquiry{" +
                "inquiryNo='" + inquiryNo + '\'' +
                ", memberId='" + memberId + '\'' +
                ", productNo='" + productNo + '\'' +
                ", inquiryTitle='" + inquiryTitle + '\'' +
                ", inquiryDetail='" + inquiryDetail + '\'' +
                ", inquiryDate='" + inquiryDate + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
