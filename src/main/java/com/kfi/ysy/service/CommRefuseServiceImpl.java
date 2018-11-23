package com.kfi.ysy.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.jyi.dao.CommRefuseDao;
import com.kfi.jyi.dao.CommUserListDao;
import com.kfi.jyi.vo.CommRefuseVo;
import com.kfi.ldk.service.CommonService;

@Service
public class CommRefuseServiceImpl implements CommonService {
	@Autowired private CommRefuseDao crdao;
	@Autowired private CommUserListDao culdao;
	
	@Override
	public int getMaxNum() {
		return crdao.getMaxNum();
	}

	@Override
	public int getCount(Object data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Object data) {
/*		HashMap<String, Object> map =(HashMap<String, Object>)data;
		int comm_num=(Integer)map.get("comm_num");
		CommRefuseVo crfvo =(CommRefuseVo)map.get("crfvo");
		int cr_num=getMaxNum()+1;
		crfvo.setCr_num(cr_num);
		System.out.println("///////////"+cr_num);	
		int result=crdao.insert(crfvo);*/
		CommRefuseVo vo =(CommRefuseVo)data;
		int cr_num=getMaxNum()+1;
		vo.setCr_num(cr_num);
		int cul_num=vo.getCul_num();
		int result=crdao.insert(vo);
		int result1=culdao.update(cul_num);
		System.out.println(result);
		return 1;
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
