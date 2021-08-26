package com.kosmo.csi.board.scr;

import java.util.ArrayList;
import java.util.Scanner;

import com.kosmo.common.CsiBoardChabun;
import com.kosmo.csi.board.service.CsiBoardService;
import com.kosmo.csi.board.service.CsiBoardServiceImpl;
import com.kosmo.csi.board.vo.CsiBoardVO;


public class CsiBoardScr {
	

	public static final String[] insert_label = {"글제목", "작성자", "글내용", "비밀번호"};
	public static final String[] update_label = {"글번호", "글제목", "글내용"};	

	public static void cboardSelectAll(){
		
		try {
			CsiBoardService ss = new CsiBoardServiceImpl();	

			ArrayList<CsiBoardVO> aList = ss.cboardSelectAll();

			if (aList !=null && aList.size() > 0) {
				for (int i=0; i < aList.size(); i++) {				
					CsiBoardVO cvo = aList.get(i);	
					CsiBoardVO.printCsiBoardVO(cvo);
				}		
			}else {
				System.out.println("aList 에 데이터가 없네요 >>> : " + aList);
			}
		}catch(Exception e) {
			System.out.println("등록 중 에러가 >>> : " + e.getMessage());
		}
	}
	
	public static void cboardSelect(String sVal[]){
		System.out.println("CsiBoardScr.cboardSelect() 함수 진입 >>> : ");
		System.out.println("회원정보 조회 >>> : " + sVal[0]);
				
		try {
			CsiBoardService ss = new CsiBoardServiceImpl();	
			CsiBoardVO cvo = null;
			cvo = new CsiBoardVO();
			cvo.setBnum(sVal[0]);

			ArrayList<CsiBoardVO> aList = ss.cboardSelect(cvo);

			if (aList !=null && aList.size() > 0) {
				for (int i=0; i < aList.size(); i++) {				
					CsiBoardVO _cvo = aList.get(i);	
					CsiBoardVO.printCsiBoardVO(_cvo);
				}		
			}else {
				System.out.println("aList 에 데이터가 없네요 >>> : " + aList);
			}
		}catch(Exception e) {
			System.out.println("등록 중 에러가 >>> : " + e.getMessage());
		}
		
	}
	
	public static void cboardInsert(String sVal[]){
		System.out.println("CsiBoardScr.cboardInsert() 함수 진입 >>> : ");
		System.out.println("회원정보 입력 >>> : " + sVal.length);
		
		for (int i=0; i < sVal.length; i++){
			System.out.println(insert_label[i] + " >>> : " + sVal[i]);
		}
		
		String bnum = CsiBoardChabun.gubunNum();
		String bsubject = sVal[0];
		String bwriter = sVal[1];
		String bpw = sVal[2];
		String bcontents = sVal[3];
		
		try {
			CsiBoardService ss = new CsiBoardServiceImpl();	
			CsiBoardVO cvo = null;
			cvo = new CsiBoardVO();
			
			cvo.setBnum(bnum);
			cvo.setBsubject(bsubject);
			cvo.setBwriter(bwriter);			
			cvo.setBcontents(bcontents);
			cvo.setBpw(bpw);
			
			int nCnt = ss.cboardInsert(cvo);					
			
			if (nCnt > 0) {				
				System.out.println("게시글 " + nCnt + " 건 등록 되었습니다.");				
			}else {
				System.out.println("게시글 등록 실패.");
			}			
		}catch(Exception e) {
			System.out.println("등록 중 에러가 >>> : " + e.getMessage());
		}
	}
	
	public static void cboardUpdate(String sVal[]){
		System.out.println("CsiBoardScr.cboardUpdate() 함수 진입 >>> : ");
		System.out.println("회원정보 수정 >>> : " + sVal.length);
		
		for (int i=0; i < sVal.length; i++){
			System.out.println(update_label[i] + " >>> : " + sVal[i]);
		}
		
		String bnum = sVal[0];		
		String bsubject = sVal[1];
		String bcontents = sVal[2];
		
		try {
			CsiBoardService ss = new CsiBoardServiceImpl();	
			CsiBoardVO cvo = null;
			cvo = new CsiBoardVO();
			
			cvo.setBnum(bnum);
			cvo.setBsubject(bsubject);
			cvo.setBcontents(bcontents);
						
			int nCnt = ss.cboardUpdate(cvo);	
			
			if (nCnt > 0) {				
				System.out.println("게시글 " + nCnt + " 건 수정 되었습니다.");				
			}else {
				System.out.println("게시글 수정 실패.");
			}			
		}catch(Exception e) {
			System.out.println("수정 중 에러가 >>> : " + e.getMessage());
		}				 
	}
	
	public static void cboardDelete(String sVal[]){
		System.out.println("CsiBoardScr.cboardDelete() 함수 진입 >>> : ");
		System.out.println("회원정보 삭제 >>> : " + sVal[0]);

		try {
			CsiBoardService ss = new CsiBoardServiceImpl();	
			CsiBoardVO cvo = null;
			cvo = new CsiBoardVO();
			
			cvo.setBnum(sVal[0]);
						
			int nCnt = ss.cboardDelete(cvo);	
			
			if (nCnt > 0) {				
				System.out.println("게시글 " + nCnt + " 건 삭제 되었습니다.");				
			}else {
				System.out.println("게시글 삭제 실패.");
			}			
		}catch(Exception e) {
			System.out.println("삭제 중 에러가 >>> : " + e.getMessage());
		}				 
	}
	
	public static String[] getParameter(int iVal) {
	
		String sVal[] = null;
		
		if (2 == iVal || 5 == iVal) {
			sVal = new String[1];
			
			System.out.println("조회 또는 삭제할 게시판 글번호 입력하시오 >>> : ");
			
			Scanner sc25 = new Scanner(System.in);
			
			sVal[0] = sc25.next();
			
			System.out.println("조회 또는 삭제할 게시판 정보는 >>> : " + sVal[0]);
		}
		
		if (3 == iVal) { 			
			
			sVal = new String[insert_label.length];	
			
			Scanner sc3 = new Scanner(System.in);
			
			System.out.println("등록할 게시판정보를 입력하시오 >>> : " + insert_label.length);
			System.out.println("등록할 게시판 배열의 길이 >>> : " + sVal.length);
			
			for (int i=0; i < sVal.length; i++) {
				System.out.println(insert_label[i] + "을(를) 입력하시오 :: " );
				sVal[i] = sc3.next();
				System.out.println(insert_label[i] + " 정보는 >>> : " + sVal[i]);
			}
		}			
		
		if (4 == iVal) { 
		
			sVal = new String[update_label.length];				
			
			Scanner sc4 = new Scanner(System.in);
			
			System.out.println("수정할 게시판정보를 입력하시오 >>> : " + update_label.length);
			System.out.println("수정할 게시판정보 배열의 길이 >>> : " + sVal.length);
			
			for (int i=0; i < sVal.length; i++) {
				
				System.out.println(update_label[i] + "을(를) 입력하시오 :: " );
				
				sVal[i] = sc4.next();
				
				System.out.println(update_label[i] + " 정보는 >>> : " + sVal[i]);
			}
		}
		
		return sVal;
	}	
	
	public static void main(String[] args) {

		System.out.println("게시판 CRUD::ISUD 테스트 >>> : ");		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("\n게시판정보 전체조회:1, 조건조회:2, 등록:3, 수정:4, 삭제:5, 종료:0");
			
			int isud = sc.nextInt();	
			if (0 == isud) {
				System.out.println("프로그램 종료 !!"); 
				break;	
			}
			 
			
			switch(isud) {
				case 1:		
					try {
						CsiBoardScr.cboardSelectAll();
					}catch(Exception e) {						
					}
					break;
					
				case 2:				
					try {
						String sVal2[] = CsiBoardScr.getParameter(2);
						CsiBoardScr.cboardSelect(sVal2);
					}catch(Exception e) {						
					}								
					break;
					
				case 3:
					try {
						String sVal3[] = CsiBoardScr.getParameter(3);
						CsiBoardScr.cboardInsert(sVal3);
					}catch(Exception e) {						
					}
					break;
					
				case 4:
					try {
						String sVal4[] = CsiBoardScr.getParameter(4);
						CsiBoardScr.cboardUpdate(sVal4);
					}catch(Exception e) {						
					}				
					break;
					
				case 5:				
					try {
						String sVal5[] = CsiBoardScr.getParameter(5);
						CsiBoardScr.cboardDelete(sVal5);							
					}catch(Exception e) {						
					}								
					break;					
			}
		}
	}
}
