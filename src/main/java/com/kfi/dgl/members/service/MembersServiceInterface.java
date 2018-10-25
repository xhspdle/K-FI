package com.kfi.dgl.members.service;

import java.util.HashMap;

import com.kfi.dgl.members.vo.MembersVo;

public interface MembersServiceInterface {
	public MembersVo login(HashMap<String, Object> map);
}
