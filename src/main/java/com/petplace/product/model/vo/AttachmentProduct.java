package com.petplace.product.model.vo;

/**
 * packageName    : com.petplace.product.model.vo
 * fileName       : Attachment
 * author         : jun
 * date           : 2024. 9. 25.
 * description    : ATTACHMENT Table
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024. 9. 25.        jun       최초 생성
 */
public class AttachmentProduct {
    private String fileNo;
    private String refPNo;
    private String originName;
    private String changeName;
    private String filePath;
    private String uploadDate;
    private int fileLevel;
    private String status;

    public AttachmentProduct() {
    }

    public AttachmentProduct(String fileNo, String originName, String changeName, String filePath, int fileLevel) {
        this.fileNo = fileNo;
        this.originName = originName;
        this.changeName = changeName;
        this.filePath = filePath;
        this.fileLevel = fileLevel;
    }

    public AttachmentProduct(String fileNo, String refPNo, String originName, String changeName, String filePath, String uploadDate, int fileLevel, String status) {
        this.fileNo = fileNo;
        this.refPNo = refPNo;
        this.originName = originName;
        this.changeName = changeName;
        this.filePath = filePath;
        this.uploadDate = uploadDate;
        this.fileLevel = fileLevel;
        this.status = status;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public String getRefPNo() {
        return refPNo;
    }

    public void setRefPNo(String refPNo) {
        this.refPNo = refPNo;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getChangeName() {
        return changeName;
    }

    public void setChangeName(String changeName) {
        this.changeName = changeName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getFileLevel() {
        return fileLevel;
    }

    public void setFileLevel(int fileLevel) {
        this.fileLevel = fileLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "fileNo='" + fileNo + '\'' +
                ", refPNo='" + refPNo + '\'' +
                ", originName='" + originName + '\'' +
                ", changeName='" + changeName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", uploadDate=" + uploadDate +
                ", fileLevel=" + fileLevel +
                ", status='" + status + '\'' +
                '}';
    }
}
