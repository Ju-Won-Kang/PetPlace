package com.petplace.product.service;

import com.petplace.admin.model.dto.Category;

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

    /**
     * 상품 등록 & 상품 썸네일, 상품 상세정보 파일 DB에 저장하는 메서드
     * @param p Request시 Parameter 정보를 담은 Product 객체
     * @param list 썸네일, 상품 상세정보 파일 정보를 담은 리스트
     * @return DB에서 Product 테이블, Attachment_product 테이블에 Insert한 결과값
     */
    public int CreateProduct(Product p, ArrayList<AttachmentProduct> list){
        Connection conn = getConnection();
        ProductDao pDao = new ProductDao();

        int result1 = pDao.insertProduct(conn, p);
        int result2 = pDao.insertAttachmentList(conn, list);

        if (result1 > 0 &&result2>0){
            commit(conn);
        }else {
            rollback(conn);
        }
        close(conn);
        return result1 * result2;

    }
}
