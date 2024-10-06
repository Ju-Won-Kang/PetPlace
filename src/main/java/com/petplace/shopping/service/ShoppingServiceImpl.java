package com.petplace.shopping.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.shopping.dao.ShoppingDao;
import com.petplace.shopping.model.dto.ShoppingComplete;
import com.petplace.shopping.model.dto.ShoppingDetailList;
import com.petplace.shopping.model.dto.ShoppingList;

public class ShoppingServiceImpl implements ShoppingService {
	ShoppingDao sDao = new ShoppingDao();
	
	public int selectShoppingListCount(String category) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = sDao.selectShoppingListCount(sqlSession, category);
		
		sqlSession.close();
		
		return listCount;
	}
	
	@Override
	public ArrayList<ShoppingList> selectShoppingAllList(PageInfo pi, String category) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<ShoppingList> list = sDao.selectShoppingAllList(sqlSession, pi, category);
		
		sqlSession.close();
		
		return list;
	}
	
	@Override
	public ArrayList<ShoppingList> selectShoppingPetList(PageInfo pi, String category) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<ShoppingList> list = sDao.selectShoppingPetList(sqlSession, pi, category);
		
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
	public int selectSearchCount(String keyword) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = sDao.selectSearchCount(sqlSession, keyword);
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public ArrayList<ShoppingList> selectSearchAllList(String keyword, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<ShoppingList> list = sDao.selectSearchAllList(sqlSession, keyword, pi);
		
		sqlSession.close();
		
		return list;
	}
	
	@Override
	public ArrayList<ShoppingList> selectSearchPetList(HashMap<String, String> map, PageInfo pi) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<ShoppingList> list = sDao.selectSearchPetList(sqlSession, map, pi);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public ShoppingDetailList selectDetailProduct(int productNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ShoppingDetailList product = sDao.selectDetailProduct(sqlSession, productNo);
		
		sqlSession.close();
		
		return product;
	}

	@Override
	public ArrayList<ShoppingComplete> selectShoppingCompleteList(int productNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<ShoppingComplete> list = sDao.selectShoppingCompleteList(sqlSession, productNo);
		
		return null;
	}
}
