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
	
	public void createStreamList(ArrayList<Stream> newStreamArrayList) {
		 new StreamDao().createStreamList(newStreamArrayList);
	}
	
	public void deleteStreamList(ArrayList<Integer> deleteStreamArrayList) {
		 new StreamDao().deleteStreamList(deleteStreamArrayList);
	}

}
