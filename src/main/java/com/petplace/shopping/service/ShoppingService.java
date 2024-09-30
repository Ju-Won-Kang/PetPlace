package com.petplace.shopping.service;

import static com.petplace.common.JDBCTemplate.close;
import static com.petplace.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.shopping.dao.ShoppingDao;
import com.petplace.shopping.model.vo.Shopping;

public class ShoppingService {
	public int selectShoppingListCount() {
		Connection conn = getConnection();
		
		int shoppingListCount = new ShoppingDao().selectShoppingListCount(conn);
		
		close(conn);
		
		return shoppingListCount;
	}
	
	public ArrayList<Shopping> selectShoppingList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Shopping> list = new ShoppingDao().selectShoppingList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	public ArrayList<Shopping> selectDogList(String categoryName) {
		Connection conn = getConnection();
		
		ArrayList<Shopping> list = new ShoppingDao().selectDogList(conn, categoryName);
		
		close(conn);
		
		return list;
	}
}
