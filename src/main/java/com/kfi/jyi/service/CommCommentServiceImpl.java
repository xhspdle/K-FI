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

import com.kfi.dgl.dao.MembersDao;
import com.kfi.dgl.vo.MembersVo;
import com.kfi.jyi.dao.CommBoardDao;
import com.kfi.jyi.dao.CommBoardLikeDao;
import com.kfi.jyi.dao.CommBoardViewDao;
import com.kfi.jyi.dao.CommCommentDao;
import com.kfi.jyi.dao.CommPhotoDao;
import com.kfi.jyi.dao.CommUserListDao;
import com.kfi.jyi.dao.CommVideoDao;
import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.dao.MySkinViewDao;
import com.kfi.jyi.util.PageUtil;
import com.kfi.jyi.vo.CommBoardLikeVo;
import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.jyi.vo.CommBoardVo;
import com.kfi.jyi.vo.CommCommentVo;
import com.kfi.jyi.vo.CommPhotoVo;
import com.kfi.jyi.vo.CommUserListVo;
import com.kfi.jyi.vo.CommVideoVo;
import com.kfi.jyi.vo.CommunityVo;
import com.kfi.jyi.vo.MySkinViewVo;
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
public class CommCommentServiceImpl implements CommonService {

	@Autowired private CommCommentDao ccdao;
	@Autowired private MySkinViewDao msvdao;;
	
	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(Object data) {
		int cb_num=(Integer)data;
		return ccdao.select_CommentNum(cb_num);
	}

	@Override
	public int insert(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		HttpSession session=(HttpSession)map.get("session");
		int user_num=(Integer)session.getAttribute("user_num");
		int cb_num=(Integer)map.get("cb_num");
		String commc_content=(String)map.get("commc_content");
		int commc_num=ccdao.getMaxNum()+1;
		CommCommentVo vo=new CommCommentVo(commc_num, cb_num, user_num, commc_content, null, 0);
		return ccdao.insert(vo);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		int cb_num=(Integer)map.get("cb_num");
		int pageNum=(Integer)map.get("pageNum");
		PageUtil page=new PageUtil(pageNum, 5, 5, 5);
		int startRow=page.getStartRow();
		int endRow=page.getEndRow();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		List<CommCommentVo> list=ccdao.list(map);
		List<MySkinViewVo> msvvolist=new ArrayList<>();
		for(CommCommentVo ccvo: list) {
			MySkinViewVo msvvo=msvdao.select_using(ccvo.getUser_num());
			msvvolist.add(msvvo);
		}
		HashMap<String, Object> result=new HashMap<>();
		result.put("list",list);//´ñ±Û
		result.put("msvvolist",msvvolist);//´ñ±ÛÀ¯Àú ÇÁ·ÎÇÊ
		result.put("startPageNum", page.getStartPageNum());
		result.put("endPageNum", page.getEndPageNum());
		result.put("pageBlockCount", page.getPageBlockCount());
		result.put("totalPageCount", page.getTotalPageCount());
		
		
		return result;
	}

}
