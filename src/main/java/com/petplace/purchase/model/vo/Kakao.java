package com.petplace.purchase.model.vo;

public class Kakao {
	// 필수 파라미터
	private String cid; // 가맹점 코드
    private String partnerOrderId; // 가맹점 주문 번호
    private String partnerUserId; // 가맹점 회원 ID
    private String itemName; // 상품명
    private int quantity; // 상품 수량
    private int totalAmount; // 총 금액
    private int taxFreeAmount; // 비과세 금액
    private String approvalUrl; // 결제 성공 시 이동할 URL
    private String cancelUrl; // 결제 취소 시 이동할 URL
    private String failUrl; // 결제 실패 시 이동할 URL
    
	public Kakao() {
		super();
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getPartnerOrderId() {
		return partnerOrderId;
	}

	public void setPartnerOrderId(String partnerOrderId) {
		this.partnerOrderId = partnerOrderId;
	}

	public String getPartnerUserId() {
		return partnerUserId;
	}

	public void setPartnerUserId(String partnerUserId) {
		this.partnerUserId = partnerUserId;
	}


	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTaxFreeAmount() {
		return taxFreeAmount;
	}

	public void setTaxFreeAmount(int taxFreeAmount) {
		this.taxFreeAmount = taxFreeAmount;
	}

	public String getApprovalUrl() {
		return approvalUrl;
	}

	public void setApprovalUrl(String approvalUrl) {
		this.approvalUrl = approvalUrl;
	}

	public String getCancelUrl() {
		return cancelUrl;
	}

	public void setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
	}

	public String getFailUrl() {
		return failUrl;
	}

	public void setFailUrl(String failUrl) {
		this.failUrl = failUrl;
	}

	@Override
	public String toString() {
	    return "Kakao [cid=" + cid + ", partnerOrderId=" + partnerOrderId + ", partnerUserId=" + partnerUserId
	            + ", itemName=" + itemName + ", quantity=" + quantity + ", totalAmount="
	            + totalAmount + ", taxFreeAmount=" + taxFreeAmount + ", approvalUrl=" + approvalUrl + ", cancelUrl="
	            + cancelUrl + ", failUrl=" + failUrl + "]";
	}

	
}
