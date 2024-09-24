package com.petplace.product.model.dao;

import com.petplace.admin.model.vo.Category;
import com.petplace.admin.model.vo.Product;
import com.petplace.common.JDBCTemplate;

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

    public ArrayList<Category> selectCategoryList(Connection conn) {
        ArrayList<Category> cList = new ArrayList<>();
        ResultSet rSet = null;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("selectCategoryList");

        try {
            pstmt = conn.prepareStatement(sql);
            rSet = pstmt.executeQuery();

            while (rSet.next()) {
                cList.add(new Category(
                        rSet.getString("category_no"),
                        rSet.getString("category_name")
                ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rSet);
            close(pstmt);
        }
        return cList;
    }
}
