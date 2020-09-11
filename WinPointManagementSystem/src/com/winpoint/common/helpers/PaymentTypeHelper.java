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
			String string  = paymentTypeObj.toString();
		newPaymentTypeArrayList.add(new PaymentType(string.substring(1, string.length()-1)));
		}
		 new PaymentTypeDao().createPaymentTypeList(newPaymentTypeArrayList);
	}
	
	public void deletePaymentType(Object deletePaymentTypeList []) {
		ArrayList<Integer> deletePaymentTypeArrayList = new ArrayList<Integer>();
		for(Object id: deletePaymentTypeList) {
			deletePaymentTypeArrayList.add(Integer.parseInt(id.toString()));
		}	
		 new PaymentTypeDao().deletePaymentTypeList(deletePaymentTypeArrayList);
	}
	
}
