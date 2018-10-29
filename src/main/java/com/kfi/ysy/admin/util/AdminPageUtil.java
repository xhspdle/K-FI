package com.kfi.ysy.admin.util;

public class AdminPageUtil {
	private int pagenum;
	private int startpagenum;
	private int endpagenum;
	private int totalpagecnt;
	
	private int startrow;
	private int endrow;
	private int totalrowcnt;
	
	private int rowblockcnt;
	private int pageblockcnt;
	public AdminPageUtil() {}
	public AdminPageUtil(int totalrowcnt, int pagenum, int rowblockcnt, int pageblockcnt)
	{
		this.totalrowcnt = totalrowcnt;
		this.pagenum = pagenum;
		this.rowblockcnt = rowblockcnt;
		this.pageblockcnt = pageblockcnt;
		startrow=(pagenum-1)*rowblockcnt+1;
		endrow=startrow+(rowblockcnt-1);
		totalpagecnt=(int)Math.ceil(totalrowcnt/(double)rowblockcnt);
		startpagenum=(pagenum-1)/pageblockcnt*pageblockcnt+1;
		endpagenum=startpagenum+pageblockcnt-1;
		if(totalpagecnt<endpagenum) {
			endpagenum=totalpagecnt;
		}
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getStartpagenum() {
		return startpagenum;
	}
	public void setStartpagenum(int startpagenum) {
		this.startpagenum = startpagenum;
	}
	public int getEndpagenum() {
		return endpagenum;
	}
	public void setEndpagenum(int endpagenum) {
		this.endpagenum = endpagenum;
	}
	public int getTotalpagecnt() {
		return totalpagecnt;
	}
	public void setTotalpagecnt(int totalpagecnt) {
		this.totalpagecnt = totalpagecnt;
	}
	public int getStartrow() {
		return startrow;
	}
	public void setStartrow(int startrow) {
		this.startrow = startrow;
	}
	public int getEndrow() {
		return endrow;
	}
	public void setEndrow(int endrow) {
		this.endrow = endrow;
	}
	public int getTotalrowcnt() {
		return totalrowcnt;
	}
	public void setTotalrowcnt(int totalrowcnt) {
		this.totalrowcnt = totalrowcnt;
	}
	public int getRowblockcnt() {
		return rowblockcnt;
	}
	public void setRowblockcnt(int rowblockcnt) {
		this.rowblockcnt = rowblockcnt;
	}
	public int getPageblockcnt() {
		return pageblockcnt;
	}
	public void setPageblockcnt(int pageblockcnt) {
		this.pageblockcnt = pageblockcnt;
	}
	
	
}
