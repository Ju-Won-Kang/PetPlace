package com.petplace.review.model.dao;

import static com.petplace.common.JDBCTemplate.*;

import com.petplace.common.PageInfo;
import com.petplace.review.model.dto.ReviewList;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * packageName    : com.petplace.review.model.dao
 * fileName       : ReviewDao
 * author         : jun
 * date           : 2024. 9. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 29.        jun       최초 생성
 */
public class ReviewDao {

    /**
     * 리뷰 listCount 조회
     *
     * @param sqlSession sqlSession 객체
     * @return 총 리뷰 개수
     */
    public int selectListCount(SqlSession sqlSession) {
        return sqlSession.selectOne("reviewMapper.selectListCount");
    }

    /**
     * 리뷰 list 조회
     *
     * @param sqlSession sqlSession 객체
     * @param pi PageInfo 객체
     * @return 리뷰 목록 리스트 객체
     */
    public ArrayList<ReviewList> selectReviewList(SqlSession sqlSession, PageInfo pi) {
        int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
        int limit = pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, limit);
        return (ArrayList) sqlSession.selectList("reviewMapper.selectReviewList", null, rowBounds);
    }

    /**
     * 리뷰 삭제
     *
     * @param sqlSession sqlSession 객체
     * @param reviewNo   삭제할 리뷰 번호
     * @return 결과값
     */
    public int deleteReview(SqlSession sqlSession, int reviewNo) {
        return sqlSession.delete("reviewMapper.deleteReview", reviewNo);
    }
}
