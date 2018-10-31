/*
package com.kfi.ldk.myboard.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.MyBoardVo;

@Controller(value="MyBoardInsertController")
public class InsertController {
	@Autowired
	@Qualifier("myBoardServiceImpl") private CommonService service;
	@RequestMapping(value="/mypage/myboard/insert",method=RequestMethod.GET)
	public String insertForm() {
		return ".mypage.myboard.insert";
	}
	@RequestMapping(value="/mypage/myboard/insert",method=RequestMethod.POST)
	public ResponseEntity<Object> insert(MultipartHttpServletRequest request,String[] tags,
				MultipartFile[] fileP,MultipartFile[] fileV,HttpSession session) {
		String mb_title=request.getParameter("mb_title");
		String mb_content=request.getParameter("mb_content");
		ResponseEntity<Object> entity=null;
		try {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("session", session);
			map.put("fileP", fileP);
			map.put("fileV", fileV);
			map.put("mbVo", new MyBoardVo(0, 1, mb_title, mb_content, null, 0));	
			//유저 가입, 로그인 미구현인관계로 유저넘버1번으로 테스트
			long totalSize=0;
			for(int i=0;i<fileP.length;i++) {
				totalSize+=fileP[i].getSize();
			}
			for(int i=0;i<fileV.length;i++) {
				totalSize+=fileV[i].getSize();
			}
			int copyProgress=service.insert(map);
			if(totalSize!=0) {
				return entity=new ResponseEntity<Object>(copyProgress/(double)totalSize, HttpStatus.OK);				
			}else {
				return entity=new ResponseEntity<Object>(copyProgress, HttpStatus.OK);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
*/