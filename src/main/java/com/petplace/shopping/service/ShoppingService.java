package com.petplace.shopping.service;

import static com.petplace.common.JDBCTemplate.close;
import static com.petplace.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.petplace.common.PageInfo;
import com.petplace.product.model.vo.AttachmentProduct;
import com.petplace.product.model.vo.Product;
import com.petplace.shopping.dao.ShoppingDao;

public class ShoppingService {
	public int selectShoppingListCount() {
		Connection conn = getConnection();
		
		int shoppingListCount = new ShoppingDao().selectShoppingListCount(conn);
		close(conn);
		
		return shoppingListCount;
	}
	
	public ArrayList<Product> selectShoppingList(){
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ShoppingDao().selectShoppingList(conn);
		
		close(conn);
		
		return list;
	}
	
	public AttachmentProduct selectAttachmentProduct(int productNo) {
		Connection conn = getConnection();
		AttachmentProduct at = new ShoppingDao().selectAttachmentProduct(conn, int productNo);
		return at;
	}
	
	
	
}