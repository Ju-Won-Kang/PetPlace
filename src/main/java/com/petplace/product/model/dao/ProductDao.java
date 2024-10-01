package com.petplace.product.model.dao;

import com.petplace.admin.model.dto.Category;
import com.petplace.common.PageInfo;
import com.petplace.product.model.vo.AttachmentProduct;
import com.petplace.product.model.vo.Product;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import static com.petplace.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
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
     *
     * @param conn Connection 객체
     * @return 카테고리 리스트 객체
     */
    public ArrayList<Category> selectCategoryList(SqlSession sqlSession) {
        return (ArrayList) sqlSession.selectList("productMapper.selectCategoryList", null);
    }

    /**
     * 상품 등록
     *
     * @param conn Connection 객체
     * @param p    Request시 Parameter 정보를 담은 Product 객체
     * @return DB에 Insert 결과값
     */
    public int insertProduct(SqlSession sqlSession, Product p) {
        return sqlSession.insert("productMapper.insertProduct", p);
    }

    /**
     * 상품 썸네일, 상품 상세정보 파일 등록
     *
     * @param conn Connection 객체
     * @param list 썸네일, 상품 상세정보 파일 정보를 담은 리스트
     * @return DB에 Insert 결과값
     */
    public int enrollAttachmentList(SqlSession sqlSession, AttachmentProduct at) {
        return sqlSession.insert("productMapper.enrollAttachmentList", at);
    }

    /**
     * 총 상품 개수 조회
     *
     * @param conn
     * @return
     */
    public int selectListCount(SqlSession sqlSession) {
        return sqlSession.selectOne("productMapper.selectListCount");
    }

    /**
     * 페이징 처리를 위한 상품 리스트 조회
     *
     * @param conn
     * @param pi
     * @return
     */
    public ArrayList<Product> selectProductList(SqlSession sqlSession, PageInfo pi) {
        int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
        int limit = pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, limit);
        return (ArrayList) sqlSession.selectList("productMapper.selectProductList", null, rowBounds);
    }

    /**
     * 특정 상품 첨부파일 리스트 조회
     *
     * @param conn
     * @param productNo
     * @return
     */
    public ArrayList<AttachmentProduct> selectAttachment(SqlSession sqlSession, int productNo) {
        return (ArrayList) sqlSession.selectList("productMapper.selectAttachment", productNo);
    }

    /**
     * 특정 상품 정보 조회
     *
     * @param conn
     * @param productNo
     * @return
     */
    public Product selectProduct(SqlSession sqlSession, int productNo) {
        return sqlSession.selectOne("productMapper.selectProduct", productNo);
    }

    /**
     * 상품 정보 수정
     *
     * @param conn
     * @param p    수정한 상품 정보
     * @return
     */
    public int updateProduct(SqlSession sqlSession, Product p) {
        return sqlSession.update("productMapper.updateProduct", p);
    }

    /**
     * 참조하는 상품 첨부파일 전부 삭제
     *
     * @param conn
     * @param productNo
     * @return
     */
    public int deleteAttachmentProduct(SqlSession sqlSession, int productNo) {
        return sqlSession.delete("productMapper.deleteAttachmentProduct", productNo);
    }

    /**
     * 특정 상품번호로 첨부파일 리스트 저장
     *
     * @param conn
     * @param list      첨부파일 리스트
     * @param productNo 참조하는 상품번호
     * @return
     */
    public int insertAttachmentList(SqlSession sqlSession, HashMap<String, Object> map) {
        return sqlSession.insert("productMapper.insertAttachmentList", map);
    }

    /**
     * 상품 STATUS 변경
     *
     * @param conn
     * @param productNo
     * @return
     */
    public int deleteProduct(SqlSession sqlSession, int productNo) {
        return sqlSession.update("productMapper.deleteProduct", productNo);
    }

    /**
     * 참조하는 상품 삭제시 첨부파일 STATUS 변경
     *
     * @param conn
     * @param productNo
     * @return
     */
    public int disableAttachmentProduct(SqlSession sqlSession, int productNo) {
        return sqlSession.update("productMapper.disableAttachmentProduct", productNo);
    }
}