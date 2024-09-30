package com.petplace.admin.model.dto;

/**
 * packageName    : com.petplace.admin.model.vo
 * fileName       : Category
 * author         : jun
 * date           : 2024. 9. 24.
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 24.        jun       최초 생성
 */
public class Category {
    private String productCategory;

    public Category() {
    }

    public Category(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "productCategory='" + productCategory + '\'' +
                '}';
    }
}
