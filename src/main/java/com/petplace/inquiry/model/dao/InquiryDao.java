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

    /**
     * 페이징 처리를 통한 상품 문의 게시글 리스트 조회 메서드
     *
     * @param sqlSession sqlSession 객체
     * @param pi         페이징 처리를 위한 PageInfo 객체
     * @return 상품 문의 정보를 담은 리스트 객체
     */
    public ArrayList<InquiryList> selectInquiryList(SqlSession sqlSession, PageInfo pi) {
        int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
        int limit = pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, limit);
        return (ArrayList) sqlSession.selectList("inquiryMapper.selectInquiryList", null, rowBounds);
    }

    /**
     * AJAX 요청을 처리를 위한 특정 상품 문의 상세 정보 조회 메서드
     *
     * @param sqlSession sqlSession 객체
     * @param inquiryNo  상품 문의 번호
     * @return 상품 문의 정보를 담은 객체
     */
    public Inquiry selectInquiry(SqlSession sqlSession, int inquiryNo) {
        return sqlSession.selectOne("inquiryMapper.selectInquiry", inquiryNo);
    }

    /**
     * 상품 문의 답변을 위한 메서드
     *
     * @param sqlSession sqlSession 객체
     * @param map        상품 문의 번호와 답변으로 구성된 Map 객체
     * @return 결과값
     */
    public int insertInquiry(SqlSession sqlSession, HashMap<String, Object> map) {
        return sqlSession.update("inquiryMapper.insertInquiry", map);
    }

    /**
     * 상품 문의를 생성하는 메서드
     *
     * @param sqlSession sqlSession 객체
     * @param inquiry    상품 문의 내용을 담은 객체
     * @return 결과값
     */
    public int createInquiry(SqlSession sqlSession, Inquiry inquiry) {
        return sqlSession.insert("inquiryMapper.createInquiry", inquiry);
    }
}
