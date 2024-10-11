package com.petplace.purchase.model.dao;

import com.petplace.common.PageInfo;
import com.petplace.purchase.model.dto.PurchaseList;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * packageName    : com.petplace.purchase.model.dao
 * fileName       : PurchaseDao
 * author         : jun
 * date           : 2024. 9. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 30.        jun       최초 생성
 */
public class PurchaseDao {
    public int selectPurchaseListCount(SqlSession sqlSession){
        return sqlSession.selectOne("purchaseMapper.selectPurchaseListCount");
    }

    public ArrayList<PurchaseList> selectPurchaseList(SqlSession sqlSession, PageInfo pi){
        int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
        int limit = pi.getBoardLimit();
        RowBounds rowBounds = new RowBounds(offset, limit);
        System.out.println("구매 리스트 : " + (ArrayList) sqlSession.selectList("purchaseMapper.selectPurchaseList", null, rowBounds));
        return (ArrayList) sqlSession.selectList("purchaseMapper.selectPurchaseList", null, rowBounds);
    }
    public int insertWayBill(SqlSession sqlSession, HashMap<String, Object> map){
        return sqlSession.update("purchaseMapper.insertWayBill", map);
    }
   
    
}
