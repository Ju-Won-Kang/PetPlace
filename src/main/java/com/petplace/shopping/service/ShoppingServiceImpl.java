package com.petplace.shopping.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.shopping.dao.ShoppingDao;
import com.petplace.shopping.model.dto.ShoppingDetailList;
import com.petplace.shopping.model.dto.ShoppingList;

public class ShoppingServiceImpl implements ShoppingService {
	ShoppingDao sDao = new ShoppingDao();
	
	public int selectShoppingListCount() {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = sDao.selectShoppingListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	@Override
	public ArrayList<ShoppingList> selectShoppingList(PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<ShoppingList> list = sDao.selectShoppingList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}



	@Override
	public ArrayList<ShoppingDetailList> selectDetailProduct(int productNo) {
		SqlSession sqlSession = Template.getSqlSession();

		ArrayList<ShoppingDetailList> product = sDao.selectDetailProduct(sqlSession, productNo);
		System.out.println(product);
		sqlSession.close();
		
		return product;
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
