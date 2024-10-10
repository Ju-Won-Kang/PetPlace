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

	public Member loginMember(String userId) {
		SqlSession sqlSession = Template.getSqlSession();
		// DB에서 user 정보 가져오기
		Member m = new MemberDao().loginMember(sqlSession, userId);

		sqlSession.close();
		return m;
	}
	public int enrollMember(Member hashedMember){
		SqlSession sqlSession = Template.getSqlSession();
		// 해싱 처리

		System.out.println(hashedMember);
		int result = new MemberDao().enrollMember(sqlSession,hashedMember);
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;

	}
	public int checkId(String checkId){
		SqlSession sqlSession = Template.getSqlSession();
		int checkIdCount = new MemberDao().checkId(sqlSession, checkId);
		return checkIdCount;
	}
}
