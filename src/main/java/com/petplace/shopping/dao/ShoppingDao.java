package com.petplace.shopping.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.shopping.model.dto.ShoppingDetailList;
import com.petplace.shopping.model.dto.ShoppingList;

public class ShoppingDao {
	
	private Properties prop = new Properties();

	public int selectShoppingListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("shoppingMapper.selectShoppingListCount");
	}
	
	
	public ArrayList<ShoppingList> selectShoppingList(SqlSession sqlSession, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("shoppingMapper.selectShoppingList", null, rowBounds);
	}
	
	
	
	public ArrayList<ShoppingDetailList> selectDetailProduct(SqlSession sqlSession, int productNo) {
		
	    return (ArrayList)sqlSession.selectList("shoppingMapper.selectDetailProduct", productNo);
	}





}


