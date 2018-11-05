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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public int insert(Object data) {
			HashMap<String, Object> hm = (HashMap<String, Object>) data;
			HttpSession session=(HttpSession)hm.get("session");
			int user_num=(Integer)session.getAttribute("user_num");
			MultipartFile[] ms_file=(MultipartFile[])hm.get("ms_file");
			String ms_name=(String)hm.get("ms_name");
			String ms_color=(String)hm.get("ms_color");
			String ms_msg=(String)hm.get("ms_msg");
			
			String uploadPath=session.getServletContext().getRealPath("/resources/upload/img");
			
		try {
			int ms_num=msdao.getMaxNum();
			msdao.insert(new MySkinVo(ms_num+1, user_num, ms_name, ms_color, ms_msg, 0));
			
			for(int i=0;i<ms_file.length;i++) {
				InputStream is=ms_file[i].getInputStream();
				FileOutputStream fos=new FileOutputStream(uploadPath+"\\"+UUID.randomUUID()+"_"+ms_file[i].getOriginalFilename());
				FileCopyUtils.copy(is, fos);
				is.close();
				fos.close();
				System.out.println(uploadPath + " 경로에 파일업로드 성공");
			}
			
			int msp_num=mspdao.getMaxNum();
			String msp_orgimg=ms_file[0].getOriginalFilename();
			String msp_savimg=UUID.randomUUID()+"_"+msp_orgimg;
			mspdao.insert(new MySkinProfileVo(msp_num+1, ms_num+1, msp_orgimg, msp_savimg));
			
			int msc_num=mscdao.getMaxNum();
			String msc_orgimg=ms_file[1].getOriginalFilename();
			String msc_savimg=UUID.randomUUID()+"_"+msc_orgimg;
			mscdao.insert(new MySkinCoverVo(msc_num+1, ms_num+1, msc_orgimg, msc_savimg));
			return 1;
		} catch (Exception e) {
			for(int i=0;i<ms_file.length;i++) {
				File file=new File(uploadPath+"\\"+UUID.randomUUID()+"_"+ms_file[i].getOriginalFilename());
				if(file.delete()) System.out.println("파일 삭제 성공");;
			}
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	public int update(Object data) {
		HashMap<String, Object> hm = (HashMap<String, Object>) data;
		HttpSession session=(HttpSession)hm.get("session");
		int user_num=(Integer)session.getAttribute("user_num");
		int ms_num=(Integer)hm.get("ms_num");
		String ms_name=(String)hm.get("ms_name");
		String ms_color=(String)hm.get("ms_color");
		String ms_msg=(String)hm.get("ms_msg");		
		
		MySkinViewVo  msvVo = (MySkinViewVo)select(ms_num);

		MultipartFile[] ms_file=(MultipartFile[])hm.get("ms_file");
		String uploadPath=session.getServletContext().getRealPath("/resources/upload/img");
		int update=0;
		for(int i=0;i<ms_file.length;i++) {
			//파일 수정 없을 때
			if(ms_file[i].isEmpty()) {
				++update;
			}
		}
		if(update==0) {
			msdao.update(new MySkinVo(ms_num, user_num, ms_name, ms_color, ms_msg, 0));
			return 1;
		}

		try {			
			String msp_orgimg=msvVo.getMsp_orgimg();
			String msp_savimg=msvVo.getMsp_savimg();
			String msc_orgimg=msvVo.getMsc_orgimg();
			String msc_savimg=msvVo.getMsc_savimg();
			for(int i=0;i<ms_file.length;i++) {
				if(!ms_file[i].isEmpty()) {
					if(i==0) {
						File mspFile=new File(uploadPath+"\\"+msvVo.getMsp_savimg());
						if(mspFile.delete()) System.out.println("프로필 사진 삭제 성공");
						msp_orgimg=ms_file[0].getOriginalFilename();
						msp_savimg=UUID.randomUUID()+"_"+msp_orgimg;
					}else if(i==1){
						File mscFile=new File(uploadPath+"\\"+msvVo.getMsc_savimg());
						if(mscFile.delete()) System.out.println("커버 사진 삭제 성공");
						msc_orgimg=ms_file[1].getOriginalFilename();
						msc_savimg=UUID.randomUUID()+"_"+msc_orgimg;
					}
					InputStream is=ms_file[i].getInputStream();
					FileOutputStream fos=new FileOutputStream(uploadPath+"\\"+UUID.randomUUID()+"_"+ms_file[i].getOriginalFilename());
					FileCopyUtils.copy(is, fos);
					is.close();
					fos.close();
					System.out.println(uploadPath + " 경로에 파일 수정업로드 성공");
				}
			}
			mspdao.update(new MySkinProfileVo(msvVo.getMsp_num(), ms_num, msp_orgimg, msp_savimg));
			mscdao.update(new MySkinCoverVo(msvVo.getMsc_num(), ms_num, msc_orgimg, msc_savimg));
			msdao.update(new MySkinVo(ms_num, user_num, ms_name, ms_color, ms_msg, 0));
			
			return 1;
		}catch(Exception e) {
			//파일 지우고 DB 에러났을 때...?
			
			
			System.out.println(e.getMessage());
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return -1;
		}
	}

	@Override
	public int delete(Object data) {
		//on delete cascade 주기 
		int ms_num=(Integer)data;
		return msdao.delete(ms_num);
	}

	@Override
	public Object select(Object data) {
		int ms_num=(Integer)data;
		return msvdao.select(ms_num);
	}

	@Override
	public Object list(Object data) {
		return msvdao.list((Integer) data);
	}

}
