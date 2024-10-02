package com.petplace.shopping.service;

import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.shopping.model.dto.ShoppingDetailList;
import com.petplace.shopping.model.dto.ShoppingList;

public interface ShoppingService {
	public abstract int selectShoppingListCount();
	public abstract ArrayList<ShoppingList> selectShoppingList(PageInfo pi);
	public abstract ArrayList<ShoppingDetailList> selectDetailProductList(int productNo);
}
