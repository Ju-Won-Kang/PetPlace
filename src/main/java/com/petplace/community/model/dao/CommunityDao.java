package com.petplace.community.model.dao;

import static com.petplace.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.petplace.common.PageInfo;
import com.petplace.community.model.vo.Community;
import com.petplace.community.model.vo.CommunityAttachment;

public class CommunityDao {
	private Properties prop = new Properties();

	public CommunityDao() {
		String filePath = CommunityDao.class.getResource("/db/sql/community-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectListCount(Connection conn) {
		//select -> ResultSet(한행) -> int
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}
	
	public ArrayList<Community> selectList(Connection conn, PageInfo pi) {
		//select -> ResultSet(여러행) -> ArrayList<Board>
		
		ArrayList<Community> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			/*
			 * currentPage : 1 -> 1~10
			 * currentPage : 2 -> 11~20
			 */
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Community c = new Community();
				c.setCummunity_no(rset.getInt("community_no"));
				c.setCommunity_category(rset.getString("community_category"));
				c.setCommunity_title(rset.getString("community_title"));
				c.setNickname(rset.getString("nickname"));
				c.setCommunity_date(rset.getString("community_date"));
				c.setCommunity_views(rset.getInt("community_views"));
				c.setCommunity_good(rset.getInt("community_good"));
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int insertCommunity(Connection conn, Community c) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCommunity");
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, c.getMember_id());
			pstmt.setString(2, c.getCommunity_category());
			pstmt.setString(3, c.getCommunity_title());
			pstmt.setString(4, c.getCommunity_detail());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int insertCommunityAttachmentList(Connection conn, ArrayList<CommunityAttachment> list) {
		int result = 1;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertCommunityAttachmentList");
		
		try {
			for(CommunityAttachment at : list) {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());
				
				result = result * pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	

}
