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
		String string = organizationTypeObj.toString();
		newOrganizationTypeArrayList.add(new OrganizationType(string.substring(1, string.length()-1)));
	}
		 new OrganizationTypeDao().createOrganizationTypeList(newOrganizationTypeArrayList);
	}
	
	public void deleteOrganizationType(Object deleteOrganizationTypeList []) {
		ArrayList<Integer> deleteOrganizationTypeArrayList = new ArrayList<Integer>();
		for(Object id: deleteOrganizationTypeList) {
			deleteOrganizationTypeArrayList.add(Integer.parseInt(id.toString()));
		}	
		 new OrganizationTypeDao().deleteOrganizationTypeList(deleteOrganizationTypeArrayList);
	}
}
