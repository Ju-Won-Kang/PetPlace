package com.petplace.product.model.dao;

import com.petplace.admin.model.dto.Category;
import com.petplace.product.model.vo.AttachmentProduct;
import com.petplace.product.model.vo.Product;

import static com.petplace.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 * packageName    : com.petplace.product.model.dao
 * fileName       : ProductDao
 * author         : jun
 * date           : 2024. 9. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 24.        jun       최초 생성
 */
public class ProductDao {
    private Properties prop = new Properties();

    public ProductDao() {
        String filePath = ProductDao.class.getResource("/db/sql/product-mapper.xml").getPath();
        try {
            prop.loadFromXML(new FileInputStream(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Product 테이블의 전체 상품에서 카테고리명을 가져오는 메서드
     * @param conn Connection 객체
     * @return 카테고리 리스트 객체
     */
    public ArrayList<Category> selectCategoryList(Connection conn) {
        ArrayList<Category> cList = new ArrayList<>();
        ResultSet rSet = null;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("selectCategoryList");

        try {
            pstmt = conn.prepareStatement(sql);
            rSet = pstmt.executeQuery();

            while (rSet.next()) {
                cList.add(new Category(rSet.getString("PRODUCT_CATEGORY")));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rSet);
            close(pstmt);
        }
        return cList;
    }

    /**
     * 상품 등록
     * @param conn Connection 객체
     * @param p Request시 Parameter 정보를 담은 Product 객체
     * @return DB에 Insert 결과값
     */
    public int insertProduct(Connection conn, Product p) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertProduct");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getProductCategory());
            pstmt.setString(2, p.getCompany());
            pstmt.setString(3, p.getProductName());
            pstmt.setInt(4, p.getPrice());
            pstmt.setInt(5, p.getInventory());
            pstmt.setString(6, p.getIngredient());
            pstmt.setString(7, p.getOrigin());
            pstmt.setInt(8, p.getProductWeight());
            pstmt.setInt(9, p.getKcal());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    /**
     * 상품 썸네일, 상품 상세정보 파일 등록
     * @param conn Connection 객체
     * @param list 썸네일, 상품 상세정보 파일 정보를 담은 리스트
     * @return DB에 Insert 결과값
     */
    public int insertAttachmentList(Connection conn, ArrayList<AttachmentProduct> list) {
        int result = 1;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertAttachmentList");

        try {
            for (AttachmentProduct atP : list) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,atP.getOriginName());
                pstmt.setString(2,atP.getChangeName());
                pstmt.setString(3,atP.getFilePath());
                pstmt.setInt(4,atP.getFileLevel());
                result *= pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }
}
