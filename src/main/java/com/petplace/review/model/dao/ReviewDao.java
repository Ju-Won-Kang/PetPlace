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
     * @param conn
     * @return
     */
    public int selectListCount(SqlSession sqlSession) {
        return sqlSession.selectOne("reviewMapper.selectListCount");
    }

    /**
     * 리뷰 list 조회
     * @param conn
     * @param pi
     * @return
     */
    public ArrayList<ReviewList> selectReviewList(SqlSession sqlSession, PageInfo pi) {
        int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
        int limit = pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, limit);
        return (ArrayList)sqlSession.selectList("reviewMapper.selectReviewList", null, rowBounds);
    }

    /**
     * 리뷰 삭제
     * @param conn
     * @param reviewNo 삭제하고자하는 리뷰 번호
     * @return
     */
    public int deleteReview(SqlSession sqlSession, int reviewNo) {
        return sqlSession.delete("reviewMapper.deleteReview", reviewNo);
    }
}
