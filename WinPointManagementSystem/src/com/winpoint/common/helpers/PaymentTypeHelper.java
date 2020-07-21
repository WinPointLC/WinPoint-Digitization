package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.PaymentType;
import com.winpoint.common.dao.PaymentTypeDao;

public class PaymentTypeHelper {

	public List<PaymentType> getPaymentTypeDaoList(){
		return new PaymentTypeDao().getPaymentTypeDaoList();
	}

	
}
