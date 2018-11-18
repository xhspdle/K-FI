package com.kfi.jyi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.UploadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;

import com.kfi.jyi.dao.CommBoardDao;
import com.kfi.jyi.dao.CommBoardViewDao;
import com.kfi.jyi.dao.CommPhotoDao;
import com.kfi.jyi.dao.CommUserListDao;
import com.kfi.jyi.dao.CommVideoDao;
import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.jyi.vo.CommUserListVo;
import com.kfi.jyi.vo.CommVideoVo;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.ldk.dao.CommTagDao;
import com.kfi.ldk.dao.TagDao;
import com.kfi.ldk.service.CommonService;
import com.kfi.ldk.vo.CommTagVo;
import com.kfi.ldk.vo.TagVo;
import com.kfi.ysy.dao.CommSkinCoverDao;
import com.kfi.ysy.dao.CommSkinProfileDao;
import com.kfi.ysy.vo.CommSkinCoverVo;
import com.kfi.ysy.vo.CommSkinProfileVo;

@Service
public class CommBoardServiceImpl implements CommonService {
	@Autowired
	private CommunityDao cdao;
	@Autowired
	private CommSkinCoverDao cscdao;
	@Autowired
	private CommSkinProfileDao cspdao;
	@Autowired
	private CommUserListDao culdao;
	@Autowired
	private CommBoardViewDao cbvdao;
	@Autowired 
	private CommBoardDao cbdao;
	@Autowired private CommPhotoDao cpdao;
	@Autowired private CommVideoDao cvdao;
	@Autowired private TagDao tdao;
	@Autowired private CommTagDao commtdao;
	
	@Override
	public int getMaxNum() {
		return cbdao.getMaxNum();
	}

	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int insert(Object data) {
		/* �� �Խñ� ���*/
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		HttpSession session=(HttpSession)map.get("session");
		int user_num=(Integer)session.getAttribute("user_num");
		int comm_num=(Integer)session.getAttribute("comm_num");
		String cb_title=(String)map.get("cb_title");
		String cb_content=(String)map.get("cb_content");
		String cb_notice=(String)map.get("cb_notice");
		int cbNotice=0;
		if(cb_notice!=null) {
			cbNotice=1;
		}
		String[] tag_name=(String[])map.get("tag_name");
		MultipartFile[] fileP=(MultipartFile[])map.get("fileP");
		MultipartFile[] fileV=(MultipartFile[])map.get("fileV");
		
		ArrayList<String> fileP_list=new ArrayList<>();
		ArrayList<String> fileV_list=new ArrayList<>();
		String uploadPathPhoto=session.getServletContext().getRealPath("/resources/upload/img");
		String uploadPathVideo=session.getServletContext().getRealPath("/resources/upload/vid");
		try {
			int cb_num=getMaxNum()+1;
			CommBoardVo cbvo=new CommBoardVo(cb_num, comm_num, user_num, cb_title, cb_content, null, cbNotice, 0);
			cbdao.insert(cbvo);
			
			if(fileP!=null) {
				for(int i=0;i<fileP.length;i++) {
					int cp_num=cpdao.getMaxNum()+1;
					String cp_orgimg=fileP[i].getOriginalFilename();
					String cp_savimg=UUID.randomUUID()+"_"+cp_orgimg;
					fileP_list.add(cp_savimg);
					InputStream is=fileP[i].getInputStream();
					FileOutputStream fos=new FileOutputStream(uploadPathPhoto+"\\"+cp_savimg);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					CommPhotoVo cpvo=new CommPhotoVo(cp_num, cb_num, cp_orgimg, cp_savimg);
					cpdao.insert(cpvo);
				}
			}
			
			if(fileV!=null) {
				for(int i=0; i<fileV.length;i++) {
					int cv_num=cvdao.getMaxNum()+1;
					String cv_orgvid=fileV[i].getOriginalFilename();
					String cv_savvid=UUID.randomUUID()+"_"+cv_orgvid;
					fileV_list.add(cv_savvid);
					InputStream is=fileV[i].getInputStream();
					FileOutputStream fos=new FileOutputStream(uploadPathVideo+"\\"+cv_orgvid);
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					CommVideoVo cvvo=new CommVideoVo(cv_num, cb_num, cv_orgvid, cv_savvid);
					cvdao.insert(cvvo);
				}
			}
			
			if(tag_name!=null) {
				for(int i=0;i<tag_name.length;i++) {
					TagVo tvo=tdao.select(tag_name[i]);
					int tag_num=0;
					if(tvo==null) {
						tag_num=tdao.getMaxNum()+1;
						TagVo newtvo=new TagVo(tag_num, tag_name[i]);
						tdao.insert(newtvo);
					}else{
						tag_num=tvo.getTag_num()+1;
					}
					int ctag_num=commtdao.getMaxNum()+1;
					CommTagVo ctvo=new CommTagVo(ctag_num, tag_num, cb_num);
					commtdao.insert(ctvo);
				}
			}
			
			return 1;
		}catch(Exception e) {
			for(String deleteImg:fileP_list) {
				File filePhoto=new File(uploadPathPhoto+"\\"+deleteImg);
				if(filePhoto.delete()) {
					System.out.println("���� ����");
				}
			}
			for(String deleteVid:fileV_list) {
				File fileVideo=new File(uploadPathPhoto+"\\"+deleteVid);
				if(fileVideo.delete()) {
					System.out.println("���� ����");
				}
			}
			System.out.println(e.getMessage());
			return -1;
		}
	}

	@Override
	public int update(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object select(Object data) {
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		return cbvdao.select(map);
	}

	@Override
	public Object list(Object data) {
		HashMap<String, Object> map = (HashMap<String, Object>) data;
		return cbvdao.list(map);
	}

}