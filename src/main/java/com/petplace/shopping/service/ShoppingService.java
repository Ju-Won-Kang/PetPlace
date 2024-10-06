package com.petplace.shopping.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.petplace.common.PageInfo;
import com.petplace.shopping.model.dto.ShoppingComplete;
import com.petplace.shopping.model.dto.ShoppingDetailList;
import com.petplace.shopping.model.dto.ShoppingList;

public interface ShoppingService {
	public abstract int selectShoppingListCount(String category);
	public abstract ArrayList<ShoppingList> selectShoppingAllList(PageInfo pi, String categoryName);
	public abstract ArrayList<ShoppingList> selectShoppingPetList(PageInfo pi, String categoryName);
	
	public abstract int selectSearchCount(HashMap<String, String> map);
	public abstract int selectSearchCount(String keyword);
	public abstract ArrayList<ShoppingList> selectSearchAllList(String keyword, PageInfo pi);
	public abstract ArrayList<ShoppingList> selectSearchPetList(HashMap<String, String> map, PageInfo pi);
	
	public abstract ShoppingDetailList selectDetailProduct(int productNo);
	
	public abstract ArrayList<ShoppingComplete> selectShoppingCompleteList(int productNo);
}
