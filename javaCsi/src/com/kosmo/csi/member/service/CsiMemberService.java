package com.kosmo.csi.member.service;

import java.util.ArrayList;

import com.kosmo.csi.member.vo.CsiMemberVO;

// * [CsiMemberService]
//	 [CsiMemberServiceImpl] 			 : 	Interface + Implement 
//										 : 	Interface 와 Implement 의 역할이 그렇듯, Interface 엔 뭘 어떻게 사용할건지만 정의
//										 : 	Implement 에 안을 구성해주면 됨.
//										 :	Service 세트는 DAO 세트 와 분리 되어 나누어지고, DAO와 연결로 끝.

public interface CsiMemberService {
	
	public ArrayList<CsiMemberVO> cmemSelectAll();
	public ArrayList<CsiMemberVO> cmemSelect(CsiMemberVO cvo);
	public ArrayList<CsiMemberVO> cmemSelectName(CsiMemberVO cvo);
	public ArrayList<CsiMemberVO> cmemSelectId(CsiMemberVO cvo);
	
	public boolean cmemInsert(CsiMemberVO cvo);
	public boolean cmemUpdate(CsiMemberVO cvo);
	public boolean cmemDelete(CsiMemberVO cvo);
	
}
