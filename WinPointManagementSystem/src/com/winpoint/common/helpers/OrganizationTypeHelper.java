package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.OrganizationType;
import com.winpoint.common.dao.OrganizationTypeDao;

public class OrganizationTypeHelper {

	public List<OrganizationType> getOrganizationTypeList(){
		return new OrganizationTypeDao().getOrganizationTypeList();
	}
	

	//===============================================================================================


public void createOrganizationType(ArrayList<OrganizationType> newOrganizationTypeArrayList) {
		 new OrganizationTypeDao().createOrganizationTypeList(newOrganizationTypeArrayList);
	}
	
	public void deleteOrganizationType(ArrayList<Integer> deleteOrganizationTypeArrayList) {
		 new OrganizationTypeDao().deleteOrganizationTypeList(deleteOrganizationTypeArrayList);
	}
}
