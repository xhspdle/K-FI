package com.kfi.ldk.service;

public interface CommonService {
	int getMaxNum();
	int getCount(Object data);
	int insert(Object data);
	int update(Object data);
	int delete(Object data);
	Object select(Object data);
	Object list(Object data);
}
