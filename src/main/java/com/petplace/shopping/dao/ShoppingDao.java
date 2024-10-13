package com.petplace.shopping.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.purchase.model.vo.Purchase;
import com.petplace.review.model.vo.Review;
import com.petplace.shopping.model.dto.ShoppingComplete;
import com.petplace.shopping.model.dto.ShoppingDetailList;
import com.petplace.shopping.model.dto.ShoppingList;
import com.petplace.shopping.model.dto.UserInfo;

public class ShoppingDao {

	public int selectShoppingListCount(SqlSession sqlSession, String category) {
		return sqlSession.selectOne("shoppingMapper.selectShoppingListCount", category);
	}

	public ArrayList<ShoppingList> selectShoppingAllList(SqlSession sqlSession, PageInfo pi, String category){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("shoppingMapper.selectShoppingAllList", category, rowBounds);
		
	}
	
	public ArrayList<ShoppingList> selectShoppingPetList(SqlSession sqlSession, PageInfo pi, String category){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("shoppingMapper.selectShoppingPetList", category, rowBounds);
		
	}
	
	public int selectSearchCount(SqlSession sqlSession, HashMap<String, String> map ) {
		return sqlSession.selectOne("shoppingMapper.selectSearchPetCount", map);
	}
	
	public int selectSearchCount(SqlSession sqlSession, String keyword ) {
		return sqlSession.selectOne("shoppingMapper.selectSearchAllCount", keyword);
	}
	
	public ArrayList<ShoppingList> selectSearchAllList(SqlSession sqlSession, String keyword, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("shoppingMapper.selectSearchAllList", keyword, rowBounds);
	}
	
	public ArrayList<ShoppingList> selectSearchPetList(SqlSession sqlSession, HashMap<String, String> map, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("shoppingMapper.selectSearchPetList", map, rowBounds);
	}
	
	public ArrayList<ShoppingDetailList> selectDetailProduct(SqlSession sqlSession, int boardNo) {
		
	    return (ArrayList)sqlSession.selectList("shoppingMapper.selectDetailProduct", boardNo);
	}
	
	public ShoppingComplete selectShoppingCompleteList(SqlSession sqlSession, Map<String, Object> params) {
	    return sqlSession.selectOne("shoppingMapper.selectShoppingCompleteList", params);
	}

	public UserInfo selectUserInfoList(SqlSession sqlSession, String userId){
		return (UserInfo)sqlSession.selectOne("shoppingMapper.selectUserInfoList",userId);
	}

	public int insertPurchase(SqlSession sqlSession, Purchase purchase) {
		System.out.println(purchase);
		return sqlSession.insert("shoppingMapper.insertPurchase", purchase);
	}
	
	public int selectReviewCount(SqlSession sqlSession, int productNo) {
		int result = sqlSession.selectOne("shoppingMapper.selectReviewCount", productNo);
		return result;
	}
	
	// 모든 리뷰 ArrayList가져오기
	public ArrayList<Review> selectReviewList(SqlSession sqlSession, int productNo) {
		
		return (ArrayList)sqlSession.selectList("shoppingMapper.selectReviewList", productNo);
	}
	
}


