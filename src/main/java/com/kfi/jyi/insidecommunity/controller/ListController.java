package com.kfi.jyi.insidecommunity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.dgl.service.MembersService;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.vo.CommBoardLikeVo;
import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.jyi.vo.CommVideoVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.TagVo;

@Controller("insideCommunityListController")
public class ListController {
	@Autowired 
	@Qualifier("commBoardServiceImpl") private CommonService commBoardservice;

	@Autowired 
	@Qualifier("insideCommunityServiceImpl") private CommonService insideCommService;
	
	@Autowired
	@Qualifier("mySkinServiceImpl")
	private CommonService mySkinService;
	
	@Autowired
	private MembersService membersSerivce;
	
	// model attribute annotation - 프로필, 커버 사진 넣기

	// 가입한 유저인지, 강퇴당한 유저인지 확인하기 
	
	
	
	//해당 커뮤니티의 선택한 게시물 불러오기
	@RequestMapping(value="/community/board/select",method=RequestMethod.GET)
	public String selectCommBoard(HttpSession session,String cb_num, Model model) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", "select");
		map.put("session", session);
		map.put("cb_num", Integer.parseInt(cb_num));
		
		HashMap<String, Object> result =(HashMap<String, Object>)commBoardservice.select(map);
		model.addAttribute("cbvo", (CommBoardVo)result.get("cbvo")); //게시글
		model.addAttribute("imgList", (List<CommPhotoVo>)result.get("imgList")); //게시글 사진
		model.addAttribute("vidList", (List<CommVideoVo>)result.get("vidList")); //게시글 비디오
		model.addAttribute("cblList", (List<CommBoardLikeVo>)result.get("cblList")); //게시글 추천
		model.addAttribute("msvList", (List<MySkinViewVo>)result.get("msvList")); //게시글 작성자, 추천 유저 skin view
		model.addAttribute("vo", (MembersVo)result.get("vo")); //작성자 회원 정보
		model.addAttribute("writervo", (MySkinViewVo)result.get("writervo")); //게시글 작성자 skin view
		model.addAttribute("likeNum", (Integer)result.get("likeNum"));  //추천수
		model.addAttribute("tagList", (List<TagVo>)result.get("tagList"));  //태그리스트
		model.addAttribute("commentCnt", (Integer)result.get("commentCnt"));  //댓글 수
		
		
		return ".community.board.select";
	}
	
}
