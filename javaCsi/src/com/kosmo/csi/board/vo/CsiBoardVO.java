package com.kosmo.csi.board.vo;

public class CsiBoardVO {
	
	private String bnum;
	private String bsubject;
	private String bwriter;
	private String bcontents;
	private String bpw;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	// 생성자 
	public CsiBoardVO() {
		
	}
	
	public CsiBoardVO(String bnum, String bsubject, 
			          String bwriter, String bcontents, 
			          String bpw, String deleteyn,
			          String insertdate, String updatedate) {		
		this.bnum = bnum;
		this.bsubject = bsubject;
		this.bwriter = bwriter;
		this.bcontents = bcontents;
		this.bpw = bpw;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}
	
	// getter() 함수 
	public String getBnum() {
		return bnum;
	}
	public String getBsubject() {
		return bsubject;
	}
	public String getBwriter() {
		return bwriter;
	}
	public String getBcontents() {
		return bcontents;
	}
	public String getBpw() {
		return bpw;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	
	// setter() 함수
	public void setBnum(String bnum) {
		this.bnum = bnum;
	}
	public void setBsubject(String bsubject) {
		this.bsubject = bsubject;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}
	public void setBpw(String bpw) {
		this.bpw = bpw;
	}
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	// 프린트 
	public static void printCsiBoardVO (CsiBoardVO cvo){
		System.out.print(cvo.getBnum() + " : ");
		System.out.print(cvo.getBsubject() + " : ");
		System.out.print(cvo.getBwriter() + " : ");
		System.out.print(cvo.getBcontents() + " : ");
		System.out.print(cvo.getBpw() + " : ");
		System.out.print(cvo.getDeleteyn() + " : ");
		System.out.print(cvo.getInsertdate() + " : ");
		System.out.println(cvo.getUpdatedate());
	}
	
	public static void printlnCsiBoardVO (CsiBoardVO cvo){
		System.out.println("cvo.getBnum() 			>>> : " + cvo.getBnum());
		System.out.println("cvo.getBsubject() 		>>> : " + cvo.getBsubject());
		System.out.println("cvo.getBwriter() 		>>> : " + cvo.getBwriter());
		System.out.println("cvo.getBcontents() 		>>> : " + cvo.getBcontents());
		System.out.println("cvo.getBpw() 			>>> : " + cvo.getBpw());
		System.out.println("cvo.getDeleteyn() 		>>> : " + cvo.getDeleteyn());
		System.out.println("cvo.getInsertdate() 	>>> : " + cvo.getInsertdate());
		System.out.println("cvo.getUpdatedadte() 	>>> : " + cvo.getUpdatedate());
	}
}
