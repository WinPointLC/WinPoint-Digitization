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

	public Integer getOrganizationTypeId() {
		return paymentTypeId;
	}

	public void setOrganizationTypeId(Integer paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public String getOrganizationTypeName() {
		return paymentTypeName;
	}

	public void setOrganizationTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}
	
}
