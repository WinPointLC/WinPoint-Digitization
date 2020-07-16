package com.winpoint.common.beans;
/**
 * @author Abhishek Dixit
 *
 */
public class PaymentType {

	private Integer paymentTypeId;
	private String paymentTypeName;
	
	/**
	 * @param segmentTypeId;
	 * @param segmentTypeName; 
	 */
	public PaymentType(Integer paymentTypeId, String paymentTypeName) {
		super();
		this.paymentTypeId = paymentTypeId;
		this.paymentTypeName = paymentTypeName;
	}

	public Integer getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getPaymentTypeName() {
		return paymentTypeName;
	}

	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}
	
}
