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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.vo.CommBoardLikeVo;
import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.jyi.vo.CommVideoVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.TagVo;

@Controller(value = "commBoardUpdateController")
public class UpdateController {

	@Autowired
	@Qualifier("commBoardServiceImpl")
	private CommonService commBoardservice;

	@Autowired
	@Qualifier("commBoardUpdateCntServiceImpl")
	private CommonService commBoardUpdateCntService;

	@Autowired
	@Qualifier("communityServiceImpl")
	private CommonService commService;

	@Autowired
	@Qualifier("insideCommunityServiceImpl")
	private CommonService insideCommService;

	// 가입한 유저인지, 강퇴당한 유저인지 확인하기
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

	// 조회수 +1
	@RequestMapping(value = "/community/board/updateViews")
	@ResponseBody
	public HashMap<String, Object> updateViewsCnt(String cb_num) {
		int result = commBoardUpdateCntService.update(cb_num);
		HashMap<String, Object> resultMap = new HashMap<>();
		resultMap.put("result", result);

		return resultMap;
	}

	// 게시글 업데이트Form
	@RequestMapping(value = "/community/board/updateForm", method = RequestMethod.GET)
	public String updateForm(String cb_num, HttpSession session, Model model) {
		int cbNum = 0;
		if (cb_num != null && !cb_num.equals("")) {
			cbNum = Integer.parseInt(cb_num);
		}

		HashMap<String, Object> map = new HashMap<>();
		map.put("list", "select");
		map.put("session", session);
		map.put("cb_num", cbNum);

		HashMap<String, Object> result = (HashMap<String, Object>) commBoardservice.select(map);
		model.addAttribute("cbvo", (CommBoardVo) result.get("cbvo")); // 게시글
		List<CommPhotoVo> imgList = (List<CommPhotoVo>) result.get("imgList");
		model.addAttribute("imgList", imgList); // 게시글 사진
		if (imgList.isEmpty()) {
			model.addAttribute("imgNull", "imgNull");
		}else {
			int imgListSize=imgList.size();
			model.addAttribute("imgListSize", imgListSize);
		}
		List<CommVideoVo> vidList = (List<CommVideoVo>) result.get("vidList");
		model.addAttribute("vidList", vidList); // 게시글 비디오
		if (vidList.isEmpty()) {
			model.addAttribute("vidNull", "vidNull");
		}else {
			int vidListSize=vidList.size();
			model.addAttribute("vidListSize", vidListSize);
		}
		model.addAttribute("cblList", (List<CommBoardLikeVo>) result.get("cblList")); // 게시글 추천
		model.addAttribute("msvList", (List<MySkinViewVo>) result.get("msvList")); // 게시글 작성자, 추천 유저 skin view
		model.addAttribute("vo", (MembersVo) result.get("vo")); // 작성자 회원 정보
		model.addAttribute("writervo", (MySkinViewVo) result.get("writervo")); // 게시글 작성자 skin view
		List<TagVo> tagList = (List<TagVo>) result.get("tagList");
		model.addAttribute("tagList", tagList); // 태그리스트
		if (tagList.isEmpty()) {
			model.addAttribute("tagNull", "tagNull");
		}
		model.addAttribute("commentCnt", (Integer) result.get("commentCnt")); // 댓글 수
		model.addAttribute("likeNum", (Integer) result.get("likeNum")); // 추천수
		model.addAttribute("pageNum", 1); // 댓글 페이지 번호 기본값
		model.addAttribute("prevCbNum", (Integer) result.get("prevCbNum")); // 이전글번호
		model.addAttribute("nextCbNum", (Integer) result.get("nextCbNum")); // 다음글번호

		return ".community.board.update";
	}

	// 게시글 업데이트
	@RequestMapping(value = "/communityBoard/update", method = RequestMethod.POST)
	public String update(HttpSession session, RedirectAttributes redirectAttributes, String cb_num, String cb_title,
			String cb_content, String cb_notice, String[] tag_name, String[] del_Tags, MultipartFile fileP1,
			MultipartFile fileP2, MultipartFile fileP3, MultipartFile fileP4, MultipartFile fileP5,
			MultipartFile fileV1, MultipartFile fileV2) {
		int cbNum = 1;
		if (!cb_num.equals("") && cb_num != null) {
			cbNum = Integer.parseInt(cb_num);
		}

		HashMap<String, Object> map = new HashMap<>();
		map.put("session", session);
		map.put("cb_num", cbNum);
		map.put("cb_title", cb_title);
		map.put("cb_content", cb_content);
		map.put("cb_notice", cb_notice);
		map.put("tag_name", tag_name);
		map.put("del_Tags", del_Tags);
		map.put("fileP1", fileP1);
		map.put("fileP2", fileP2);
		map.put("fileP3", fileP3);
		map.put("fileP4", fileP4);
		map.put("fileP5", fileP5);
		map.put("fileV1", fileV1);
		map.put("fileV2", fileV2);

		int result = (Integer) commBoardservice.update(map);

		if (result > 0) {
			// redirectAttributes.addAttribute("cb_num", cbNum);
			// return "redirect:/community/board/select";
		} else {
			// redirectAttributes.addAttribute("cb_num", cbNum);
			// return "redirect:/community/board/select"; //error
		}
		return ".community";

	}

}
