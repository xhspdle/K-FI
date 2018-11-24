package com.kfi.ysy.service;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.ldk.service.CommonService;
import com.kfi.ysy.dao.CommSkinCoverDao;
import com.kfi.ysy.vo.CommSkinCoverVo;

@Service
public class CommSkinCoverServiceImpl implements CommonService {
	@Autowired private CommSkinCoverDao cscdao;
	@Autowired private CommunityDao cdao;
	@Override
	public int getMaxNum() {
		return cscdao.getMaxNum();
	}

	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Object data) {
		MultipartHttpServletRequest multirequest=(MultipartHttpServletRequest)data;
		String uploadimg = multirequest.getServletContext().getRealPath("/resources/upload/img");
		int csc_num=getMaxNum()+1;
		try {
			int comm_num=Integer.parseInt(multirequest.getParameter("comm_num"));
			String cs_color=multirequest.getParameter("cs_color");
			MultipartFile orgimgfile = multirequest.getFile("csc_orgimg");
			String csc_orgimg = orgimgfile.getOriginalFilename();
			String csc_savimg = UUID.randomUUID() + csc_orgimg;
			System.out.println(comm_num+"////////////"+cs_color+"//////////"+csc_orgimg);
			System.out.println(uploadimg + "\\" + csc_orgimg);
			
			
			InputStream is = orgimgfile.getInputStream();
			FileOutputStream fos= new FileOutputStream(uploadimg + "\\" + csc_savimg);
			FileCopyUtils.copy(is, fos);
			is.close();
			fos.close();
			
			CommSkinCoverVo cscvo= new CommSkinCoverVo(csc_num, comm_num, csc_orgimg, csc_savimg, 0);
			int cscresult = cscdao.insert(cscvo);
			System.out.println(uploadimg + "에 파일 업로드 완료");
			
			int comm_num1=Integer.parseInt(multirequest.getParameter("comm_num"));
			CommunityVo cvo = new CommunityVo(comm_num1, 0, null, null, cs_color, null);
			System.out.println(cvo.getComm_num()+"///////////");
			int cresult = cdao.update(cvo);
			System.out.println();
			if(cscresult >0 && cresult > 0) {
				return 1;
			}else {
				return -1;
			}	
		}catch(Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
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
		int csc_num=(Integer)data;
		CommSkinCoverVo cscvo = cscdao.select(csc_num);
		cscvo.getCsc_savimg();
		cscdao.delete(csc_num);

		return 0;
	}

	@Override
	public Object select(Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list(Object data) {
		int comm_num=(Integer)data;
		CommunityVo cvo = cdao.select_comm(comm_num);
		List<CommSkinCoverVo> csclist = (List<CommSkinCoverVo>)cscdao.list(comm_num);
		HashMap<String, Object> map = new HashMap<>();
		map.put("cvo", cvo);
		map.put("csclist", csclist);
		return map;
	}
	
}
