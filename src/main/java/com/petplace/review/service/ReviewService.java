package com.petplace.review.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.review.model.dao.ReviewDao;
import com.petplace.review.model.dto.ReviewList;

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
        SqlSession sqlSession = Template.getSqlSession();
        int result = new ReviewDao().selectListCount(sqlSession);
        sqlSession.close();
        return result;
    }

    /**
     * 리뷰 리스트 페이지만큼 요청
     * @param pi
     * @return
     */
    public ArrayList<ReviewList> selectReviewList(PageInfo pi) {
        SqlSession sqlSession = Template.getSqlSession();

        ArrayList<ReviewList> rList = new ReviewDao().selectReviewList(sqlSession, pi);
        sqlSession.close();
        return rList;
    }

    /**
     * 리뷰 삭제
     * @param reviewNo
     * @return
     */
    public int deleteReview(int reviewNo){
        SqlSession sqlSession = Template.getSqlSession();
        int result = new ReviewDao().deleteReview(sqlSession, reviewNo);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}
