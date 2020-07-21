package com.winpoint.common.helpers;

import java.util.Iterator;
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
}
