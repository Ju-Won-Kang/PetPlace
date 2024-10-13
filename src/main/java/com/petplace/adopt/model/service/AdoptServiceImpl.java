package com.petplace.adopt.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.petplace.adopt.model.dao.AdoptDao;
import com.petplace.adopt.model.vo.Adopt;
import com.petplace.adopt.model.vo.AdoptAttachment;
import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.community.model.vo.CommunityAttachment;

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
		
		sqlSession.close();
		
		return list;
	}

	// 입양 게시글 삽입
	@Override
	public int insertAdopt(Adopt a, AdoptAttachment aAt) {
		SqlSession sqlSession = Template.getSqlSession();
		int result1 = aDao.insertAdopt(sqlSession, a); 
		
		int result2 = 1;
		if(aAt.getOriginName() != null) {
			result2 = aDao.insertAdoptAttachmentList(sqlSession, aAt);
		}
		
		
		if(result1 * result2 > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result1 * result2;
	}

	@Override
	public Adopt selectDetailList(HashMap<String, Object> map) {
		SqlSession sqlSession = Template.getSqlSession();
		Adopt a = aDao.selectDetailList(sqlSession, map);
		
		sqlSession.close();
		return a;
	}

	@Override
	public int increaseCount(HashMap<String, Object> map) {
		SqlSession sqlSession = Template.getSqlSession();
		System.out.println("aDao");
		int result = aDao.increaseCount(sqlSession, map);
		System.out.println("aDao end");
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	// 메인페이지 유기/실종
	@Override
	public ArrayList<Adopt> selectMissingMainList() {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Adopt> list = aDao.selectMissingMainList(sqlSession);
		
		sqlSession.close();
		return list;
	}

	@Override
	public ArrayList<Adopt> selectDistributeMainList() {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Adopt> list = aDao.selectDistributeMainList(sqlSession);
		System.out.println("disSer" + list);
		sqlSession.close();
		return list;
	}

	@Override
	public int selectSearchListCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int searchCount = aDao.selectSearchListCount(sqlSession, map);
		
		sqlSession.close();
		
		return searchCount;
	}

	@Override
	public ArrayList<Adopt> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Adopt> list = aDao.selectSearchList(sqlSession, map, pi);
		System.out.println("Searchend" + list);
		sqlSession.close();
		
		return list;
	}
	
	@Override
	public int deleteAdopt(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = aDao.deleteAdopt(sqlSession, boardNo);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int deleteAdoptAt(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = aDao.deleteAdoptAt(sqlSession, boardNo);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}
	
	@Override
	public AdoptAttachment selectAdoptAt(int boardNo) {
		SqlSession sqlSession = Template.getSqlSession();
		AdoptAttachment aAt = aDao.selectAdoptAt(sqlSession, boardNo);
		
		sqlSession.close();
		return aAt;
	}

}
