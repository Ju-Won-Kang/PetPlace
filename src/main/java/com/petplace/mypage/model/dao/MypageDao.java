package com.petplace.mypage.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.petplace.mypage.model.dto.Petinfo;

public class MypageDao {

	public Petinfo selectPetinfo(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("mypageMapper.selectPetinfo", userId);
	}

	
}

