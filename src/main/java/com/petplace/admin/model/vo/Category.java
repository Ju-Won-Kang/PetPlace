package com.petplace.admin.model.vo;

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
    private String categoryNo;
    private String categoryName;

    public Category() {
    }

    public Category(String categoryNo, String categoryName) {
        this.categoryNo = categoryNo;
        this.categoryName = categoryName;
    }

    public String getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(String categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryNo='" + categoryNo + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
