package com.kosmo.csi.member.dao;

import java.util.ArrayList;

import com.kosmo.csi.member.vo.CsiMemberVO;

// * [CsiMemberDAO]
// 	 [CsiMemberDAOImpl] 				 : 	Interface + Implement 
//										 : 	Interface 와 Implement 의 역할이 그렇듯, Interface 엔 뭘 어떻게 사용할건지만 정의
//										 : 	Implement 에 안을 구성해주면 됨.
//										 :	DAO 세트는 Service 세트 와 분리 되어 나누어지고, Service 에서 그대로 넘겨온 왔기 때문에 내용을 정의 해줘야 함.

public interface CsiMemberDAO {
	
	public ArrayList<CsiMemberVO> cmemSelectAll();
	public ArrayList<CsiMemberVO> cmemSelect(CsiMemberVO cvo);
	public ArrayList<CsiMemberVO> cmemSelectName(CsiMemberVO cvo);
	public ArrayList<CsiMemberVO> cmemSelectId(CsiMemberVO cvo);	
	
	public boolean cmemInsert(CsiMemberVO cvo);
	public boolean cmemUpdate(CsiMemberVO cvo);
	public boolean cmemDelete(CsiMemberVO cvo);
	
}
