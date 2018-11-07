package com.kfi.ldk.myboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.MyBoardVo;

@Controller(value="MyBoardUpdateController")
public class UpdateController {
	@Autowired
	@Qualifier("myBoardServiceImpl") private CommonService service;
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/mypage/myboard/updateModal",method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> updateModal(int mb_num){
		HashMap<String, Object> map=(HashMap<String, Object>)service.select(mb_num);
		return map;
	}
	@RequestMapping(value="/mypage/myboard/update",method=RequestMethod.POST)
	@ResponseBody
	public String update(MultipartHttpServletRequest request,String[] tages,
				MultipartFile[] fileP,MultipartFile[] fileV,HttpSession session) {
		int mb_num=0;
		String mbNum=request.getParameter("mb_num");
		if(mbNum!=null && mbNum!="") {
			mb_num=Integer.parseInt(mbNum);
		}
		String mb_title=request.getParameter("mb_title");
		String mb_content=request.getParameter("mb_content");
		try {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("session", session);
			map.put("fileP", fileP);
			map.put("fileV", fileV);
			int user_num=0;
			Object session_num=session.getAttribute("user_num");
			if(session_num!=null && session_num!="") {
				user_num=(Integer)session_num;
			}
			map.put("mbVo", new MyBoardVo(mb_num, user_num, mb_title, mb_content, null, 0));
			int n=service.update(map);
			if(n>0) {
				return "Edit Success";
			}else {
				return "Edit Failed";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
