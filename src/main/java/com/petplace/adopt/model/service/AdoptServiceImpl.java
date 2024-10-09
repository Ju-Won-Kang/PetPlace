package com.petplace.adopt.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.petplace.adopt.model.dao.AdoptDao;
import com.petplace.adopt.model.vo.Adopt;
import com.petplace.adopt.model.vo.AdoptAttachment;
import com.petplace.common.PageInfo;
import com.petplace.common.Template;

public class AdoptServiceImpl implements AdoptService{
	
	private AdoptDao aDao = new AdoptDao(); 
	
	// 입양 게시판 불러오기
	@Override
	public int selectAdoptListCount(String boardType) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = aDao.selectAdoptListCount(sqlSession, boardType);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public ArrayList<Adopt> selectAdoptList(PageInfo pi, String boardType) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Adopt> list = aDao.selectAdoptList(sqlSession, pi, boardType);
		return list;
	}

	// 입양 게시글 삽입
	@Override
	public int insertAdopt(Adopt a, AdoptAttachment aAt) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result1 = aDao.insertAdopt(sqlSession, a); 
		
				
		return 0;
	}

}
