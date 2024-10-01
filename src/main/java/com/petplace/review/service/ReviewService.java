package com.petplace.review.service;

import com.petplace.common.PageInfo;
import com.petplace.review.model.dao.ReviewDao;
import com.petplace.review.model.dto.ReviewList;

import static com.petplace.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * packageName    : com.petplace.review.service
 * fileName       : ReviewService
 * author         : jun
 * date           : 2024. 9. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 29.        jun       최초 생성
 */
public class ReviewService {
    /**
     * listCount 요청 메서드
     *
     * @return
     */
    public int selectListCount() {
        Connection conn = getConnection();
        int result = new ReviewDao().selectListCount(conn);
        close(conn);
        return result;
    }

    /**
     * 리뷰 리스트 페이지만큼 요청
     * @param pi
     * @return
     */
    public ArrayList<ReviewList> selectReviewList(PageInfo pi) {
        Connection conn = getConnection();
        ArrayList<ReviewList> rList = new ReviewDao().selectReviewList(conn, pi);

        close(conn);
        return rList;
    }

    /**
     * 리뷰 삭제
     * @param reviewNo
     * @return
     */
    public int deleteReview(int reviewNo){
        Connection conn = getConnection();
        int result = new ReviewDao().deleteReview(conn, reviewNo);
        close(conn);
        return result;
    }
}
