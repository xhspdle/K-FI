package com.kfi.ldk.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kfi.jyi.vo.CommunityVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.vo.CommSkinProfileVo;

@Controller(value = "communityController")
public class CommunityController {

	@Autowired
	@Qualifier("communityServiceImpl")
	private CommonService service;
	
	// 전체 커뮤니티 best6 커뮤니티 정보 불러오기
	@RequestMapping(value = "/communityMain", method = RequestMethod.GET)
	public String communityMain(Model model) {
		/*String list="bestSix";
		HashMap<String, Object> map = (HashMap<String, Object>) service.list(list);
		List<CommunityVo> cvolist = (List<CommunityVo>) map.get("bestSix");
		model.addAttribute("list", cvolist);
		List<CommSkinProfileVo> csplist = (List<CommSkinProfileVo>) map.get("csplist");
		model.addAttribute("csplist", csplist); 
		System.out.println(cvolist.toString()+"!!!!!!cvolist");
		System.out.println(csplist.toString()+"!!!!!!csplist");
		*/
		return ".communityMain";
	}


}
