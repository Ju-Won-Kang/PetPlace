package com.petplace.product.service;

import com.petplace.admin.model.dto.Category;

import static com.petplace.common.JDBCTemplate.*;

import com.petplace.common.PageInfo;
import com.petplace.product.model.dao.ProductDao;
import com.petplace.product.model.vo.AttachmentProduct;
import com.petplace.product.model.vo.Product;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    public ArrayList<Category> selectCategoryList() {
        Connection conn = getConnection();
        ArrayList<Category> cList = new ProductDao().selectCategoryList(conn);
        close(conn);
        return cList;
    }

    /**
     * 상품 등록 & 상품 썸네일, 상품 상세정보 파일 DB에 저장하는 메서드
     *
     * @param p    Request시 Parameter 정보를 담은 Product 객체
     * @param list 썸네일, 상품 상세정보 파일 정보를 담은 리스트
     * @return DB에서 Product 테이블, Attachment_product 테이블에 Insert한 결과값
     */
    public int CreateProduct(Product p, ArrayList<AttachmentProduct> list) {
        Connection conn = getConnection();
        ProductDao pDao = new ProductDao();

        int result1 = pDao.insertProduct(conn, p);
        int result2 = pDao.enrollAttachmentList(conn, list);

        if (result1 > 0 && result2 > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
        return result1 * result2;

    }

    public int selectListCount() {
        int listCount = 0;
        Connection conn = getConnection();

        listCount = new ProductDao().selectListCount(conn);

        close(conn);
        return listCount;
    }

    public ArrayList<Product> selectProductList(PageInfo pi) {
        Connection conn = getConnection();
        ArrayList<Product> pList = new ProductDao().selectProductList(conn, pi);

        close(conn);
        return pList;
    }

    public ArrayList<AttachmentProduct> selectAttachment(String productNo) {
        Connection conn = getConnection();
        ArrayList<AttachmentProduct> atList = new ProductDao().selectAttachment(conn, productNo);

        close(conn);
        return atList;
    }

    public Product selectProduct(String productNo) {
        Connection conn = getConnection();
        Product p = new ProductDao().selectProduct(conn, productNo);

        close(conn);
        return p;
    }

    public int updateProduct(Product p, ArrayList<AttachmentProduct> list) {
        Connection conn = getConnection();
        int result1 = new ProductDao().updateProduct(conn, p);
        int result2 = 0;
        int result3 = 0;

        if (result1 > 0) {
            result2 = new ProductDao().deleteAttachmentProduct(conn, p.getProductNo());
            result3 = new ProductDao().insertAttachmentList(conn, list, p.getProductNo());

            if (result2 > 0 && result3 > 0) {
                commit(conn);
            } else {
                rollback(conn);
            }
        } else {
            rollback(conn);
        }
        close(conn);

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);

        // 모든 결과값이 성공해야 반환
        return result1 * result2 * result3;
    }

}
