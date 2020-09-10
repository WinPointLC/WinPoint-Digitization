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


public void createPaymentType(ArrayList<PaymentType> newPaymentTypeArrayList) {
		 new PaymentTypeDao().createPaymentTypeList(newPaymentTypeArrayList);
	}
	
	public void deletePaymentType(ArrayList<Integer> deletePaymentTypeArrayList) {
		 new PaymentTypeDao().deletePaymentTypeList(deletePaymentTypeArrayList);
	}
	
}
