package com.kfi.jyi.commboard.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.jyi.vo.CommBoardCntVo;
import com.kfi.jyi.vo.CommBoardProfileVo;
import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.jyi.vo.CommVideoVo;
import com.kfi.ldk.service.CommonService;

@Controller(value = "commBoardListController")
public class ListController {

	@Autowired
	@Qualifier("commBoardServiceImpl")
	private CommonService commBoardservice;

	@Autowired
	@Qualifier("communityServiceImpl")
	private CommonService commService;

	@Autowired
	@Qualifier("insideCommunityServiceImpl")
	private CommonService insideCommService;
	
	@Autowired
	@Qualifier("commCommentServiceImpl")
	private CommonService commCommentService;
	
	
	@ModelAttribute("checkUser")
	public int checkUser(Model model, HttpSession session, String comm_num) {
		int commNum = 1;
		if (comm_num != null) {
			commNum = Integer.parseInt(comm_num);
		} else {
			commNum = (Integer) session.getAttribute("comm_num");
		}
		int user_num = (Integer) session.getAttribute("user_num");
		HashMap<String, Object> map = new HashMap<>();
		map.put("comm_num", commNum);
		map.put("user_num", user_num);
		// 회원인지 확인
		int cul_status = (Integer) insideCommService.select(map);
		model.addAttribute("cul_status", cul_status);

		// 관리자 번호
		int comm_adminNum = (Integer) commService.select(commNum);
		model.addAttribute("comm_adminNum", comm_adminNum);
		return cul_status;
	}

	// 해당 커뮤니티의 페이징처리
	@RequestMapping(value = "/community/board/list")
	@ResponseBody
	public HashMap<String, Object> community(Model model, HttpSession session, String comm_num, String pageNum) {
		int commNum = 1;
		if (comm_num != null) {
			commNum = Integer.parseInt(comm_num);
			session.setAttribute("comm_num", commNum);
		} else {
			commNum = (Integer) session.getAttribute("comm_num");
		}

		int pageNUM = 1;
		if (pageNum != null && !pageNum.equals("")) {
			pageNUM = Integer.parseInt(pageNum);
		}

		HashMap<String, Object> board = new HashMap<>();
		board.put("pageNum", pageNUM);
		board.put("session", session);
		board.put("comm_num", commNum);
		HashMap<String, Object> result = (HashMap<String, Object>) commBoardservice.list(board);
		result.put("pageNum", pageNUM);

		System.out.println(result.get("list").toString()+"!!!!!list");
		
		return result;
	}
	
	
	
	
	//커뮤니티 게시글 댓글리스트
	@RequestMapping(value="/community/board/commentList",method=RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> commentList(String pageNum, String cb_num){
		int cbNum=1;
		if(!cb_num.equals("") && cb_num!=null) {
			cbNum=Integer.parseInt(cb_num);
		}
		int pageNUM=1;
		if(!pageNum.equals("") && pageNum!=null) {
			pageNUM=Integer.parseInt(pageNum);
		}
		int commentCnt=commCommentService.getCount(cbNum);
		HashMap<String, Object> map=new HashMap<>();
		map.put("cb_num", cbNum);
		map.put("pageNum", pageNUM);
		HashMap<String, Object> result=(HashMap<String, Object>)commCommentService.list(map);
		result.put("commentCnt", commentCnt);
		
		return result;
	}
	
	
	
	
	
	

}
