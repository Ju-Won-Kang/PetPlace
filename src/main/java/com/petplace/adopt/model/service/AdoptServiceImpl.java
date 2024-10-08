package com.petplace.adopt.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.petplace.adopt.model.dao.AdoptDao;
import com.petplace.adopt.model.vo.Adopt;
import com.petplace.common.PageInfo;
import com.petplace.common.Template;

public class AdoptServiceImpl implements AdoptService{
	
	private AdoptDao aDao = new AdoptDao(); 
	
	@Override
	public int selectAdoptListCount(String type) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = aDao.selectAdoptListCount(sqlSession, type);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public ArrayList<Adopt> selectAdoptList(PageInfo pi, String boardType) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Adopt> list = aDao.selectAdoptList(sqlSession, pi, boardType);
		return list;
	}

}
