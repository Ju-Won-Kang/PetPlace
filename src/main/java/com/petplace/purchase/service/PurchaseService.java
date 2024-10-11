package com.petplace.purchase.service;

import com.petplace.common.PageInfo;
import com.petplace.purchase.model.dto.PurchaseList;

import java.util.ArrayList;

/**
 * packageName    : com.petplace.purchase.service
 * fileName       : PurchaseService
 * author         : jun
 * date           : 2024. 9. 30.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 30.        jun       최초 생성
 */
public interface PurchaseService {
    int selectPurchaseListCount();

    ArrayList<PurchaseList> selectPurchaseList(PageInfo pi);

    int insertWayBill(int purchaseNo, String wayBill);
    

}
