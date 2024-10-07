package com.petplace.inquiry.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.inquiry.model.dao.InquiryDao;
import com.petplace.inquiry.model.dto.InquiryList;
import com.petplace.inquiry.model.vo.Inquiry;

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
        SqlSession sqlSession = Template.getSqlSession();
        int result = new InquiryDao().selectListCount(sqlSession);
        sqlSession.close();
        return result;
    }

    public ArrayList<InquiryList> selectInquiryList(PageInfo pi) {
        SqlSession sqlSession = Template.getSqlSession();
//        Connection conn = getConnection();
        ArrayList<InquiryList> iList = new InquiryDao().selectInquiryList(sqlSession, pi);

        sqlSession.close();
//        close(conn);
        return iList;
    }

    public Inquiry selectInquiry(int inquiryNo) {
        SqlSession sqlSession = Template.getSqlSession();
//        Connection conn = getConnection();
        Inquiry inquiry = new InquiryDao().selectInquiry(sqlSession, inquiryNo);

//        close(conn);
        sqlSession.close();
        return inquiry;
    }

    public int insertInquiry(int inquiryNo, String answer) {
//        Connection conn = getConnection();
        SqlSession sqlSession = Template.getSqlSession();
        HashMap<String, Object> map = new HashMap<>();
        map.put("inquiryNo", inquiryNo);
        map.put("answer", answer);
        int result = new InquiryDao().insertInquiry(sqlSession,map);
        if (result > 0) {
//            commit(conn);
            sqlSession.commit();
        } else {
//            rollback(conn);
            sqlSession.rollback();
        }

//        close(conn);
        sqlSession.close();
        return result;
    }
}
