package com.petplace.shopping.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.shopping.model.dto.ShoppingList;

public class ShoppingDao {

	public int selectShoppingListCount(SqlSession sqlSession, String category) {
		return sqlSession.selectOne("shoppingMapper.selectShoppingListCount", category);
	}
	
	public ArrayList<ShoppingList> selectShoppingList(SqlSession sqlSession, PageInfo pi, String category){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("shoppingMapper.selectShoppingList", category, rowBounds);
		
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map ) {
		return sqlSession.selectOne("shoppingMapper.selectSearchCount", map);
	}
	
	public ArrayList<ShoppingList> selectSearchList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("shoppingMapper.selectSearchList", map, rowBounds);
	}
}
