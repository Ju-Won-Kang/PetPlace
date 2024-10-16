package com.petplace.community.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.community.model.vo.BoardComment;
import com.petplace.community.model.vo.Community;
import com.petplace.community.model.vo.CommunityAttachment;

public class CommunityDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("communityMapper.selectListAllCount");
	}
	
	public int selectListCount(SqlSession sqlSession, String communityCategory) {
		return sqlSession.selectOne("communityMapper.selectListCount", communityCategory);
	}
	
	public ArrayList<Community> selectList(SqlSession sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("communityMapper.selectListAll", null, rowBounds);
	}
	
	public ArrayList<Community> selectList(SqlSession sqlSession, PageInfo pi, String communityCategory) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("communityMapper.selectList", communityCategory, rowBounds);
	}
	
	public ArrayList<Community> selectGoodList(SqlSession sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("communityMapper.selectGoodListAll", null, rowBounds);
	}
	
	public ArrayList<Community> selectGoodList(SqlSession sqlSession, PageInfo pi, String communityCategory) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("communityMapper.selectGoodList", communityCategory, rowBounds);
	}
	
	public int insertCommunity(SqlSession sqlSession, Community c) {
		return sqlSession.insert("communityMapper.insertCommunity", c);
	}
	
	public int insertCommunityAttachmentList(SqlSession sqlSession, CommunityAttachment atC) {
		return sqlSession.insert("communityMapper.insertCommunityAttachmentList", atC);
	}
	
	public int increaseCount(SqlSession sqlSession, int communityNo) {
		return sqlSession.update("communityMapper.increaseCount", communityNo);
	}
	
	public Community selectCommunity(SqlSession sqlSession, int communityNo) {
		return (Community)sqlSession.selectOne("communityMapper.selectCommunity", communityNo);
	}
	
	public int selectSearchCount(SqlSession sqlSession, String keyword) {
		return sqlSession.selectOne("communityMapper.selectSearchAllCount", keyword);
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map) {
		return sqlSession.selectOne("communityMapper.selectSearchCount", map);
	}
	
	public ArrayList<Community> selectSearchList(SqlSession sqlSession, PageInfo pi, String keyword) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList)sqlSession.selectList("communityMapper.selectSearchListAll", keyword, rowBounds);
	}

	public ArrayList<Community> selectSearchList(SqlSession sqlSession, PageInfo pi, HashMap<String, String> map) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("communityMapper.selectSearchList", map, rowBounds);
	}
	
	public ArrayList<Community> selectSearchGoodList(SqlSession sqlSession, PageInfo pi, String keyword) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList)sqlSession.selectList("communityMapper.selectSearchGoodListAll", keyword, rowBounds);
	}

	public ArrayList<Community> selectSearchGoodList(SqlSession sqlSession, PageInfo pi, HashMap<String, String> map) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("communityMapper.selectSearchGoodList", map, rowBounds);
	}
	
	public CommunityAttachment selectCommunityAt(SqlSession sqlSession, int communityNo) {
		return (CommunityAttachment)sqlSession.selectOne("communityMapper.selectCommunityAt", communityNo);
	}
	
	public int deleteCommunity(SqlSession sqlSession, int communityNo) {
		return sqlSession.update("communityMapper.deleteCommunity", communityNo);
	}
	
	public int deleteCommunityAt(SqlSession sqlSession, int communityNo) {
		return sqlSession.update("communityMapper.deleteCommunityAt", communityNo);
	}
	
	public int communityGood(SqlSession sqlSession, int communityNo) {
		return sqlSession.update("communityMapper.communityGood", communityNo);
	}
	
	public int communityBad(SqlSession sqlSession, int communityNo) {
		return sqlSession.update("communityMapper.communityBad", communityNo);
	}
	
	public int insertComment(SqlSession sqlSession, BoardComment bc) {
		return sqlSession.update("communityMapper.insertComment", bc);
	}
	
	public ArrayList<BoardComment> selectCommentList(SqlSession sqlSession, int communityNo){
		return (ArrayList)sqlSession.selectList("communityMapper.selectCommentList", communityNo);
	}
	
	public ArrayList<Community> selectCommunityDay(SqlSession sqlSession) {
		RowBounds rowBounds = new RowBounds(0, 5);
		
		return (ArrayList)sqlSession.selectList("communityMapper.selectCommunityDay", null, rowBounds);
	}
	
	public ArrayList<Community> selectCommunityWeek(SqlSession sqlSession) {
		RowBounds rowBounds = new RowBounds(0, 5);
		
		return (ArrayList)sqlSession.selectList("communityMapper.selectCommunityWeek", null, rowBounds);
	}
	
	public int updateCommunity(SqlSession sqlSession, Community c, CommunityAttachment atC) {
		int result1 = sqlSession.update("communityMapper.updateCommunity", c);
		System.out.println(atC.getRefCno());
		System.out.println(atC);
		int result2 = 1;
		if(atC.getChangeName() != null) {
			result2 = sqlSession.insert("communityMapper.insertCommunityAttachmentU", atC);
		}
		return result1 * result2;
	}
	
	public int deleteComment(SqlSession sqlSession, int commentNo) {
		return sqlSession.delete("communityMapper.deleteComment", commentNo);
	}
	
	public int updateComment(SqlSession sqlSession, BoardComment bc) {
		return sqlSession.update("communityMapper.updateComment", bc);
	}
//	public int insertCommunity(Connection conn, Community c) {
//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		String sql = prop.getProperty("insertCommunity");
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, c.getMember_id());
//			pstmt.setString(2, c.getCommunity_category());
//			pstmt.setString(3, c.getCommunity_title());
//			pstmt.setString(4, c.getCommunity_detail());
//			
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		return result;
//	}
//	
//	public int insertCommunityAttachmentList(Connection conn, ArrayList<CommunityAttachment> list) {
//		int result = 1;
//		
//		PreparedStatement pstmt = null;
//		String sql = prop.getProperty("insertCommunityAttachmentList");
//		
//		try {
//			for(CommunityAttachment at : list) {
//				pstmt = conn.prepareStatement(sql);
//				
//				pstmt.setString(1, at.getOriginName());
//				pstmt.setString(2, at.getChangeName());
//				pstmt.setString(3, at.getFilePath());
//				
//				result = result * pstmt.executeUpdate();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(pstmt);
//		}
//		
//		return result;
//	}
	
	

}
