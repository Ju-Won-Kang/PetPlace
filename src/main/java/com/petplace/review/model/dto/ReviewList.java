package com.petplace.review.model.dto;

/**
 * packageName    : com.petplace.review.model.dto
 * fileName       : ReviewList
 * author         : jun
 * date           : 2024. 9. 29.
 * description    : 리뷰 리스트를 가져올때 사용하는 객체
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 29.        jun       최초 생성
 */
public class ReviewList {
    private String reviewNo;
    private String memberId;
    private String productName;
    private int star;
    private String reviewDetail;
    private String reviewDate;

    public ReviewList() {
    }

    public ReviewList(String reviewNo, String memberId, String productName, int star, String reviewDetail, String reviewDate) {
        this.reviewNo = reviewNo;
        this.memberId = memberId;
        this.productName = productName;
        this.star = star;
        this.reviewDetail = reviewDetail;
        this.reviewDate = reviewDate;
    }

    public String getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(String reviewNo) {
        this.reviewNo = reviewNo;
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

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getReviewDetail() {
        return reviewDetail;
    }

    public void setReviewDetail(String reviewDetail) {
        this.reviewDetail = reviewDetail;
    }

    public String getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "ReviewList{" +
                "reviewNo='" + reviewNo + '\'' +
                ", memberId='" + memberId + '\'' +
                ", productName='" + productName + '\'' +
                ", star=" + star +
                ", reviewDetail='" + reviewDetail + '\'' +
                ", reviewDate='" + reviewDate + '\'' +
                '}';
    }
}
