package com.kfi.ldk.controller;


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

import com.kfi.jyi.vo.CommBoardCntVo;
import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommCommentVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;

@Controller(value = "insideCommunityController")
public class InsideCommunityController {

	@Autowired
	@Qualifier("communityServiceImpl")
	private CommonService commService;

	@Autowired
	@Qualifier("insideCommunityServiceImpl")
	private CommonService insideCommService;

	@Autowired
	@Qualifier("commBoardServiceImpl")
	private CommonService commBoardservice;

	@ModelAttribute("getCommNum")
	public void getCommNum(HttpSession session, String comm_num) {
		int commNum = 1;
		if (comm_num!=null) {
			commNum = Integer.parseInt(comm_num);
			session.setAttribute("comm_num", commNum);
		}
	}

	// ������ ��������, ������� �������� Ȯ���ϱ�
	@ModelAttribute("checkUser")
	public int checkUser(Model model, HttpSession session,String comm_num) {
		int commNum=1;
		if(comm_num!=null) {
			commNum=Integer.parseInt(comm_num);
		}else {
			commNum=(Integer)session.getAttribute("comm_num");
		}
		int user_num = (Integer) session.getAttribute("user_num");
		HashMap<String, Object> map = new HashMap<>();
		map.put("comm_num", commNum); 
		map.put("user_num", user_num);
		//ȸ������ Ȯ��
		int cul_status = (Integer) insideCommService.select(map);
		model.addAttribute("cul_status", cul_status);
		
		//������ ��ȣ
		int comm_adminNum=(Integer)commService.select(commNum);
		model.addAttribute("comm_adminNum", comm_adminNum);
		return cul_status;
	}

	// �ش� Ŀ�´�Ƽ�� ��ü �Խù� �ҷ�����
	@RequestMapping(value = "/community", method = RequestMethod.GET)
	public String community(Model model, HttpSession session,String comm_num, String pageNum) {
		int commNum=1;
		if(comm_num!=null) {
			commNum=Integer.parseInt(comm_num);
		}else {
			commNum=(Integer)session.getAttribute("comm_num");
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", "notice");
		map.put("session", session);
		List<CommBoardVo> noticeList=(List<CommBoardVo>)commBoardservice.select(map);
		model.addAttribute("noticeList", noticeList);

		int pageNUM=1;
		if(pageNum!=null && !pageNum.equals("")) {
			pageNUM=Integer.parseInt(pageNum);
		}
		int commNUM=1;
		if(comm_num!=null && !comm_num.equals("")) {
			commNUM=Integer.parseInt(comm_num);
		}
		HashMap<String, Object> board=new HashMap<>();
		board.put("pageNum", pageNUM);
		board.put("session", session);
		board.put("comm_num", commNUM);
		HashMap<String, Object> result=(HashMap<String, Object>)commBoardservice.list(board);
		
		model.addAttribute("list",(List<CommBoardVo>)result.get("list"));
		model.addAttribute("msvlist",(List<MySkinViewVo>)result.get("msvlist"));
		model.addAttribute("cbclist",(List<CommBoardCntVo>)result.get("cbclist"));
		
		
		return ".community";
	}
	
	
	
}
