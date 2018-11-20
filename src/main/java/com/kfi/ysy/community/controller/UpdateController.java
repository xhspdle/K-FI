package com.kfi.ysy.community.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.vo.CommBoardLikeVo;
import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.jyi.vo.CommVideoVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.service.CommunityPhotoService;


@Controller(value="community_updatecontroller")

public class UpdateController {
	@Autowired
	private CommunityPhotoService cpservice;
	@Autowired 
	@Qualifier("commBoardServiceImpl") private CommonService commBoardservice;
	@RequestMapping(value="/community/board/update",method=RequestMethod.GET)
	public String updateForm(HttpSession session,String cb_num, Model model) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", "select");
		map.put("session", session);
		map.put("cb_num", Integer.parseInt(cb_num));
		
		HashMap<String, Object> result =(HashMap<String, Object>)commBoardservice.select(map);
		model.addAttribute("cbvo", (CommBoardVo)result.get("cbvo")); //�Խñ�
		model.addAttribute("imgList", (List<CommPhotoVo>)result.get("imgList")); //�Խñ� ����
	/*	model.addAttribute("vidList", (List<CommVideoVo>)result.get("vidList")); *///�Խñ� ����
		/*model.addAttribute("cblList", (List<CommBoardLikeVo>)result.get("cblList"));*/ //�Խñ� ��õ
		model.addAttribute("msvList", (List<MySkinViewVo>)result.get("msvList")); //�Խñ� �ۼ���, ��õ ���� skin view
		model.addAttribute("vo", (MembersVo)result.get("vo")); //�ۼ��� ȸ�� ����
		model.addAttribute("writervo", (MySkinViewVo)result.get("writervo")); //�Խñ� �ۼ��� skin view
		model.addAttribute("likeNum", (Integer)result.get("likeNum"));  //��õ��
		
		
		return ".community.board.update";
	}
	@RequestMapping(value="/community/board/update",method=RequestMethod.POST)
	public String update(MultipartHttpServletRequest mtrequest) {
		List<MultipartFile> fileList=mtrequest.getFiles("fileP");
		String uploadPathPhoto=mtrequest.getServletContext().getRealPath("/resources/upload/img");
		try {	
			/*int cb_num=service.getMaxNum()+1;*/
			if(fileList!=null) {
				for(MultipartFile mf:fileList) {
					long filesize=mf.getSize();
					if(filesize!=0) {
						String cp_orgimg=mf.getOriginalFilename();
						String cp_savimg=UUID.randomUUID()+"_"+cp_orgimg;
						InputStream is=mf.getInputStream();
						FileOutputStream fos= new FileOutputStream(uploadPathPhoto+"\\"+cp_savimg);
						FileCopyUtils.copy(is, fos);
						System.out.println(uploadPathPhoto+"�� ���ε强��");
						is.close();
						fos.close();
						CommPhotoVo cpvo=new CommPhotoVo(1, 1, cp_orgimg, cp_savimg);
						System.out.println(cpvo.toString());
						int result=cpservice.insert(cpvo);
						System.out.println(result);
									
					}
				}
			}
		}catch(Exception e){
			e.getMessage();
		}
		return null;
	}
}
