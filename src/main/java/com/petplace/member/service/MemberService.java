package com.petplace.member.service;

import static com.petplace.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;

import com.petplace.common.ShaUtil;
import com.petplace.common.Template;
import com.petplace.member.model.dao.MemberDao;
import com.petplace.member.model.dto.BeforeHashingMember;
import com.petplace.member.model.dto.HashedMember;
import com.petplace.member.model.vo.Member;
import org.apache.ibatis.session.SqlSession;

public class MemberService {
    /**
     * 로그인을 처리 메서드
     *
     * @param userId 사용자가 입력한 userId
     * @return Member 객체
     */
    public Member loginMember(String userId) {
        SqlSession sqlSession = Template.getSqlSession();
        // DB에서 user 정보 가져오기
        Member m = new MemberDao().loginMember(sqlSession, userId);
        sqlSession.close();
        return m;
    }

    /**
     * 회원가입 처리 메서드
     *
     * @param enrollMember 회원가입 정보 객체
     * @return 결과값
     */
    public int enrollMember(Member enrollMember) {
        SqlSession sqlSession = Template.getSqlSession();
        int result = new MemberDao().enrollMember(sqlSession, enrollMember);
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }

    /**
     * 아이디 중복체크 메서드
     *
     * @param checkId 중복확인 대상 아이디
     * @return 중복된 아이디를 가진 멤버 개수
     */
    public int checkId(String checkId) {
        SqlSession sqlSession = Template.getSqlSession();
        int checkIdCount = new MemberDao().checkId(sqlSession, checkId);
        return checkIdCount;
    }
}
