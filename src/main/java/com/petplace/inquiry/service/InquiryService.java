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
    /**
     * 상품 문의 총 개수
     *
     * @return 상품 문의 개수 값
     */
    public int selectListCount() {
        SqlSession sqlSession = Template.getSqlSession();
        int result = new InquiryDao().selectListCount(sqlSession);
        sqlSession.close();
        return result;
    }

    /**
     * 페이징 처리를 통한 상품 문의 게시글 리스트 조회 메서드
     *
     * @param pi 페이징 처리를 위한 PageInfo 객체
     * @return 상품 문의 게시글 리스트 조회 결과 객체
     */
    public ArrayList<InquiryList> selectInquiryList(PageInfo pi) {
        SqlSession sqlSession = Template.getSqlSession();
        ArrayList<InquiryList> iList = new InquiryDao().selectInquiryList(sqlSession, pi);

        sqlSession.close();
        return iList;
    }

    /**
     * AJAX 요청을 처리를 위한 특정 상품 문의 상세 정보 조회 메서드
     *
     * @param inquiryNo 상품 문의 번호
     * @return 조회된 상품 문의 상세 정보 객체
     */
    public Inquiry selectInquiry(int inquiryNo) {
        SqlSession sqlSession = Template.getSqlSession();
        Inquiry inquiry = new InquiryDao().selectInquiry(sqlSession, inquiryNo);

        sqlSession.close();
        return inquiry;
    }

    /**
     * 상품 문의 답변을 위한 메서드
     *
     * @param inquiryNo 상품 문의 번호
     * @param answer    답변
     * @return 결과값
     */
    public int insertInquiry(int inquiryNo, String answer) {
        SqlSession sqlSession = Template.getSqlSession();
        HashMap<String, Object> map = new HashMap<>();
        map.put("inquiryNo", inquiryNo);
        map.put("answer", answer);
        int result = new InquiryDao().insertInquiry(sqlSession, map);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    /**
     * 상품 문의를 생성하는 메서드
     *
     * @param inquiry 상품 문의 내용을 담은 객체
     * @return 결과값
     */
    public int createInquiry(Inquiry inquiry) {
        SqlSession sqlSession = Template.getSqlSession();
        int result = new InquiryDao().createInquiry(sqlSession, inquiry);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }
}
