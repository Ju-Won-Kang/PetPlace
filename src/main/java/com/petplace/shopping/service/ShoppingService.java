package com.petplace.shopping.service;

import static com.petplace.common.JDBCTemplate.close;
import static com.petplace.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.product.model.vo.Product;
import com.petplace.shopping.dao.ShoppingDao;

public class ShoppingService {
	public int selectShoppingListCount() {
		Connection conn = getConnection();
		
		int shoppingListCount = new ShoppingDao().selectShoppingListCount(conn);
		
		close(conn);
		
		return shoppingListCount;
	}
	
	public ArrayList<Product> selectShoppingList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ShoppingDao().selectShoppingList(conn, pi);
		
		close(conn);
		
		return list;
	}
}
