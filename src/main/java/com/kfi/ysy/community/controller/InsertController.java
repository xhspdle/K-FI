package com.kfi.ysy.community.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.ysy.service.CommunityPhotoService;

@Controller(value = "community_insertcontroller")
public class InsertController {
	@Autowired
	private CommunityPhotoService cpservice;

	@RequestMapping(value = "/community/insert", method = RequestMethod.GET)
	public String insertForm() {
		return ".community.board.insert";
	}

	public String insert(MultipartHttpServletRequest mtrequest) {
		List<MultipartFile> fileList = mtrequest.getFiles("fileP");
		String uploadPathPhoto = mtrequest.getServletContext().getRealPath("/resources/upload/img");
		try {
			/* int cb_num=service.getMaxNum()+1; */
			if (fileList != null) {
				for (MultipartFile mf : fileList) {
					long filesize = mf.getSize();
					if (filesize != 0) {
						String cp_orgimg = mf.getOriginalFilename();
						String cp_savimg = UUID.randomUUID() + "_" + cp_orgimg;
						InputStream is = mf.getInputStream();
						FileOutputStream fos = new FileOutputStream(uploadPathPhoto + "\\" + cp_savimg);
						FileCopyUtils.copy(is, fos);
						System.out.println(uploadPathPhoto + "에 업로드성공");
						is.close();
						fos.close();
						CommPhotoVo cpvo = new CommPhotoVo(1, 1, cp_orgimg, cp_savimg);
						System.out.println(cpvo.toString());
						int result = cpservice.insert(cpvo);
						System.out.println(result);
					}
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}
