package com.kfi.jyi.myskin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.jyi.vo.MySkinVo;
import com.kfi.ldk.service.CommonService;

@Controller(value = "myskinUpdateController")
public class UpdateController {
	@Autowired
	@Qualifier("mySkinServiceImpl")
	private CommonService service;

	@RequestMapping(value = "/mypage/myskin/updateForm", method = RequestMethod.GET)
	public String updateForm(Model model, String ms_num) {
		int msNum = Integer.parseInt(ms_num);
		MySkinViewVo  mslist = (MySkinViewVo) service.select(msNum);
		model.addAttribute("mslist", mslist);
		return ".mypage.myskin.update";
	}

	@RequestMapping(value = "/mypage/myskin/update", method = RequestMethod.POST)
	public String update(HttpSession session, MultipartFile[] ms_file, String ms_name, String ms_color, String ms_msg,
			String ms_num) {
		HashMap<String, Object> hm = new HashMap<>();
		hm.put("session", session);
		hm.put("ms_num", Integer.parseInt(ms_num));
		hm.put("ms_file", ms_file);
		hm.put("ms_name", ms_name);
		hm.put("ms_color", ms_color);
		hm.put("ms_msg", ms_msg);

		int result = service.update(hm);
		if (result > 0) {
			return "redirect: /mypage/myskin/list";
		} else {
			return "redirect: /mypage/myskin/list"; // ���������� �̵�
		}
	}
}