package com.petplace.shopping.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.petplace.common.PageInfo;
import com.petplace.purchase.model.vo.Purchase;
import com.petplace.review.model.vo.Review;
import com.petplace.shopping.model.dto.ShoppingComplete;
import com.petplace.shopping.model.dto.ShoppingDetailList;
import com.petplace.shopping.model.dto.ShoppingList;
import com.petplace.shopping.model.dto.UserInfo;

public interface ShoppingService {
	
	public abstract int selectShoppingListCount(String category);
	
	public abstract ArrayList<ShoppingList> selectShoppingAllList(PageInfo pi, String categoryName);
	
	public abstract ArrayList<ShoppingList> selectShoppingPetList(PageInfo pi, String categoryName);
	
	public abstract int selectSearchCount(HashMap<String, String> map);
	public abstract int selectSearchCount(String keyword);
	
	public abstract ArrayList<ShoppingList> selectSearchAllList(String keyword, PageInfo pi);
	public abstract ArrayList<ShoppingList> selectSearchPetList(HashMap<String, String> map, PageInfo pi);
	
	public abstract ArrayList<ShoppingDetailList> selectDetailProduct(int productNo);
	
	public abstract ShoppingComplete selectShoppingCompleteList(int productNo, String userId);
	public abstract UserInfo selectUserInfoList(String userId);
	public abstract int insertPurchase(Purchase purchase);
	

	ArrayList<ShoppingList> selectShoppingTopList();
	//리뷰 총 개수
	public abstract int selectReviewCount(int productNo);

	//리뷰 리스트 가져오기
	public abstract ArrayList<Review> selectReviewList(int productNo);
	
}
