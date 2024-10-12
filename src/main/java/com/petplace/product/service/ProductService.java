package com.petplace.product.service;

import com.petplace.admin.model.dto.Category;

import static com.petplace.common.JDBCTemplate.*;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.product.model.dao.ProductDao;
import com.petplace.product.model.vo.AttachmentProduct;
import com.petplace.product.model.vo.Product;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

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
    /**
     * 현재 등록된 카테고리 리스트를 조회하는 메서드
     *
     * @return 조회된 카테고리 리스트
     */
    public ArrayList<Category> selectCategoryList() {
        SqlSession sqlSession = Template.getSqlSession();
        ArrayList<Category> cList = new ProductDao().selectCategoryList(sqlSession);
        sqlSession.close();
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
        SqlSession sqlSession = Template.getSqlSession();
        ProductDao pDao = new ProductDao();

        int result1 = pDao.insertProduct(sqlSession, p);
        int result2 = 1;
        for (AttachmentProduct at : list) {
            result2 *= pDao.enrollAttachmentList(sqlSession, at);
        }
        System.out.println(result2);
        if (result1 > 0 && result2 > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result1 * result2;

    }

    /**
     * 총게시글 개수 반환
     *
     * @return listCount
     */
    public int selectListCount() {
        int listCount = 0;
        SqlSession sqlSession = Template.getSqlSession();
        listCount = new ProductDao().selectListCount(sqlSession);
        sqlSession.close();
        return listCount;
    }

    /**
     * 페이징 처리를 위한 상품목록 조회
     *
     * @param pi 페이징처리용 객체
     * @return Product 리스트
     */
    public ArrayList<Product> selectProductList(PageInfo pi) {
        SqlSession sqlSession = Template.getSqlSession();
        ArrayList<Product> pList = new ProductDao().selectProductList(sqlSession, pi);
        sqlSession.close();
        return pList;
    }

    /**
     * 특정 상품번호에 해당하는 상품 첨부파일 리스트 조회
     *
     * @param productNo 조회하고자하는 상품번호
     * @return AttachmentProduct 객체
     */
    public ArrayList<AttachmentProduct> selectAttachment(int productNo) {
        SqlSession sqlSession = Template.getSqlSession();
        ArrayList<AttachmentProduct> atList = new ProductDao().selectAttachment(sqlSession, productNo);
        sqlSession.close();

        return atList;
    }

    /**
     * 특정 상품번호에 해당하는 상품 정보 조회
     *
     * @param productNo 조회하고자하는 상품번호
     * @return Product객체
     */
    public Product selectProduct(int productNo) {
        SqlSession sqlSession = Template.getSqlSession();
        Product p = new ProductDao().selectProduct(sqlSession, productNo);
        System.out.println(productNo);
        System.out.println(p);
        sqlSession.close();
        return p;
    }

    /**
     * 상품 Update, 첨부파일 삭제 & 입력
     *
     * @param p    수정 데이터가 있는 Product객체
     * @param list 첨부파일 리스트
     * @return 트랜잭션 처리 결과 값
     */
    public int updateProduct(Product p, ArrayList<AttachmentProduct> list) {
        SqlSession sqlSession = Template.getSqlSession();
        int result1 = new ProductDao().updateProduct(sqlSession, p);
        int result2 = 0;
        int result3 = 1;

        if (result1 > 0) {
            result2 = new ProductDao().deleteAttachmentProduct(sqlSession, p.getProductNo());
            for (AttachmentProduct at : list) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("refPNo", p.getProductNo());
                map.put("originName", at.getOriginName());
                map.put("changeName", at.getChangeName());
                map.put("filePath", at.getFilePath());
                map.put("fileLevel", at.getFileLevel());
                result3 *= new ProductDao().insertAttachmentList(sqlSession, map);
            }

            if (result2 > 0 && result3 > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);

        // 모든 결과값이 성공해야 반환
        return result1 * result2 * result3;
    }

    /**
     * 상품 Delete, 첨부파일 Delete(Update로 STATUS = 'N'으로 변경)
     *
     * @param productNo 삭제하고자하는 상품 번호
     * @return
     */
    public int deleteProduct(int productNo) {
        SqlSession sqlSession = Template.getSqlSession();

        int result1 = new ProductDao().deleteProduct(sqlSession, productNo);

        int result2 = 0;
        if (result1 > 0) {
            result2 = new ProductDao().disableAttachmentProduct(sqlSession, productNo);
            if (result2 > 0) {
                sqlSession.commit();
            }
        } else {
            sqlSession.rollback();
        }
        System.out.println("삭제할 상품 번호 : " + productNo);
        System.out.println("상품 삭제 result1 : " + result1);
        System.out.println("상품 삭제 result2 : " + result2);
        return result1 * result2;
    }
}
