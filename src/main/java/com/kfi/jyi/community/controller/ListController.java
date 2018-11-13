package com.kfi.jyi.community.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.ldk.service.CommonService;

@Controller
public class ListController {
	@Autowired 
	@Qualifier("communityServiceImpl") private CommonService service;

	// model attribute annotation - ������, Ŀ�� ���� �ֱ�

	

	
	//������ Ŀ�´�Ƽ�� ��ü �Խù� �ҷ�����
	@RequestMapping(value="/community/selectComm",method=RequestMethod.GET)
	public String selectComm(String comm_num, Model model) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("comm_num",comm_num);
		map.put("cb_num", "");
		List<CommBoardViewVo> list=(List<CommBoardViewVo>)service.select(map);
		model.addAttribute("list", list);
		return ".community.list";
	}
	
	//�ش� Ŀ�´�Ƽ�� ������ �Խù� �ҷ�����
	@RequestMapping(value="/community/selectCommBoard",method=RequestMethod.GET)
	public String selectCommBoard(String comm_num, String cb_num, Model model) {
		HashMap<String, Object> map=new HashMap<>();
		map.put("comm_num",comm_num);
		map.put("cb_num", cb_num);
		List<CommBoardViewVo> list=(List<CommBoardViewVo>)service.select(map);
		model.addAttribute("list", list);
		return ".community.board.list";
	}
	
	
	
	
	
}
