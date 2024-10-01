package com.petplace.review.model.dao;

import static com.petplace.common.JDBCTemplate.*;

import com.petplace.common.PageInfo;
import com.petplace.review.model.dto.ReviewList;

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
    private Properties prop = new Properties();

    public ReviewDao() {
        String filePath = ReviewDao.class.getResource("/db/sql/review-mapper.xml").getPath();
        try {
            prop.loadFromXML(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 리뷰 listCount 조회
     * @param conn
     * @return
     */
    public int selectListCount(Connection conn) {
        int result = 0;
        PreparedStatement pstmt= null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectListCount");
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            if(rset.next()){
                result = rset.getInt("count");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }
        return result;
    }

    /**
     * 리뷰 list 조회
     * @param conn
     * @param pi
     * @return
     */
    public ArrayList<ReviewList> selectReviewList(Connection conn, PageInfo pi) {
        ArrayList<ReviewList> rList = new ArrayList<>();
        ResultSet rset = null;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("selectReviewList");
        int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
        int endRow = startRow + pi.getBoardLimit() - 1;

        System.out.println(startRow);
        System.out.println(endRow);
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,startRow);
            pstmt.setInt(2,endRow);

            rset = pstmt.executeQuery();
            while (rset.next()){
                rList.add(new ReviewList(
                    rset.getInt("REVIEW_NO"),
                    rset.getString("MEMBER_ID"),
                    rset.getString("PRODUCT_NAME"),
                    rset.getInt("STAR"),
                    rset.getString("REVIEW_DETAIL"),
                    rset.getString("REVIEW_DATE")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }
        return rList;
    }

    /**
     * 리뷰 삭제
     * @param conn
     * @param reviewNo 삭제하고자하는 리뷰 번호
     * @return
     */
    public int deleteReview(Connection conn, int reviewNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteReview");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,reviewNo);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }
}
