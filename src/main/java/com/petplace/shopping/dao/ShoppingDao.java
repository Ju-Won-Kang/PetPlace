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

import com.petplace.common.PageInfo;
import com.petplace.community.model.dao.CommunityDao;
import com.petplace.shopping.model.vo.Shopping;

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
	
	public ArrayList<Shopping> selectShoppingList(Connection conn, PageInfo pi){
		
		ArrayList<Shopping> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectShoppingList");
		
		try {
			pstmt = conn.prepareStatement(sql);
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
				Shopping s = new Shopping();
				s.setProductNo(rset.getString("product_no"));
				s.setProductName(rset.getString("product_name"));
				s.setPrice(rset.getInt("price"));
				s.setProductCategory(rset.getString("product_category"));
				s.setProductImg(rset.getString("product_img"));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Shopping> selectAllList(Connection conn, String categoryName){
		
		ArrayList<Shopping> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAllList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Shopping s = new Shopping();
				s.setProductNo(rset.getString("product_no"));
				s.setProductName(rset.getString("product_name"));
				s.setPrice(rset.getInt("price"));
				s.setProductCategory(rset.getString("product_category"));
				s.setProductImg(rset.getString("product_img"));
				list.add(s);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
	
	public ArrayList<Shopping> selectCategoryList(Connection conn, String categoryName){
		
		ArrayList<Shopping> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, categoryName);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Shopping s = new Shopping();
				s.setProductNo(rset.getString("product_no"));
				s.setProductName(rset.getString("product_name"));
				s.setPrice(rset.getInt("price"));
				s.setProductCategory(rset.getString("product_category"));
				s.setProductImg(rset.getString("product_img"));
				list.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
		
	}
}
