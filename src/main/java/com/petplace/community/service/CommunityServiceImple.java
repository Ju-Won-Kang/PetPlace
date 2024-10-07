package com.petplace.community.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.community.model.dao.CommunityDao;
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
	public ArrayList<Community> selectList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<Community> list = cDao.selectList(sqlSession, pi);
		
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
		return c;
	}
	
	
/*	
	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new CommunityDao().selectListCount(conn);
		close(conn);
		
		return listCount;
	}
	
	public ArrayList<Community> selectList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Community> list = new CommunityDao().selectList(conn, pi);
		close(conn);
		
		return list;
	}
	
	public int insertCommunity(Community c, ArrayList<CommunityAttachment> list) {
		Connection conn = getConnection();
		
		CommunityDao bDao = new CommunityDao();
		int result1 = bDao.insertCommunity(conn, c);
		int result2 = 1;
		
		if(list != null) {
			result2 = bDao.insertCommunityAttachmentList(conn, list);
		}
		
		if(result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
				
		close(conn);
		
		return result1 * result2;
	}
	
*/
}
