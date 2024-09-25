package com.petplace.community.service;

import static com.petplace.common.JDBCTemplate.close;
import static com.petplace.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.community.model.dao.CommunityDao;
import com.petplace.community.model.vo.Community;

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
	
	
}
