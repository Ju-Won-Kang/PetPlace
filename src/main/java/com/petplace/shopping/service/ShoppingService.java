package com.petplace.shopping.service;

import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.shopping.model.vo.Shopping;

public interface ShoppingService {
	public abstract int selectShoppingListCount();
	public abstract ArrayList<Shopping> selectShoppingList(PageInfo pi);
}
