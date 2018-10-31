package com.kfi.ldk.service;

import java.util.List;

public interface CommonViewService {
	int getMaxNum();
	int getCount(Object data);
	Object select(Object data);
	List<Object> list(Object data);
}
