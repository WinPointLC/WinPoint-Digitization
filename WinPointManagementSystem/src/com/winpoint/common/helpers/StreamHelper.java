package com.winpoint.common.helpers;

import java.util.ArrayList;
import java.util.List;

import com.winpoint.common.beans.Stream;
import com.winpoint.common.dao.StreamDao;

public class StreamHelper {
	public List<Stream> getStreamList(){
		return new StreamDao().getStreamList();
	}
	
	public Integer getStreamId(String streamName) {
		return new StreamDao().getStreamId(streamName);
	}
	
	public void createStreamList(Object[] newStreamList) {
		ArrayList<Stream> newStreamArrayList = new ArrayList<Stream>();
		for(Object object: newStreamList) {
			String string = object.toString();
			newStreamArrayList.add(new Stream(string.substring(1, string.length()-1)));
		}
		 new StreamDao().createStreamList(newStreamArrayList);
	}
	
	public void deleteStreamList(Object[] deleteStreamList) {
		ArrayList<Integer> deleteStreamArrayList = new ArrayList<>();
		for(Object id: deleteStreamList) {
			deleteStreamArrayList.add(Integer.parseInt(id.toString()));
		}
		 new StreamDao().deleteStreamList(deleteStreamArrayList);
	}

}
