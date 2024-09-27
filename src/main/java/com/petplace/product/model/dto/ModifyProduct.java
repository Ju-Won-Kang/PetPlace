package com.petplace.product.model.dto;

import com.petplace.product.model.vo.AttachmentProduct;

import java.util.ArrayList;

/**
 *packageName    : com.petplace.product.model.dto
 * fileName       : ModifyProduct
 * author         : jun
 * date           : 2024. 9. 27.
 * description    : 수정하기 위한 상품 정보를 가져올때 사용하는 객체
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 27.        jun       최초 생성
 */public class ModifyProduct {
    private String productNo;           // 상품 번호
    private String productCategory;     // 카테고리
    private String company;             // 제조사
    private String productName;         // 상품명
    private int price;                  // 가격
    private int inventory;              // 재고 수량
    private String ingredient;          // 주원료
    private String origin;              // 원산지
    private int productWeight;          // 중량
    private int kcal;                   // 칼로리
    private String enrollDate;          // 등록 날짜
    private String modifyDate;          // 수정 날짜
    private ArrayList<AttachmentProduct> attachmentList;  // 첨부파일 리스트

    public ModifyProduct() {
    }

    public ModifyProduct(String productNo, String productCategory, String company, String productName, int price, int inventory, String ingredient, String origin, int productWeight, int kcal, String enrollDate, String modifyDate, ArrayList<AttachmentProduct> attachmentList) {
        this.productNo = productNo;
        this.productCategory = productCategory;
        this.company = company;
        this.productName = productName;
        this.price = price;
        this.inventory = inventory;
        this.ingredient = ingredient;
        this.origin = origin;
        this.productWeight = productWeight;
        this.kcal = kcal;
        this.enrollDate = enrollDate;
        this.modifyDate = modifyDate;
        this.attachmentList = attachmentList;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public ArrayList<AttachmentProduct> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(ArrayList<AttachmentProduct> attachmentList) {
        this.attachmentList = attachmentList;
    }

    @Override
    public String toString() {
        return "ModifyProduct{" +
                "productNo='" + productNo + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", company='" + company + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", ingredient='" + ingredient + '\'' +
                ", origin='" + origin + '\'' +
                ", productWeight=" + productWeight +
                ", kcal=" + kcal +
                ", enrollDate='" + enrollDate + '\'' +
                ", modifyDate='" + modifyDate + '\'' +
                ", attachmentList=" + attachmentList +
                '}';
    }
}
