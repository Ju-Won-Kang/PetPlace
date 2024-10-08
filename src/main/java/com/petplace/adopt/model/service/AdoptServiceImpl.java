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
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = aDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public ArrayList<Adopt> selectAdoptMissingList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Adopt> list = aDao.selectAdoptMissingList(sqlSession, pi);
		return list;
	}

}
