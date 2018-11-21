package com.kfi.jyi.vo;

public class CommBoardCntVo {
	private int cmcnt;
	private int cblcnt;
	private int cvcnt;
	private int cb;
	public CommBoardCntVo() {
		super();
	}
	public CommBoardCntVo(int cmcnt, int cblcnt, int cvcnt, int cb) {
		super();
		this.cmcnt = cmcnt;
		this.cblcnt = cblcnt;
		this.cvcnt = cvcnt;
		this.cb = cb;
	}
	public int getCmcnt() {
		return cmcnt;
	}
	public void setCmcnt(int cmcnt) {
		this.cmcnt = cmcnt;
	}
	public int getCblcnt() {
		return cblcnt;
	}
	public void setCblcnt(int cblcnt) {
		this.cblcnt = cblcnt;
	}
	public int getCvcnt() {
		return cvcnt;
	}
	public void setCvcnt(int cvcnt) {
		this.cvcnt = cvcnt;
	}
	public int getCb() {
		return cb;
	}
	public void setCb(int cb) {
		this.cb = cb;
	}
	@Override
	public String toString() {
		return "CommBoardCntVo [cmcnt=" + cmcnt + ", cblcnt=" + cblcnt + ", cvcnt=" + cvcnt + ", cb=" + cb + "]";
	}
	
	
	

}
