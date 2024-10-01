package com.petplace.shopping.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.shopping.dao.ShoppingDao;
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
	public ArrayList<ShoppingList> selectShoppingList(PageInfo pi, String categoryName) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<ShoppingList> list = sDao.selectShoppingList(sqlSession, pi, categoryName);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = sDao.selectSearchCount(sqlSession, map);
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public ArrayList<ShoppingList> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<ShoppingList> list = sDao.selectSearchList(sqlSession, map, pi);
		
		sqlSession.close();
		
		return list;
	}

}
