package com.winpoint.common.helpers;

import java.util.List;

import com.winpoint.common.beans.OrganizationType;
import com.winpoint.common.dao.OrganizationTypeDao;

public class OrganizationTypeHelper {

	public List<OrganizationType> getOrganizationTypeList(){
		return new OrganizationTypeDao().getOrganizationTypeList();
	}
	
}
