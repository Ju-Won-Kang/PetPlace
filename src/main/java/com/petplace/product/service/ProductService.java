package com.petplace.product.service;

import com.petplace.admin.model.vo.Category;

import static com.petplace.common.JDBCTemplate.*;
import com.petplace.product.model.dao.ProductDao;
import com.petplace.product.model.vo.AttachmentProduct;
import com.petplace.product.model.vo.Product;

import java.sql.Connection;
import java.util.ArrayList;

import static com.petplace.common.JDBCTemplate.getConnection;

/**
 * packageName    : com.petplace.product.service
 * fileName       : ProductService
 * author         : jun
 * date           : 2024. 9. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 24.        jun       최초 생성
 */
public class ProductService {
    public ArrayList<Category> selectCategoryList(){
        Connection conn = getConnection();
        ArrayList<Category> cList = new ProductDao().selectCategoryList(conn);
        close(conn);
        return cList;
    }
    public int CreateProduct(Product p, ArrayList<AttachmentProduct> list){
        Connection conn = getConnection();
        ProductDao pDao = new ProductDao();

        int result1 = pDao.insertProduct(conn, p);
        int result2 = pDao.insertAtachmentList(conn, list);
    }
}
