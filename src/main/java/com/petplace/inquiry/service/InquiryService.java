package com.petplace.inquiry.service;

import com.petplace.common.JDBCTemplate;

import static com.petplace.common.JDBCTemplate.*;

import com.petplace.common.PageInfo;
import com.petplace.inquiry.model.dao.InquiryDao;
import com.petplace.inquiry.model.dto.InquiryList;
import com.petplace.inquiry.model.vo.Inquiry;
import com.petplace.review.model.dao.ReviewDao;
import com.petplace.review.model.dto.ReviewList;

import java.sql.Connection;
import java.util.ArrayList;

import static com.petplace.common.JDBCTemplate.close;
import static com.petplace.common.JDBCTemplate.getConnection;

/**
 * packageName    : com.petplace.inquiry.service
 * fileName       : InquiryService
 * author         : jun
 * date           : 2024. 9. 29.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 29.        jun       최초 생성
 */
public class InquiryService {
    public int selectListCount() {
        Connection conn = getConnection();
        int result = new InquiryDao().selectListCount(conn);
        close(conn);
        return result;
    }

    public ArrayList<InquiryList> selectInquiryList(PageInfo pi) {
        Connection conn = getConnection();
        ArrayList<InquiryList> iList = new InquiryDao().selectInquiryList(conn, pi);

        close(conn);
        return iList;
    }

    public Inquiry selectInquiry(int inquiryNo) {
        Connection conn = getConnection();
        Inquiry inquiry = new InquiryDao().selectInquiry(conn, inquiryNo);

        close(conn);
        return inquiry;
    }

    public int insertInquiry(int inquiryNo, String answer) {
        Connection conn = getConnection();
        int result = new InquiryDao().insertInquiry(conn, inquiryNo, answer);
        if (result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }

        close(conn);
        return result;
    }
}
