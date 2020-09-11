package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.PaymentType;
import com.winpoint.common.dao.PaymentTypeDao;

public class PaymentTypeHelper {

	public List<PaymentType> getPaymentTypeList(){
		return new PaymentTypeDao().getPaymentTypeList();
	}
	//===============================================================================================


public void createPaymentType(Object newPaymentTypeList []) {
		ArrayList<PaymentType>newPaymentTypeArrayList =new ArrayList<>();	
		for(Object paymentTypeObj : newPaymentTypeList) {
		newPaymentTypeArrayList.add(new PaymentType(paymentTypeObj.toString().substring(1, paymentTypeObj.toString().length()-1)));
		}
		 new PaymentTypeDao().createPaymentTypeList(newPaymentTypeArrayList);
	}
	
	public void deletePaymentType(ArrayList<Integer> deletePaymentTypeArrayList) {
		 new PaymentTypeDao().deletePaymentTypeList(deletePaymentTypeArrayList);
	}
	
}
