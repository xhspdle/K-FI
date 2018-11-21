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
	
	// model attribute annotation - ������, Ŀ�� ���� �ֱ�

	// ������ ��������, ������� �������� Ȯ���ϱ� 
	
	
	
	//�ش� Ŀ�´�Ƽ�� ������ �Խù� �ҷ�����
	@RequestMapping(value="/community/board/select",method=RequestMethod.GET)
	public String selectCommBoard(HttpSession session,String cb_num, Model model) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", "select");
		map.put("session", session);
		map.put("cb_num", Integer.parseInt(cb_num));
		
		HashMap<String, Object> result =(HashMap<String, Object>)commBoardservice.select(map);
		model.addAttribute("cbvo", (CommBoardVo)result.get("cbvo")); //�Խñ�
		model.addAttribute("imgList", (List<CommPhotoVo>)result.get("imgList")); //�Խñ� ����
		model.addAttribute("vidList", (List<CommVideoVo>)result.get("vidList")); //�Խñ� ����
		model.addAttribute("cblList", (List<CommBoardLikeVo>)result.get("cblList")); //�Խñ� ��õ
		model.addAttribute("msvList", (List<MySkinViewVo>)result.get("msvList")); //�Խñ� �ۼ���, ��õ ���� skin view
		model.addAttribute("vo", (MembersVo)result.get("vo")); //�ۼ��� ȸ�� ����
		model.addAttribute("writervo", (MySkinViewVo)result.get("writervo")); //�Խñ� �ۼ��� skin view
		model.addAttribute("likeNum", (Integer)result.get("likeNum"));  //��õ��
		model.addAttribute("tagList", (List<TagVo>)result.get("tagList"));  //�±׸���Ʈ
		model.addAttribute("commentCnt", (Integer)result.get("commentCnt"));  //��� ��
		
		
		return ".community.board.select";
	}
	
}
