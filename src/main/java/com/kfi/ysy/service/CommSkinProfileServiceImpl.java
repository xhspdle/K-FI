package com.kfi.ysy.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommSkinProfileDao;
import com.kfi.ysy.vo.CommSkinProfileVo;
@Service
public class CommSkinProfileServiceImpl implements CommonService {
	@Autowired private CommSkinProfileDao cspdao;
	@Autowired private CommunityDao cdao;
	@Autowired private MembersDao mdao;
	@Override
	public int getMaxNum() {
		return cspdao.getMaxNum();
	}

	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Object data) {
		CommSkinProfileVo vo=(CommSkinProfileVo)data;
		return cspdao.insert(vo);
	}

	@Override
	@Transactional
	public int update(Object data) {
		MultipartHttpServletRequest multirequest=(MultipartHttpServletRequest)data;
		String uploadimg = multirequest.getServletContext().getRealPath("/resources/upload/img");
		try {	
			int csp_num = Integer.parseInt(multirequest.getParameter("csp_num"));
			int comm_num = Integer.parseInt(multirequest.getParameter("comm_num"));
			MultipartFile orgimgfile = multirequest.getFile("csp_orgimg");
			String csp_orgimg = orgimgfile.getOriginalFilename();
			String csp_savimg = UUID.randomUUID() + "_" + csp_orgimg;
			CommSkinProfileVo cspvo=new CommSkinProfileVo(csp_num, comm_num, csp_orgimg, csp_savimg, 1);
			
			InputStream is = orgimgfile.getInputStream();
			FileOutputStream fos = new FileOutputStream(uploadimg + "\\" + csp_savimg);
			FileCopyUtils.copy(is, fos);
			System.out.println(uploadimg + "에 업로드성공");
			is.close();
			fos.close();
			cspdao.update(cspvo);
						
			String comm_name = multirequest.getParameter("comm_name");
			String comm_content = multirequest.getParameter("comm_content");
			CommunityVo cvo=new CommunityVo(comm_num, 0, comm_name, comm_content, null, null);
			cdao.update(cvo);
			
			return 1;
		}catch(Exception e){
			e.getMessage();
			return -1;
		}
	}

	@Override
	public int delete(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object select(Object data) {
		int comm_num=(Integer)data;
		CommSkinProfileVo cspvo=cspdao.select(comm_num);
		CommunityVo cvo=cdao.select_comm(comm_num);
		int admin_num=cvo.getUser_num();
		MembersVo mvo=mdao.select(admin_num);
		HashMap<String, Object> map=new HashMap<>();
		map.put("cvo", cvo);
		map.put("cspvo", cspvo);
		map.put("mvo",mvo);
		return map; 
	}
	
	@Override
	public Object list(Object data) {
		// TODO Auto-generated method stub
		return null;
	}
}
