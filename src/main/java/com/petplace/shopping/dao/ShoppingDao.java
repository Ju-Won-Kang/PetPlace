package com.petplace.shopping.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.petplace.common.PageInfo;
import com.petplace.shopping.model.dto.ShoppingList;

public class ShoppingDao {

	public int selectShoppingListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("shoppingMapper.selectShoppingListCount");
	}
	
	public ArrayList<ShoppingList> selectShoppingList(SqlSession sqlSession, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("shoppingMapper.selectShoppingList", null, rowBounds);
		
	}
	
//	public ArrayList<Shopping> selectAllList(Connection conn, String categoryName){
//		
//		ArrayList<Shopping> list = new ArrayList<>();
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String sql = prop.getProperty("selectAllList");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			
//			rset = pstmt.executeQuery();
//			while(rset.next()) {
//				Shopping s = new Shopping();
//				s.setProductNo(rset.getString("product_no"));
//				s.setProductName(rset.getString("product_name"));
//				s.setPrice(rset.getInt("price"));
//				s.setProductCategory(rset.getString("product_category"));
//				s.setProductImg(rset.getString("product_img"));
//				list.add(s);
//			}
//			
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return list;
//		
//	}
//	
//	public ArrayList<Shopping> selectCategoryList(Connection conn, String categoryName){
//		
//		ArrayList<Shopping> list = new ArrayList<>();
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String sql = prop.getProperty("selectCategoryList");
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, categoryName);
//			
//			rset = pstmt.executeQuery();
//			while(rset.next()) {
//				Shopping s = new Shopping();
//				s.setProductNo(rset.getString("product_no"));
//				s.setProductName(rset.getString("product_name"));
//				s.setPrice(rset.getInt("price"));
//				s.setProductCategory(rset.getString("product_category"));
//				s.setProductImg(rset.getString("product_img"));
//				list.add(s);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return list;
//		
//	}
}
