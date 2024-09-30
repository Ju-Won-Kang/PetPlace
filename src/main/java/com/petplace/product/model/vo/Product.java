package com.petplace.product.model.vo;

/**
 * packageName    : com.petplace.product.model.vo
 * fileName       : Product
 * author         : jun
 * date           : 2024. 9. 25.
 * description    : PRODUCT Table
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 25.        jun       최초 생성
 */
public class Product {
    private String productNo;           // 상품번호
    private String productCategory;    // 상품카테고리명
    private String company;             // 제조사
    private String productName;         // 상품명
    private int price;                  // 가격
    private int inventory;              // 상품재고수량
    private String ingredient;          // 주원료
    private String origin;              // 원산지
    private int productWeight;          // 중량
    private int kcal;                   // 칼로리
<<<<<<< HEAD
    private Date enrollDate;            // 등록날짜
    private Date modifyDate;            // 수정날짜
=======
    private String enrollDate;            // 등록날짜
    private String modifyDate;            // 수정날짜
>>>>>>> 79eab4cb28163d2b998f415142f23b834e28a983
    private String status;              // 상태

    public Product() {
    }

    public Product(String productNo, String product_category, String company, String productName, int price, int inventory, String ingredient, String origin, int productWeight, int kcal, String enrollDate, String modifyDate, String status) {
        this.productNo = productNo;
        this.productCategory = product_category;
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
        this.status = status;
    }

    public Product(String productNo, String productCategory, String company, String productName, int price, int inventory, String ingredient, String origin, int productWeight, int kcal, String enrollDate, String modifyDate) {
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
    }

    public Product(String product_category, String company, String productName, int price, int inventory, String ingredient, String origin, int productWeight, int kcal, String enrollDate, String modifyDate, String status) {
        this.productCategory = product_category;
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
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNo='" + productNo + '\'' +
                ", product_category='" + productCategory + '\'' +
                ", company='" + company + '\'' +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", ingredient='" + ingredient + '\'' +
                ", origin='" + origin + '\'' +
                ", productWeight=" + productWeight +
                ", kcal=" + kcal +
                ", enrollDate=" + enrollDate +
                ", modifyDate=" + modifyDate +
                ", status='" + status + '\'' +
                '}';
    }
}
