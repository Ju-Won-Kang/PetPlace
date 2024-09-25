package com.petplace.admin.model.vo;

/**
 * packageName    : com.petplace.admin.model.vo
 * fileName       : Product
 * author         : jun
 * date           : 2024. 9. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 24.        jun       최초 생성
 */
public class Product {
    private String productNo; // 상품번호
    private int CategoryNo; // 카테고리 번호
    private String company; // 제조사
    private String productTitle; // 상품명
    private int price; // 상품 가격
    private String inventory; // 상품 재고
    private String igredient; // 주원료
    private String origin; // 원산지
    private int productWeight; // 중량
    private int kcal; // 칼로리

    public Product() {
    }

    public Product(String productNo, int categoryNo, String company, String productTitle, int price, String inventory, String igredient, String origin, int productWeight, int kcal) {
        this.productNo = productNo;
        CategoryNo = categoryNo;
        this.company = company;
        this.productTitle = productTitle;
        this.price = price;
        this.inventory = inventory;
        this.igredient = igredient;
        this.origin = origin;
        this.productWeight = productWeight;
        this.kcal = kcal;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public int getCategoryNo() {
        return CategoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        CategoryNo = categoryNo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getIgredient() {
        return igredient;
    }

    public void setIgredient(String igredient) {
        this.igredient = igredient;
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

    @Override
    public String toString() {
        return "Product{" +
                "productNo='" + productNo + '\'' +
                ", CategoryNo=" + CategoryNo +
                ", company='" + company + '\'' +
                ", productTitle='" + productTitle + '\'' +
                ", price=" + price +
                ", inventory='" + inventory + '\'' +
                ", igredient='" + igredient + '\'' +
                ", origin='" + origin + '\'' +
                ", productWeight=" + productWeight +
                ", kcal=" + kcal +
                '}';
    }
}
