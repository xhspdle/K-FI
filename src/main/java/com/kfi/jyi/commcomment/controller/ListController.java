package com.kfi.jyi.commcomment.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kfi.jyi.util.PageUtil;
import com.kfi.jyi.vo.CommCommentVo;
import com.kfi.ldk.service.CommonService;

@Controller(value = "commCommentListController")
public class ListController {

	@Autowired
	@Qualifier("commCommentServiceImpl")
	private CommonService commCommentService;
	
	@RequestMapping(value = "/commcomment/list")
	public HashMap<String, Object> list(String cb_num, String pageNum) {
		int cbNum = 0;
		if (cb_num != null) {
			cbNum = Integer.parseInt(cb_num);
		}
		int pageNUM = 0;
		if (pageNum != null && !pageNum.equals("")) {
			pageNUM = Integer.parseInt(pageNum);
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("cb_num", cbNum);
		map.put("pageNum", pageNUM);

		HashMap<String, Object> result = (HashMap<String, Object>) commCommentService.list(map);
		result.put("pageNum", pageNUM);
		return result;
	}

	// 커뮤니티 게시글 댓글리스트
	@RequestMapping(value = "/community/board/commentList", method = RequestMethod.GET)
	@ResponseBody
	public HashMap<String, Object> commentList(String pageNum, String cb_num) {
		int cbNum = 1;
		if (!cb_num.equals("") && cb_num != null) {
			cbNum = Integer.parseInt(cb_num);
		}
		int pageNUM = 1;
		if (!pageNum.equals("") && pageNum != null) {
			pageNUM = Integer.parseInt(pageNum);
		}
		int commentCnt = commCommentService.getCount(cbNum);
		HashMap<String, Object> map = new HashMap<>();
		map.put("cb_num", cbNum);
		map.put("pageNum", pageNUM);
		HashMap<String, Object> result = (HashMap<String, Object>) commCommentService.list(map);
		result.put("commentCnt", commentCnt);

		return result;
	}

}
