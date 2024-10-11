package com.petplace.shopping.model.dto;

public class PurchaseCode {
	private int purchaseCode;

	public PurchaseCode(int purchaseCode) {
		super();
		this.purchaseCode = purchaseCode;
	}

	public PurchaseCode() {
		super();
	}

	public int getPurchaseCode() {
		return purchaseCode;
	}

	public void setPurchaseCode(int purchaseCode) {
		this.purchaseCode = purchaseCode;
	}

	@Override
	public String toString() {
		return "PurchaseCode [purchaseCode=" + purchaseCode + "]";
	}


	
	

}
