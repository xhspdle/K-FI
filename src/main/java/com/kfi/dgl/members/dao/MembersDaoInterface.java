package com.kfi.dgl.members.dao;

import java.util.HashMap;

import com.kfi.dgl.members.vo.MembersVo;

public interface MembersDaoInterface {
	
	    public MembersVo login(HashMap<String, Object> map);

}
