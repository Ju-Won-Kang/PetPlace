package com.petplace.mypage.service;

import org.apache.ibatis.session.SqlSession;

import com.petplace.common.Template;
import com.petplace.mypage.model.dao.MypageDao;
import com.petplace.mypage.model.dto.Petinfo;

public class MypageServiceImpl implements MypageService {

    @Override
    public Petinfo selectPetinfo(String userId) {
        SqlSession sqlSession = Template.getSqlSession(); // 데이터베이스 연결 세션 생성
        MypageDao mypageDao = new MypageDao(); // DAO 인스턴스 생성
        Petinfo petInfo = null;

        try {
            // userId에 해당하는 펫 정보 가져오기
            petInfo = mypageDao.selectPetinfo(sqlSession, userId);
        } finally {
            sqlSession.close(); // SQL 세션 닫기
        }

        return petInfo; // 결과 반환
    }
}
