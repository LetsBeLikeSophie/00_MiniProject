package com.spring.board.vo;

public class BoardVO {
	
	
	private String sbnum;
	private String sbsubject;
	private String sbname;
	private String sbcontent;
	private String sbfile;
	private String sbpw;
	private String sbdelyn;
	private String sbinsertdate;
	private String sbupdatedate;
	
	private String keyfilter;
	private String keyword;
	private String startdate;
	private String enddate;
	
	
	
	public BoardVO() {
		
	}
	
	
	public BoardVO(String sbnum, String sbsubject, String sbname, String sbcontent, String sbfile, String sbpw,
			String sbdelyn, String sbinsertdate, String sbupdatedate) {

		this.sbnum = sbnum;
		this.sbsubject = sbsubject;
		this.sbname = sbname;
		this.sbcontent = sbcontent;
		this.sbfile = sbfile;
		this.sbpw = sbpw;
		this.sbdelyn = sbdelyn;
		this.sbinsertdate = sbinsertdate;
		this.sbupdatedate = sbupdatedate;
	}


	public String getSbnum() {
		return sbnum;
	}


	public void setSbnum(String sbnum) {
		this.sbnum = sbnum;
	}


	public String getSbsubject() {
		return sbsubject;
	}


	public void setSbsubject(String sbsubject) {
		this.sbsubject = sbsubject;
	}


	public String getSbname() {
		return sbname;
	}


	public void setSbname(String sbname) {
		this.sbname = sbname;
	}


	public String getSbcontent() {
		return sbcontent;
	}


	public void setSbcontent(String sbcontent) {
		this.sbcontent = sbcontent;
	}


	public String getSbfile() {
		return sbfile;
	}


	public void setSbfile(String sbfile) {
		this.sbfile = sbfile;
	}


	public String getSbpw() {
		return sbpw;
	}


	public void setSbpw(String sbpw) {
		this.sbpw = sbpw;
	}


	public String getSbdelyn() {
		return sbdelyn;
	}


	public void setSbdelyn(String sbdelyn) {
		this.sbdelyn = sbdelyn;
	}


	public String getSbinsertdate() {
		return sbinsertdate;
	}


	public void setSbinsertdate(String sbinsertdate) {
		this.sbinsertdate = sbinsertdate;
	}


	public String getSbupdatedate() {
		return sbupdatedate;
	}


	public void setSbupdatedate(String sbupdatedate) {
		this.sbupdatedate = sbupdatedate;
	}

	
	
	
	
	
// °Ë»ö getter and setter

	
	
	public String getKeyfilter() {
		return keyfilter;
	}


	public void setKeyfilter(String keyfilter) {
		this.keyfilter = keyfilter;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


}
