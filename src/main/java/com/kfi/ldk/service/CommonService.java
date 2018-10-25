package com.kfi.ldk.service;

import java.util.List;

public interface CommonService {
	int getMaxNum();
	int getCount(Object data);
	int insert(Object data);
	int update(Object data);
	int delete(Object data);
	Object select(Object data);
	List<Object> list(Object data);
}
