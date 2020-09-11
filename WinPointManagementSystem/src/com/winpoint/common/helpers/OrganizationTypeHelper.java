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


public void createOrganizationType(Object newOrganizationTypeList []) {
	ArrayList<OrganizationType>newOrganizationTypeArrayList =new ArrayList<>();	
	for(Object organizationTypeObj : newOrganizationTypeList) {
		newOrganizationTypeArrayList.add(new OrganizationType(organizationTypeObj.toString().substring(1, organizationTypeObj.toString().length()-1)));
	}
		 new OrganizationTypeDao().createOrganizationTypeList(newOrganizationTypeArrayList);
	}
	
	public void deleteOrganizationType(ArrayList<Integer> deleteOrganizationTypeArrayList) {
		 new OrganizationTypeDao().deleteOrganizationTypeList(deleteOrganizationTypeArrayList);
	}
}
