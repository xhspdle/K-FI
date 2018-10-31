package com.kfi.ldk.util;

import java.util.HashMap;
import java.util.Map;

public class VidUtil {
	private static Map<String, String> vidMap;
	static {
		vidMap=new HashMap<String, String>();
		vidMap.put("AVI", "video/avi");
		vidMap.put("WMV", "video/wmv");
		vidMap.put("MP4", "video/mp4");
	}
	public static String getVidType(String type) {
		return vidMap.get(type.toUpperCase());
	}
}
