package com.petplace.adopt.model.vo;

import java.sql.Date;

public class AdoptAttachment {
	private int fileNo;
	private int refAno;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private String boardType;
	private String status;
	
	public AdoptAttachment() {
		super();
	}

	public AdoptAttachment(int fileNo, int refAno, String originName, String changeName, String filePath,
			Date uploadDate, String boardType, String status) {
		super();
		this.fileNo = fileNo;
		this.refAno = refAno;
		this.originName = originName;
		this.changeName = changeName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.boardType = boardType;
		this.status = status;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getRefAno() {
		return refAno;
	}

	public void setRefAno(int refAno) {
		this.refAno = refAno;
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

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AdoptAttachment [fileNo=" + fileNo + ", refAno=" + refAno + ", originName=" + originName
				+ ", changeName=" + changeName + ", filePath=" + filePath + ", uploadDate=" + uploadDate
				+ ", boardType=" + boardType + ", status=" + status + "]";
	}
	
	
}
