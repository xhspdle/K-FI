package com.kfi.jyi.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.aspectj.weaver.patterns.HasMemberTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.xml.sax.InputSource;

import com.kfi.jyi.dao.MySkinCoverDao;
import com.kfi.jyi.dao.MySkinDao;
import com.kfi.jyi.dao.MySkinProfileDao;
import com.kfi.jyi.dao.MySkinViewDao;
import com.kfi.jyi.vo.MySkinCoverVo;
import com.kfi.jyi.vo.MySkinProfileVo;
import com.kfi.jyi.vo.MySkinViewVo;
import com.kfi.jyi.vo.MySkinVo;
import com.kfi.ldk.service.CommonService;

@Service
public class MySkinServiceImpl implements CommonService {
	@Autowired
	private MySkinDao msdao;
	@Autowired
	private MySkinCoverDao mscdao;
	@Autowired
	private MySkinProfileDao mspdao;
	@Autowired
	private MySkinViewDao msvdao;

	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(Object data) {
		int user_num=(Integer)data;
		return msdao.getCountNum(user_num);
	}

	@Override
	@Transactional
	public int insert(Object data) {
		HashMap<String, Object> hm = (HashMap<String, Object>) data;
		HttpSession session = (HttpSession) hm.get("session");
		int user_num = (Integer) session.getAttribute("user_num");
		MultipartFile ms_profile = (MultipartFile) hm.get("ms_profile");
		MultipartFile ms_cover = (MultipartFile) hm.get("ms_cover");
		String ms_name = (String) hm.get("ms_name");
		String ms_color = (String) hm.get("ms_color");
		String ms_msg = (String) hm.get("ms_msg");
		int getCountNum=getCount(user_num);
		
		if(ms_name==null || ms_name.equals("")) ms_name="스킨"+(getCountNum+1); //닉네임 님의 스킨 1
		if(ms_color==null || ms_color.equals("")) ms_color="#00cee8";
		if(ms_msg==null || ms_msg.equals("")) ms_msg="";
		
		String uploadPath = session.getServletContext().getRealPath("/resources/upload/img");
		String[] savimg = new String[2];
		try {
			int ms_num = msdao.getMaxNum();
			msdao.insert(new MySkinVo(ms_num + 1, user_num, ms_name, ms_color, ms_msg, 0));
			if (ms_profile == null && ms_cover == null) return 1;
			//프로필 사진 있을 때
			if (ms_profile.getOriginalFilename().equals("") && ms_profile !=null) {
				int msp_num = mspdao.getMaxNum();
				String msp_orgimg = ms_profile.getOriginalFilename();
				String msp_savimg = UUID.randomUUID() + "_" + msp_orgimg;
				savimg[0] = msp_savimg;
				InputStream is = ms_profile.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath + "\\" + msp_savimg);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				mspdao.insert(new MySkinProfileVo(msp_num + 1, ms_num + 1, msp_orgimg, msp_savimg));
			}
			//커버 사진 있을 때
			if ( ms_cover.getOriginalFilename().equals("") && ms_cover != null) {
				int msc_num = mscdao.getMaxNum();
				String msc_orgimg = ms_cover.getOriginalFilename();
				String msc_savimg = UUID.randomUUID() + "_" + msc_orgimg;
				savimg[1] = msc_savimg;
				InputStream is = ms_cover.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath + "\\" + msc_savimg);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				mscdao.insert(new MySkinCoverVo(msc_num + 1, ms_num + 1, msc_orgimg, msc_savimg));
			}
			return 1;
		} catch (Exception e) {
			for (int i = 0; i < savimg.length; i++) {
				File file = new File(uploadPath + "\\" + savimg[i]);
				if (file.delete())
					System.out.println("파일 삭제 성공");
			}
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	public int update(Object data) {
		HashMap<String, Object> hm = (HashMap<String, Object>) data;
		HttpSession session = (HttpSession) hm.get("session");
		int user_num = (Integer) session.getAttribute("user_num");
		int ms_num = (Integer) hm.get("ms_num");
		String ms_name = (String) hm.get("ms_name");
		String ms_color = (String) hm.get("ms_color");
		String ms_msg = (String) hm.get("ms_msg");
		MultipartFile ms_profile = (MultipartFile) hm.get("ms_profile");
		MultipartFile ms_cover = (MultipartFile) hm.get("ms_cover");
		MySkinViewVo msvVo = (MySkinViewVo) select(ms_num);

		int getCountNum=getCount(user_num);
		
		if(ms_name==null || ms_name.equals("")) ms_name=msvVo.getMs_name(); //닉네임 님의 스킨 1
		if(ms_msg==null || ms_msg.equals("")) ms_msg="";

		msdao.update(new MySkinVo(ms_num, user_num, ms_name, ms_color, ms_msg, 0));
		int update = 0;
		for (int i = 0; i < 2; i++) {
			// 파일 수정 없을 때
			if (!ms_profile.isEmpty())	++update;
			if (!ms_cover.isEmpty())	++update;
		}
		if (update == 0) return 1;
		try {
			String uploadPath = session.getServletContext().getRealPath("/resources/upload/img");
			String msp_orgimg = msvVo.getMsp_orgimg();
			String msp_savimg = msvVo.getMsp_savimg();
			String msc_orgimg = msvVo.getMsc_orgimg();
			String msc_savimg = msvVo.getMsc_savimg();
			//파일이 없다가 생겼을 때 ,,,,,,,,,,,,,,,,,,,,,,,
			if (ms_profile.getOriginalFilename().equals("") && ms_profile !=null) {
				File file = new File(uploadPath + "\\" + msp_savimg);
				if (file.delete()) System.out.println("이전 사진 삭제 성공");
				msp_orgimg = ms_profile.getOriginalFilename();
				msp_savimg = UUID.randomUUID() + "_" + msp_orgimg;
				InputStream is = ms_profile.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath + "\\" + msp_savimg);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				System.out.println(uploadPath + " 경로에 파일 수정업로드 성공");
				mspdao.update(new MySkinProfileVo(msvVo.getMsp_num(), ms_num, msp_orgimg, msp_savimg));
			}
			if ( ms_cover.getOriginalFilename().equals("") && ms_cover != null) {
				File file = new File(uploadPath + "\\" + msc_savimg);
				if (file.delete()) System.out.println("이전 사진 삭제 성공");
				msc_orgimg = ms_cover.getOriginalFilename();
				msc_savimg = UUID.randomUUID() + "_" + msc_orgimg;
				InputStream is = ms_cover.getInputStream();
				FileOutputStream fos = new FileOutputStream(uploadPath + "\\" + msc_savimg);
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				mscdao.update(new MySkinCoverVo(msvVo.getMsc_num(), ms_num, msc_orgimg, msc_savimg));
			}
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	@Transactional
	public int delete(Object data) {
		HashMap<String, Object> hm = (HashMap<String, Object>) data;
		int ms_num = (Integer) hm.get("ms_num");
		HttpSession session = (HttpSession) hm.get("session");
		String uploadPath = session.getServletContext().getRealPath("/resources/upload/img");
		try {
			MySkinViewVo list = (MySkinViewVo) select(ms_num);
			String[] img = new String[2];
			if(list.getMsp_savimg() != null) {
				img[0] = list.getMsp_savimg();
				mspdao.delete(ms_num);
			}
			if(list.getMsc_savimg() != null) {
				img[1] = list.getMsc_savimg();
				mscdao.delete(ms_num);
			}
			for (int i = 0; i < img.length; i++) {
				if(img[i]!=null) {
					File file = new File(uploadPath + "\\" + img[i]);
					if (file.delete()) System.out.println("파일 삭제 성공");
				}
			}
			msdao.delete(ms_num);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	public Object select(Object data) {
		int ms_num = (Integer) data;
		return msvdao.select(ms_num);
	}

	@Override
	public Object list(Object data) {
		int user_num = (Integer) data;
		return msvdao.list(user_num);
	}

}
