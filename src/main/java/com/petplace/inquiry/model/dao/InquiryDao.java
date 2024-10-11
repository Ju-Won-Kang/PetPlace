package com.petplace.inquiry.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.inquiry.model.dto.InquiryList;
import com.petplace.inquiry.model.vo.Inquiry;
import com.petplace.review.model.dao.ReviewDao;

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

    public int selectListCount(SqlSession sqlSession) {
        return sqlSession.selectOne("inquiryMapper.selectListCount");
    }

    public ArrayList<InquiryList> selectInquiryList(SqlSession sqlSession, PageInfo pi) {
        int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
        int limit = pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, limit);
        return (ArrayList) sqlSession.selectList("inquiryMapper.selectInquiryList", null, rowBounds);
    }

    public Inquiry selectInquiry(SqlSession sqlSession, int inquiryNo) {
        return sqlSession.selectOne("inquiryMapper.selectInquiry", inquiryNo);
    }

    public int insertInquiry(SqlSession sqlSession, HashMap<String,Object> map) {
        return sqlSession.update("inquiryMapper.insertInquiry", map);
    }
    public int createInquiry(SqlSession sqlSession, Inquiry inquiry){
        return sqlSession.insert("inquiryMapper.createInquiry", inquiry);
    }
}
