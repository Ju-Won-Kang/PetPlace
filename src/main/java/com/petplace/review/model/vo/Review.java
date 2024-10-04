package com.petplace.review.model.vo;

/**
 * packageName    : com.petplace.review.model.vo
 * fileName       : Review
 * author         : jun
 * date           : 2024. 9. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 29.        jun       최초 생성
 */
public class Review {
    private int reviewNo;
    private String memberId;
    private int productNo;
    private int star;
    private String reviewDetail;
    private String reviewDate;

    public Review() {
    }

    public Review(int reviewNo, String memberId, int productNo, int star, String reviewDetail, String reviewDate) {
        this.reviewNo = reviewNo;
        this.memberId = memberId;
        this.productNo = productNo;
        this.star = star;
        this.reviewDetail = reviewDetail;
        this.reviewDate = reviewDate;
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getProductNo() {
        return productNo;
    }

    public void setProductNo(int productNo) {
        this.productNo = productNo;
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
        return "Review{" +
                "reviewNo='" + reviewNo + '\'' +
                ", memberId='" + memberId + '\'' +
                ", productNo='" + productNo + '\'' +
                ", star=" + star +
                ", reviewDetail='" + reviewDetail + '\'' +
                ", reviewDate='" + reviewDate + '\'' +
                '}';
    }
}
