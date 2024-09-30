package com.petplace.shopping.dao;

import static com.petplace.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.petplace.community.model.dao.CommunityDao;
import com.petplace.product.model.vo.AttachmentProduct;
import com.petplace.product.model.vo.Product;

public class ShoppingDao {
	private Properties prop = new Properties();

	public ShoppingDao() {
		String filePath = CommunityDao.class.getResource("/db/sql/shopping-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int selectShoppingListCount(Connection conn) {
		
		int shoppingListCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectShoppingListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				shoppingListCount = rset.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return shoppingListCount;
	}
	
	public ArrayList<Product> selectShoppingList(Connection conn){
		
		ArrayList<Product> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectShoppingList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product();
				p.setProductNo(rset.getInt("productNo"));
				p.setProductName("productCategory");
				p.set(rset.getInt("productNo"));
			}
			
			/*
			 * currentPage : 1 -> 1~10
			 * currentPage : 2 -> 11~20
			 */
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product();
				p.setProductNo(rset.getString("product_no"));
				p.setProductName(rset.getString("product_name"));
				p.setPrice(rset.getInt("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public AttachmentProduct selectAttachmentProduct(Connection conn, int productNo) {
		ResultSet rset = null;
		AttachmentProduct atp = null;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectAttachmentProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 0); // 뭘 넣어야할지를 몰라서 작성불가
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atp;
	}
}
