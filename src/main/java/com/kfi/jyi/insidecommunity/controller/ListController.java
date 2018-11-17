package com.kfi.jyi.insidecommunity.controller;

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

import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.ldk.service.CommonService;

@Controller("insideCommunityListController")
public class ListController {
	@Autowired 
	@Qualifier("commBoardServiceImpl") private CommonService service;

	@Autowired 
	@Qualifier("insideCommunityServiceImpl") private CommonService insideCommService;
	
	// model attribute annotation - ������, Ŀ�� ���� �ֱ�

	// ������ ��������, ������� �������� Ȯ���ϱ� (�۾��� disabled)
	@ModelAttribute("checkUser")
	public int checkUser(Model model, HttpSession session, String comm_num) {
		
		//���� ���� 
		
		/*int user_num=(Integer)session.getAttribute("user_num");
		HashMap<String, Object> map=new HashMap<>();
		map.put("comm_num",1);  
		map.put("user_num", user_num);
		int cul_status=(Integer)insideCommService.select(map);
		model.addAttribute("cul_status", cul_status);
		return cul_status;*/
		return 0; 
	}
	
	
	//�ش� Ŀ�´�Ƽ�� ��ü �Խù� �ҷ�����
	@RequestMapping(value="/community/selectComm",method=RequestMethod.GET)
	public String selectComm(String comm_num, Model model) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("comm_num",comm_num);//Integer.parseInt(comm_num)
		map.put("cb_num", "");
		List<CommBoardViewVo> list=(List<CommBoardViewVo>)service.list(map);
		model.addAttribute("list", list);
		return ".community.list";
	}
	
	//�ش� Ŀ�´�Ƽ�� ������ �Խù� �ҷ�����
	@RequestMapping(value="/community/selectCommBoard",method=RequestMethod.GET)
	public String selectCommBoard(String comm_num, String cb_num, Model model) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("comm_num",comm_num);
		map.put("cb_num", cb_num);
		CommBoardViewVo list=(CommBoardViewVo)service.select(map);
		model.addAttribute("list", list);
		return ".community.board.list";
	}
	
}
