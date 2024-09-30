package com.petplace.inquiry.model.dao;

import com.petplace.common.PageInfo;
import com.petplace.inquiry.model.dto.InquiryList;
import com.petplace.inquiry.model.vo.Inquiry;
import com.petplace.review.model.dao.ReviewDao;
import com.petplace.review.model.dto.ReviewList;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.petplace.common.JDBCTemplate.close;

/**
 * packageName    : com.petplace.inquiry.model.dao
 * fileName       : InquiryDao
 * author         : jun
 * date           : 2024. 9. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 29.        jun       최초 생성
 */
public class InquiryDao {
    private Properties prop = new Properties();

    public InquiryDao() {
        String filePath = ReviewDao.class.getResource("/db/sql/inquiry-mapper.xml").getPath();
        try {
            prop.loadFromXML(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int selectListCount(Connection conn) {
        int result = 0;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectListCount");
        try {
            pstmt = conn.prepareStatement(sql);
            rset = pstmt.executeQuery();
            if (rset.next()) {
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

    public ArrayList<InquiryList> selectInquiryList(Connection conn, PageInfo pi) {
        ArrayList<InquiryList> iList = new ArrayList<>();
        ResultSet rset = null;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("selectInquiryList");
        int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
        int endRow = startRow + pi.getBoardLimit() - 1;

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, startRow);
            pstmt.setInt(2, endRow);

            rset = pstmt.executeQuery();
            while (rset.next()) {
                iList.add(new InquiryList(
                        rset.getString("INQUIRY_NO"),
                        rset.getString("MEMBER_ID"),
                        rset.getString("PRODUCT_NO"),
                        rset.getString("PRODUCT_NAME"),
                        rset.getString("INQUIRY_TITLE"),
                        rset.getString("INQUIRY_DETAIL"),
                        rset.getString("INQUIRY_DATE"),
                        rset.getString("answer")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }
        return iList;
    }

    public Inquiry selectInquiry(Connection conn, String inquiryNo) {
        Inquiry inquiry = null;
        ResultSet rset = null;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("selectInquiry");
        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, inquiryNo);

            rset = pstmt.executeQuery();
            if (rset.next()) {
                inquiry = new Inquiry(rset.getString("INQUIRY_TITLE"), rset.getString("INQUIRY_DETAIL"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }
        System.out.println(inquiryNo);
        System.out.println(inquiry);
        return inquiry;
    }

    public int insertInquiry(Connection conn, String inquiryNo, String answer) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertInquiry");
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,answer);
            pstmt.setString(2,inquiryNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        System.out.println(inquiryNo);
        System.out.println(answer);
        System.out.println(result);
        return result;
    }
}
