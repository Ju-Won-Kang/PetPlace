package com.petplace.community.service;

import static com.petplace.common.JDBCTemplate.close;
import static com.petplace.common.JDBCTemplate.commit;
import static com.petplace.common.JDBCTemplate.getConnection;
import static com.petplace.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.community.model.dao.CommunityDao;
import com.petplace.community.model.vo.Community;
import com.petplace.community.model.vo.CommunityAttachment;

public class CommunityService {
	
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
}
