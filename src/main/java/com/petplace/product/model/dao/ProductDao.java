package com.petplace.product.model.dao;

import com.petplace.admin.model.dto.Category;
import com.petplace.common.PageInfo;
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
     *
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
     *
     * @param conn Connection 객체
     * @param p    Request시 Parameter 정보를 담은 Product 객체
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
     *
     * @param conn Connection 객체
     * @param list 썸네일, 상품 상세정보 파일 정보를 담은 리스트
     * @return DB에 Insert 결과값
     */
    public int enrollAttachmentList(Connection conn, ArrayList<AttachmentProduct> list) {
        int result = 1;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("enrollAttachmentList");

        try {
            for (AttachmentProduct atP : list) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, atP.getOriginName());
                pstmt.setString(2, atP.getChangeName());
                pstmt.setString(3, atP.getFilePath());
                pstmt.setInt(4, atP.getFileLevel());
                result *= pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    /**
     * 총 상품 개수 조회
     *
     * @param conn
     * @return
     */
    public int selectListCount(Connection conn) {
        int listCount = 0;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectListCount");

        try {
            pstmt = conn.prepareStatement(sql);

            rset = pstmt.executeQuery();
            if (rset.next()) {
                listCount = rset.getInt("COUNT");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }
        return listCount;
    }

    /**
     * 페이징 처리를 위한 상품 리스트 조회
     *
     * @param conn
     * @param pi
     * @return
     */
    public ArrayList<Product> selectProductList(Connection conn, PageInfo pi) {
        ArrayList<Product> pList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectProductList");
        int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
        int endRow = startRow + pi.getBoardLimit() - 1;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, startRow);
            pstmt.setInt(2, endRow);

            rset = pstmt.executeQuery();

            while (rset.next()) {
                pList.add(new Product(
                        rset.getString("PRODUCT_NO"),
                        rset.getString("PRODUCT_CATEGORY"),
                        rset.getString("COMPANY"),
                        rset.getString("PRODUCT_NAME"),
                        rset.getInt("PRICE"),
                        rset.getInt("INVENTORY"),
                        rset.getString("INGREDIENT"),
                        rset.getString("ORIGIN"),
                        rset.getInt("PRODUCT_WEIGHT"),
                        rset.getInt("KCAL"),
                        rset.getString("ENROLL_DATE"),
                        rset.getString("MODIFY_DATE")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }
        return pList;
    }

    /**
     * 특정 상품 첨부파일 리스트 조회
     *
     * @param conn
     * @param productNo
     * @return
     */
    public ArrayList<AttachmentProduct> selectAttachment(Connection conn, String productNo) {
        ArrayList<AttachmentProduct> atList = new ArrayList<>();
//        HashMap<String, ModifyProduct> productMap = new HashMap<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectAttachment");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productNo);

            rset = pstmt.executeQuery();

            while (rset.next()) {
                atList.add(new AttachmentProduct(
                        rset.getString("FILE_NO"),
                        rset.getString("REF_PNO"),
                        rset.getString("ORIGIN_NAME"),
                        rset.getString("CHANGE_NAME"),
                        rset.getString("FILE_PATH"),
                        rset.getString("UPLOAD_DATE"),
                        rset.getInt("FILE_LEVEL")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }
        System.out.println(atList);
        return atList;
    }

    /**
     * 특정 상품 정보 조회
     *
     * @param conn
     * @param productNo
     * @return
     */
    public Product selectProduct(Connection conn, String productNo) {
        Product p = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectProduct");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productNo);
            rset = pstmt.executeQuery();

            if (rset.next()) {
                p = new Product(
                        rset.getString("PRODUCT_NO"),
                        rset.getString("PRODUCT_CATEGORY"),
                        rset.getString("COMPANY"),
                        rset.getString("PRODUCT_NAME"),
                        rset.getInt("PRICE"),
                        rset.getInt("INVENTORY"),
                        rset.getString("INGREDIENT"),
                        rset.getString("ORIGIN"),
                        rset.getInt("PRODUCT_WEIGHT"),
                        rset.getInt("KCAL"),
                        rset.getString("ENROLL_DATE"),
                        rset.getString("MODIFY_DATE")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(rset);
            close(pstmt);
        }
        return p;
    }

    /**
     * 상품 정보 수정
     *
     * @param conn
     * @param p    수정한 상품 정보
     * @return
     */
    public int updateProduct(Connection conn, Product p) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("updateProduct");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getCompany());
            pstmt.setInt(2, p.getPrice());
            pstmt.setInt(3, p.getInventory());
            pstmt.setString(4, p.getIngredient());
            pstmt.setString(5, p.getOrigin());
            pstmt.setInt(6, p.getProductWeight());
            pstmt.setInt(7, p.getKcal());
            pstmt.setString(8, p.getProductNo());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    /**
     * 참조하는 상품 첨부파일 전부 삭제
     *
     * @param conn
     * @param productNo
     * @return
     */
    public int deleteAttachmentProduct(Connection conn, String productNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteAttachmentProduct");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, productNo);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    /**
     * 특정 상품번호로 첨부파일 리스트 저장
     *
     * @param conn
     * @param list      첨부파일 리스트
     * @param productNo 참조하는 상품번호
     * @return
     */
    public int insertAttachmentList(Connection conn, ArrayList<AttachmentProduct> list, String productNo) {
        int result = 1;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("insertAttachmentList");

        try {
            for (AttachmentProduct atP : list) {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, productNo);
                pstmt.setString(2, atP.getOriginName());
                pstmt.setString(3, atP.getChangeName());
                pstmt.setString(4, atP.getFilePath());
                pstmt.setInt(5, atP.getFileLevel());
                result *= pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int deleteProduct(Connection conn, String productNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteProduct");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,productNo);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int disableAttachmentProduct(Connection conn, String productNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("deleteAttachmentProduct");

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,productNo);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }
}