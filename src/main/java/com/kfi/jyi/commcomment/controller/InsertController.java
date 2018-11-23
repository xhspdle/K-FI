package com.kfi.jyi.commcomment.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.ldk.service.CommonService;

@Controller(value="commCommentInsertController")
public class InsertController {

	@Autowired
	@Qualifier("commCommentServiceImpl") private CommonService service;
	
	@Autowired
	@Qualifier("commCommentLikeServiceImpl") private CommonService commentLikeService;
	
	
	@RequestMapping(value="/commcomment/insert", method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> insert(String commc_content, String cb_num, HttpSession session) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		int cbNum=0;
		if(cb_num!=null && !cb_num.equals("")) {
			cbNum=Integer.parseInt(cb_num);
		}
		map.put("cb_num", cbNum);
		map.put("commc_content", commc_content);
		int result=service.insert(map);
		HashMap<String, Object> resultMap=new HashMap<>();
		resultMap.put("result", result);
		return resultMap;
	}
	
	/*@RequestMapping(value="/commcomment/insert",produces="application/json;charset=utf-8")
	@ResponseBody
	public String insert(String commc_content, String cb_num, HttpSession session) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		int cbNum=0;
		if(cb_num!=null && !cb_num.equals("")) {
			cbNum=Integer.parseInt(cb_num);
		}
		map.put("cb_num", cbNum);
		map.put("commc_content", commc_content);
		int result=service.insert(map);
		JSONObject json=new JSONObject();
		json.append("result", result);
		return json.toString();
	}*/
	
	
	
	//댓글 좋아요 등록, 취소	
	@RequestMapping(value="/communityBoard/commCommentLike/insert", method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> insertLike(String commc_num, HttpSession session) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("session", session);
		int commcNum=0;
		if(commc_num!=null && !commc_num.equals("")) {
			commcNum=Integer.parseInt(commc_num);
		}
		map.put("commc_num", commcNum);
		int result=commentLikeService.insert(map);
		
		
		HashMap<String, Object> resultMap=new HashMap<>();
		resultMap.put("result", result);
		
		int commentLikeCnt=commentLikeService.getCount(commcNum);
		resultMap.put("commentLikeCnt", commentLikeCnt);
		
		return resultMap;
	}
	
	
}
