package com.petplace.shopping.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.petplace.common.PageInfo;
import com.petplace.shopping.model.dto.ShoppingList;

public interface ShoppingService {
	public abstract int selectShoppingListCount();
	public abstract ArrayList<ShoppingList> selectShoppingList(PageInfo pi, String categoryName);
	
	public abstract int selectSearchCount(HashMap<String, String> map);
	public abstract ArrayList<ShoppingList> selectSearchList(HashMap<String, String> map, PageInfo pi);
}
