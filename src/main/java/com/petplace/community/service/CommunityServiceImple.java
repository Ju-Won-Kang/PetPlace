package com.petplace.community.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.community.model.dao.CommunityDao;
import com.petplace.community.model.vo.BoardComment;
import com.petplace.community.model.vo.Community;
import com.petplace.community.model.vo.CommunityAttachment;

public class CommunityServiceImple implements CommunityService {
	
	private CommunityDao cDao = new CommunityDao();

	@Override
	public int selectListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = cDao.selectListCount(sqlSession);
		
		sqlSession.close();
		return listCount;
	}
	
	@Override
	public int selectListCount(String category) {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = cDao.selectListCount(sqlSession, category);
		
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Community> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		return list;
	}

	@Override
	public ArrayList<Community> selectList(PageInfo pi, String category) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectList(sqlSession, pi, category);
		
		sqlSession.close();
		return list;
	}
	
	@Override
	public ArrayList<Community> selectGoodList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectGoodList(sqlSession, pi);
		
		sqlSession.close();
		return list;
	}

	@Override
	public ArrayList<Community> selectGoodList(PageInfo pi, String category) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectGoodList(sqlSession, pi, category);
		
		sqlSession.close();
		return list;
	}
	@Override
	public int insertCommunity(Community c, CommunityAttachment atC) {
		SqlSession sqlSession = Template.getSqlSession();
		int result1 = cDao.insertCommunity(sqlSession, c);
		
		int result2 = 1;
		if(atC.getOriginName() != null) {
			result2 = cDao.insertCommunityAttachmentList(sqlSession, atC);
		}
		
		if(result1*result2 > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result1 * result2;
	}

	@Override
	public Community increaseCount(int communityNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = cDao.increaseCount(sqlSession, communityNo);
		
		Community c = null;
		if(result > 0) {
			sqlSession.commit();
			c = cDao.selectCommunity(sqlSession, communityNo);
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return c;
	}

	@Override
	public int selectSearchCount(String keyword) {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = cDao.selectSearchCount(sqlSession, keyword);
		
		sqlSession.close();
		return listCount;
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		int listCount = cDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		return listCount;
	}

	@Override
	public ArrayList<Community> selectSearchList(PageInfo pi, String keyword) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectSearchList(sqlSession, pi, keyword);
		
		sqlSession.close();
		return list;
	}

	@Override
	public ArrayList<Community> selectSearchList(PageInfo pi, HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectSearchList(sqlSession, pi, map);
		
		sqlSession.close();
		return list;
	}
	
	@Override
	public ArrayList<Community> selectSearchGoodList(PageInfo pi, String keyword) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectSearchGoodList(sqlSession, pi, keyword);
		
		sqlSession.close();
		return list;
	}

	@Override
	public ArrayList<Community> selectSearchGoodList(PageInfo pi, HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectSearchGoodList(sqlSession, pi, map);
		
		sqlSession.close();
		return list;
	}

	@Override
	public CommunityAttachment selectCommunityAt(int communityNo) {
		SqlSession sqlSession = Template.getSqlSession();
		CommunityAttachment atC = cDao.selectCommunityAt(sqlSession, communityNo);
		
		sqlSession.close();
		return atC;
	}

	@Override
	public Community selectCommunity(int communityNo) {
		SqlSession sqlSession = Template.getSqlSession();
		Community c = cDao.selectCommunity(sqlSession, communityNo);
		
		sqlSession.close();
		return c;
	}

	@Override
	public int deleteCommunity(int communityNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = cDao.deleteCommunity(sqlSession, communityNo);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int deleteCommunityAt(int communityNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = cDao.deleteCommunityAt(sqlSession, communityNo);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int communityGood(int communityNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = cDao.communityGood(sqlSession, communityNo);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int communityBad(int communityNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = cDao.communityBad(sqlSession, communityNo);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int insertComment(BoardComment bc) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = cDao.insertComment(sqlSession, bc);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<BoardComment> selectCommentList(int communityNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<BoardComment> list = cDao.selectCommentList(sqlSession, communityNo);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public ArrayList<Community> selectCommunityDay() {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectCommunityDay(sqlSession);
		
		sqlSession.close();
		
		return list;
	}
	
	@Override
	public ArrayList<Community> selectCommunityWeek() {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectCommunityWeek(sqlSession);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public int updateCommunity(Community c, CommunityAttachment atC) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = cDao.updateCommunity(sqlSession, c, atC);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int deleteComment(int commentNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = cDao.deleteComment(sqlSession, commentNo);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int updateComment(BoardComment bc) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = cDao.updateComment(sqlSession, bc);
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return result;
	}
}
