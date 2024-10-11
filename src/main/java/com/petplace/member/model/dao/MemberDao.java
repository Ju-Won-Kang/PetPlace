package com.petplace.member.model.dao;

import static com.petplace.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.petplace.member.model.dto.HashedMember;
import com.petplace.member.model.vo.Member;
import org.apache.ibatis.session.SqlSession;

public class MemberDao {

    /**
     * 로그인 처리 메서드
     *
     * @param sqlSession sqlSession 객체
     * @param userId     사용자가 입력한 아이디
     * @return 조회된 Member 객체
     */
    public Member loginMember(SqlSession sqlSession, String userId) {
        return sqlSession.selectOne("memberMapper.selectHashedMember", userId);
    }

    /**
     * 회원가입 처리 메서드
     *
     * @param sqlSession   sqlSession 객체
     * @param enrollMember DB에 저장한 Member 객체
     * @return 결과값
     */
    public int enrollMember(SqlSession sqlSession, Member enrollMember) {
        return sqlSession.insert("memberMapper.enrollMember", enrollMember);
    }

    /**
     * 아이디 중복체크 메서드
     *
     * @param sqlSession sqlSession 객체
     * @param checkId    중복확인 대상 아이디
     * @return 중복된 아이디를 가진 멤버 개수
     */
    public int checkId(SqlSession sqlSession, String checkId) {
        System.out.println(checkId);
        return sqlSession.selectOne("memberMapper.checkId", checkId);
    }

}
