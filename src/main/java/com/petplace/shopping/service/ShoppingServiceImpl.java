package com.petplace.shopping.service;

import static com.petplace.common.JDBCTemplate.close;
import static com.petplace.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.shopping.dao.ShoppingDao;
import com.petplace.shopping.model.vo.Shopping;

public class ShoppingServiceImpl implements ShoppingService {
	ShoppingDao sDao = new ShoppingDao();
	
	public int selectShoppingListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = sDao.selectShoppingListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	@Override
	public ArrayList<Shopping> selectShoppingList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Shopping> list = sDao.selectShoppingList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}
	
	
	
	
//	public ArrayList<Shopping> selectAllList(String categoryName) {
//		Connection conn = getConnection();
//		
//		ArrayList<Shopping> list = new ShoppingDao().selectAllList(conn, categoryName);
//		
//		close(conn);
//		
//		return list;
//	}
//	
//	
//	public ArrayList<Shopping> selectCategoryList(String categoryName) {
//		Connection conn = getConnection();
//		
//		ArrayList<Shopping> list = new ShoppingDao().selectCategoryList(conn, categoryName);
//		
//		close(conn);
//		
//		return list;
//	}







}
