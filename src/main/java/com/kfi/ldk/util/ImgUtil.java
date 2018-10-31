package com.kfi.ldk.util;

import java.util.HashMap;
import java.util.Map;

public class ImgUtil {
	private static Map<String, String> imgMap;
	static {
		imgMap=new HashMap<String, String>();
		imgMap.put("JPG", "image/jpg");
		imgMap.put("JPEG", "image/jpeg");
		imgMap.put("GIF", "image/gif");
		imgMap.put("PNG", "image/png");
	}
	public static String getImgType(String type) {
		return imgMap.get(type.toUpperCase());
	}
}
