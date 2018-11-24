package com.kfi.jyi.service;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.kfi.jyi.dao.CommCommentDao;
import com.kfi.jyi.dao.CommCommentLikeDao;
import com.kfi.jyi.vo.CommCommentLikeVo;
import com.kfi.ldk.service.CommonService;

@Service
public class CommCommentLikeServiceImpl implements CommonService{

	@Autowired private CommCommentDao ccdao;
	@Autowired private CommCommentLikeDao ccldao;
	
	
	@Override
	public int getMaxNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount(Object data) {
		int commc_num=(Integer)data;
		return ccdao.getCommcLikeCnt(commc_num);
	}

	@Override
	@Transactional
	public int insert(Object data) {
		HashMap<String, Object> map=(HashMap<String, Object>)data;
		HttpSession session=(HttpSession)map.get("session");
		int user_num=(Integer)session.getAttribute("user_num");
		int commc_num=(Integer)map.get("commc_num");
		map.put("user_num", user_num);
		try {
			//좋아요 했는지 확인
			int check=ccldao.checkUserNum(map);
			if(check>0) {
				//좋아요 했으면 취소
				ccdao.update_disCommcLike(commc_num);
				ccldao.delete(map);
				return 0;
			}else {
				//안했으면 등록
				ccdao.update_CommcLike(commc_num);
				int ccl_num=ccldao.getMaxNum()+1;
				CommCommentLikeVo vo=new CommCommentLikeVo(ccl_num, commc_num, user_num);
				ccldao.insert(vo);
				return 1;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
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
		// TODO Auto-generated method stub
		return null;
	}

	
}
