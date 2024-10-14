package com.petplace.purchase.service;

import com.petplace.common.PageInfo;
import com.petplace.common.Template;
import com.petplace.purchase.model.dao.PurchaseDao;
import com.petplace.purchase.model.dto.PurchaseList;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * packageName    : com.petplace.purchase.service
 * fileName       : PurchaseServiceImpl
 * author         : jun
 * date           : 2024. 9. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 30.        jun       최초 생성
 */
public class PurchaseServiceImpl implements PurchaseService{
    @Override
    public int selectPurchaseListCount() {
        SqlSession sqlSession = Template.getSqlSession();
        int result = new PurchaseDao().selectPurchaseListCount(sqlSession);
        sqlSession.close();
        return result;
    }

    @Override
    public ArrayList<PurchaseList> selectPurchaseList(PageInfo pi) {
        SqlSession sqlSession = Template.getSqlSession();
        ArrayList<PurchaseList> pList = new PurchaseDao().selectPurchaseList(sqlSession, pi);
        return pList;
    }

    @Override
    public int insertWayBill(int purchaseNo, String wayBill) {
        SqlSession sqlSession = Template.getSqlSession();
        HashMap<String, Object> map = new HashMap<>();

        map.put("purchaseNo", purchaseNo);
        map.put("wayBill", wayBill);

        int result = new PurchaseDao().insertWayBill(sqlSession, map);
        if (result > 0) {
            sqlSession.commit();
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;
    }


	
	
}
