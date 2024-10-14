package com.petplace.shopping.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.petplace.review.model.vo.Review;
import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.purchase.model.vo.Purchase;

import com.petplace.shopping.model.dao.ShoppingDao;

import com.petplace.shopping.model.dto.ShoppingComplete;
import com.petplace.shopping.model.dto.ShoppingDetailList;
import com.petplace.shopping.model.dto.ShoppingList;
import com.petplace.shopping.model.dto.UserInfo;

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
	public ArrayList<ShoppingDetailList> selectDetailProduct(int productNo) {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<ShoppingDetailList> product = sDao.selectDetailProduct(sqlSession, productNo);
		sqlSession.close();
		return product;
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
	public ShoppingComplete selectShoppingCompleteList(int productNo, String memberId) {
		SqlSession sqlSession = Template.getSqlSession();
		Map<String, Object> params = new HashMap<>();
	    params.put("productNo", productNo);
	    params.put("memberId", memberId);
	    ShoppingComplete result = sDao.selectShoppingCompleteList(sqlSession, params);
	    
	    return result;
	}


	@Override
	public UserInfo selectUserInfoList(String userId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		UserInfo list = sDao.selectUserInfoList(sqlSession, userId);
		sqlSession.close();
		return list;
	}

	@Override
	public int insertPurchase(Purchase purchase) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = sDao.insertPurchase(sqlSession, purchase);
		if(result > 0) {
			sqlSession.commit();
			System.out.println("커밋성공!");
		}else {
			sqlSession.rollback();
			System.out.println("커밋실패..");
		}
		sqlSession.close();
		return result;
	}

	

	public ArrayList<ShoppingList> selectShoppingTopList() {
		SqlSession sqlSession = Template.getSqlSession();
		ArrayList<ShoppingList> list = new ShoppingDao().selectShoppingTopList(sqlSession);
		System.out.println(list);
		return list;
	}
	@Override
	public int selectReviewCount(int productNo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = sDao.selectReviewCount(sqlSession, productNo);
		
		sqlSession.close();
		return result;
	}

	@Override
	public ArrayList<Review> selectReviewList(int productNo) {
		SqlSession sqlSession = Template.getSqlSession();

		System.out.println();
		ArrayList<Review> list = (ArrayList)sDao.selectReviewList(sqlSession, productNo);
		sqlSession.close();

		return list;

	}
}
