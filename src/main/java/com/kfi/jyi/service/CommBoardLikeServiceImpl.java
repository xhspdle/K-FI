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
import com.kfi.jyi.dao.CommPhotoDao;
import com.kfi.jyi.dao.CommUserListDao;
import com.kfi.jyi.dao.CommVideoDao;
import com.kfi.jyi.dao.CommunityDao;
import com.kfi.jyi.dao.MySkinViewDao;
import com.kfi.jyi.vo.CommBoardLikeVo;
import com.kfi.jyi.vo.CommBoardViewVo;
import com.kfi.jyi.vo.CommBoardVo;
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
public class CommBoardLikeServiceImpl implements CommonService {

	@Autowired private CommBoardLikeDao cbldao;
	@Autowired private MySkinViewDao msvdao;
	
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
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		HttpSession session=(HttpSession)map.get("session");
		int user_num=(Integer)session.getAttribute("user_num");
		map.put("user_num", user_num);
		int cb_num=(Integer)map.get("cb_num");
		try {
			int result=cbldao.getBoardLikeUserNum(map);
			if(result==0) { 
				//좋아요 추가하기
				int cbl_num=cbldao.getMaxNum()+1;
				CommBoardLikeVo vo=new CommBoardLikeVo(cbl_num, cb_num, user_num);
				cbldao.insert(vo);	
			}else if(result==1) {
				//좋아요 취소
				cbldao.delete(map);
			}
			List<CommBoardLikeVo> cblvo=cbldao.select(cb_num);
			int num=cblvo.size();
			//갱신된 좋아요 수 
			return cblvo.size();
		}catch(Exception e) {
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
		return null;
	}

	@Override
	public Object list(Object data) {
		int cb_num=(Integer)data;
		List<CommBoardLikeVo> list=cbldao.select(cb_num);
		List<MySkinViewVo> msvvlist=new ArrayList<>();
		for(CommBoardLikeVo vo : list) {
			MySkinViewVo msvvo=msvdao.select_using(vo.getUser_num());
			msvvlist.add(msvvo);
		}
		return msvvlist;
	}
	
}
