package com.kosmo.csi.member.vo;

import com.kosmo.common.CodeUtil;


// VO setting 마우스 우클릭 + source 또는 Alt + Shift + S
// 기본 : 빈 것/with변수/Getter/Setter
public class CsiMemberVO {
	
	private String cnum;
	private String cname;
	private String cid;
	private String cpw; 
	private String cbirth;
	private String cgender;
	private String ctel;
	private String chp; 
	private String cemail;
	private String caddr; 
	private String chobby;
	private String cphoto;
	private String cskill;
	private String cjob;
	private String deleteyn; 
	private String insertdate; 
	private String updatedate;
	
	
// 	1. method with none
	public CsiMemberVO() {

	}

// 	2. method with arguments 
	public CsiMemberVO(String cnum, String cname, String cid, String cpw, String cbirth, String cgender, String ctel,
			String chp, String cemail, String caddr, String chobby, String cphoto, String cskill, String cjob,
			String deleteyn, String insertdate, String updatedate) {

		this.cnum = cnum;
		this.cname = cname;
		this.cid = cid;
		this.cpw = cpw;
		this.cbirth = cbirth;
		this.cgender = cgender;
		this.ctel = ctel;
		this.chp = chp;
		this.cemail = cemail;
		this.caddr = caddr;
		this.chobby = chobby;
		this.cphoto = cphoto;
		this.cskill = cskill;
		this.cjob = cjob;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}

// 	3. setter
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public void setCpw(String cpw) {
		this.cpw = cpw;
	}

	public void setCbirth(String cbirth) {
		this.cbirth = cbirth;
	}

	public void setCgender(String cgender) {
		this.cgender = cgender;
	}

	public void setCtel(String ctel) {
		this.ctel = ctel;
	}

	public void setChp(String chp) {
		this.chp = chp;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public void setCaddr(String caddr) {
		this.caddr = caddr;
	}

	public void setChobby(String chobby) {
		this.chobby = chobby;
	}

	public void setCphoto(String cphoto) {
		this.cphoto = cphoto;
	}

	public void setCskill(String cskill) {
		this.cskill = cskill;
	}

	public void setCjob(String cjob) {
		this.cjob = cjob;
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

// 	4. getter
	public String getCnum() {
		return cnum;
	}

	public String getCname() {
		return cname;
	}

	public String getCid() {
		return cid;
	}

	public String getCpw() {
		return cpw;
	}

	public String getCbirth() {
		return cbirth;
	}

	public String getCgender() {
		return cgender;
	}

	public String getCtel() {
		return ctel;
	}

	public String getChp() {
		return chp;
	}

	public String getCemail() {
		return cemail;
	}

	public String getCaddr() {
		return caddr;
	}

	public String getChobby() {
		return chobby;
	}

	public String getCphoto() {
		return cphoto;
	}

	public String getCskill() {
		return cskill;
	}

	public String getCjob() {
		return cjob;
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
	
//	 ArrayList 안에 cvo 내에 저장된 멤버에 대한 정보를 출력하여 보여줌 
// 	형식은 a, b, c, d, e, ..., z
	public static void printCsiMemberVO(CsiMemberVO cvo) {
		
		System.out.print(cvo.getCnum() 			+ ", ");
		System.out.print(cvo.getCname() 		+ ", ");
		System.out.print(cvo.getCid()			+ ", ");
		System.out.print(cvo.getCpw() 			+ ", ");
		System.out.print(CodeUtil.birth(cvo.getCbirth()) 	+ ", ");
		System.out.print(CodeUtil.gender(cvo.getCgender())  + ", ");
		System.out.print(CodeUtil.tel(cvo.getCtel())		+ ", ");
		System.out.print(CodeUtil.hp(cvo.getChp()) 			+ ", ");
		System.out.print(cvo.getCemail()		+ ", ");
		System.out.print(cvo.getCaddr() 		+ ", ");
		System.out.print(CodeUtil.hobby(cvo.getChobby())    + ", ");
		System.out.print(cvo.getCphoto() 		+ ", ");
		System.out.print(cvo.getCskill()		+ ", ");
		System.out.print(CodeUtil.job(cvo.getCjob())        + ", ");
		System.out.print(cvo.getDeleteyn() 		+ ", ");
		System.out.print(cvo.getInsertdate() 	+ ", ");
		System.out.println(cvo.getUpdatedate());
	}
	
//	 	ArryaList 안에 cvo 내에 저장된 멤버에 대한 정보를 출력하여 보여줌 
//	 	형식은 cvo.getCnum() 		>>> : a
//			 cvo.getCnum() 		>>> : b
//			 cvo.getCnum() 		>>> : c
//			 ...
//			 cvo.getCnum() 		>>> : z	
	 public static void printlnCsiMemberVO(CsiMemberVO cvo) {
		
		System.out.println("cvo.getCnum() 		>>> : " + cvo.getCnum());
		System.out.println("cvo.getCname() 		>>> : " + cvo.getCname());
		System.out.println("cvo.getCid() 		>>> : " + cvo.getCid());
		System.out.println("cvo.getCpw() 		>>> : " + cvo.getCpw());
		System.out.println("cvo.getCbirth() 	>>> : " + CodeUtil.birth(cvo.getCbirth()));
		System.out.println("cvo.getCgender() 	>>> : " + CodeUtil.gender(cvo.getCgender()));
		System.out.println("cvo.getCtel() 		>>> : " + CodeUtil.tel(cvo.getCtel()));
		System.out.println("cvo.getChp() 		>>> : " + CodeUtil.hp(cvo.getChp()));
		System.out.println("cvo.getCemail() 	>>> : " + cvo.getCemail());
		System.out.println("cvo.getCaddr() 		>>> : " + cvo.getCaddr());
		System.out.println("cvo.getChobby() 	>>> : " + CodeUtil.hobby(cvo.getChobby()));
		System.out.println("cvo.getCphoto() 	>>> : " + cvo.getCphoto());
		System.out.println("cvo.getCskill() 	>>> : " + cvo.getCskill());
		System.out.println("cvo.getCjob() 		>>> : " + CodeUtil.job(cvo.getCjob()));
		System.out.println("cvo.getDeleteyn() 	>>> : " + cvo.getDeleteyn());
		System.out.println("cvo.getInsertdate() >>> : " + cvo.getInsertdate());
		System.out.println("cvo.getInsertdate() >>> : " + cvo.getUpdatedate());
	}
}
