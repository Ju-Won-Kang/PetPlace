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

	public HashedMember loginMember(String userId, String userPwd) {
		SqlSession sqlSession = Template.getSqlSession();
		// DB에서 user 정보 가져오기
		HashedMember m = new MemberDao().loginMember(sqlSession, userId);
		// 요청으로 들어온 비밀번호 해싱처리
		String hashedUserPwd = ShaUtil.sha256WithSaltEncode(userPwd, m.getSalt());
		sqlSession.close();

		// DB에서 가져온 user 정보와 요청으로 들어온 정보 비교
		if(userId.equals(m.getMemberId()) && hashedUserPwd.equals(m.getMemberPwd())){
			return m;
		}

		return null;
	}
	public int enrollMember(BeforeHashingMember beforeHashingMember){
		SqlSession sqlSession = Template.getSqlSession();
		// 해싱 처리
		String salt = ShaUtil.getSalt();
		String hashedMemberPwd = ShaUtil.sha256WithSaltEncode(beforeHashingMember.getMemberPwd(), salt);
		String SSN2 = beforeHashingMember.getSSN2();
		String gender = SSN2.substring(0, 1);
		String hashedSSN2 = ShaUtil.sha256WithSaltEncode(beforeHashingMember.getSSN2().substring(1), salt);
		String memberNo = beforeHashingMember.getSSN1() + "-" + gender + hashedSSN2;
		HashedMember hashedMember = new HashedMember(beforeHashingMember.getMemberId(), hashedMemberPwd, salt, beforeHashingMember.getMemberName(),
				memberNo, beforeHashingMember.getPhone(), beforeHashingMember.getNickname(), beforeHashingMember.getAddress());
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
}
