package com.kosmo.csi.member.service;

import java.util.ArrayList;

import com.kosmo.csi.member.dao.CsiMemberDAO;
import com.kosmo.csi.member.dao.CsiMemberDAOImpl;
import com.kosmo.csi.member.vo.CsiMemberVO;

// * [CsiMemberService]
//	 [CsiMemberServiceImpl] 			 : 	Interface + Implement 
//										 : 	Interface 와 Implement 의 역할이 그렇듯, Interface 엔 뭘 어떻게 사용할건지만 정의
//										 : 	Implement 에 안을 구성해주면 됨.
//										 :	 Service 세트는 DAO 세트 와 분리 되어 나누어지고, DAO와 연결로 끝.

//  1. CsiMemberService 의 Implement 
//  2. CsiMemberService(인터페이스)의 구성	 : 	[4개의 ArrayList 타입의 Methods] : (1개만 with no argument : selectAll 시 입력값 없음)
// 							  				[3개의 boolean 타입의 Methods]   

// 	3. Implement의 함수(경고)에 관하여		 : 	@Override 안하면 어짜피 Override 하라고 계속 경고
// 										 : 	interface 함수 내에 정의 되어 있는 methods 가 하나라도 없으면 경고 나오기도 함

public class CsiMemberServiceImpl implements CsiMemberService {

//	전체 선택 : SelectAll
	@Override
	public ArrayList<CsiMemberVO> cmemSelectAll() {

		System.out.println("CsiMemberServiceImpl.cmemSelectAll() 함수 진입 ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl();
		ArrayList<CsiMemberVO> aList = cdao.cmemSelectAll();
		return aList;
	}
	
// 부분 선택 : Select
	@Override
	public ArrayList<CsiMemberVO> cmemSelect(CsiMemberVO cvo) {

		System.out.println("CsiMemberServiceImpl.cmemSelect() 함수 진입 ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl();
		ArrayList<CsiMemberVO> aList = cdao.cmemSelect(cvo);
		return aList;
	}

// 조건조회, 회원 이름으로 
	@Override
	public ArrayList<CsiMemberVO> cmemSelectName(CsiMemberVO cvo) {

		System.out.println("CsiMemberServiceImpl.cmemSelectName() 함수 진입 ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl(); 
		return cdao.cmemSelectName(cvo);
	}

// 조건조회, 회원 아이디로	
	@Override
	public ArrayList<CsiMemberVO> cmemSelectId(CsiMemberVO cvo) {

		System.out.println("CsiMemberServiceImpl.cmemSelectId() 함수 진입 ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl(); 
		return cdao.cmemSelectId(cvo);

	}
	
// 삽입 : Insert
	@Override
	public boolean cmemInsert(CsiMemberVO cvo) {

		System.out.println("CsiMemberServiceImpl.cmemInsert() 함수 진입 ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl();
		boolean bool = cdao.cmemInsert(cvo);
		return bool;
	}

// 수정 : Update
	@Override
	public boolean cmemUpdate(CsiMemberVO cvo) {

		System.out.println("CsiMemberServiceImpl.cmemUpdate() 함수 진입 ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl();
		boolean bool = cdao.cmemUpdate(cvo);
		return bool;
	}
	
// 삭제 : Delete
	@Override
	public boolean cmemDelete(CsiMemberVO cvo) {
		// TODO Auto-generated method stub
		System.out.println("CsiMemberServiceImpl.cmemDelete() 함수 진입 ");
		
		CsiMemberDAO cdao = new CsiMemberDAOImpl();
		boolean bool = cdao.cmemDelete(cvo);
		return bool;
	}


}
