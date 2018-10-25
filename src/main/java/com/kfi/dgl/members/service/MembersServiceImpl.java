package com.kfi.dgl.members.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfi.dgl.members.dao.MembersDaoInterface;
import com.kfi.dgl.members.vo.MembersVo;

@Service
public class MembersServiceImpl implements MembersServiceInterface{
	@Autowired
	MembersDaoInterface dao;
	@Override
	public MembersVo login(HashMap<String, Object> map) {
		return dao.login(map);
	}
	

}
