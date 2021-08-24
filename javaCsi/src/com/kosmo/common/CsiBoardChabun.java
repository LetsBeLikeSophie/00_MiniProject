package com.kosmo.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosmo.csi.board.sql.CsiBoardSqlMap;

public class CsiBoardChabun {

//  쓰이지 않고 MemberChabun 에 있으므로 주석처리를 함!	
//	public static final String BIZ_GUBUN_M = "M"; // 회원
	public static final String BIZ_GUBUN_B = "B"; // 게시판
	

//  채번 쿼리  불러오기 
	public static String gubunNum() {
		
//      디비연결 3종 세트 선언 및 초기화 + 결과 값 저장할 commNO 선언 >> 채번할 예정!		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String commNO = "";

//		try/catch 구문		
		try {
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiBoardSqlMap.getCboardChabunQueryMap());
			System.out.println("게시판채번 쿼리 >>> \n" + CsiBoardSqlMap.getCboardChabunQueryMap());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null) {
				while (rsRs.next()) {
//					쿼리에서 이름을 COMMNO으로 붙임 마지막 숫자 4개 중 맥스값에 +1 로 채번
//				 	더 헷갈리면 따라가서 참조할 것. CsiBoardSqlMap 에서 getCboardChabunQueryMap					
					commNO = rsRs.getString("COMMNO");
				}
			}else {
				System.out.println("채번쿼리 실패 >>> : ");
			}

//			로그 찍기 시작!!			
			System.out.println("commNO >>> : " + commNO);		// 1	

//			0을 자릿수에 맞게 붙여주는 함수 이용해서 1 을 0001 로 만들기			
			commNO = CodeUtil.numPad(commNO);
			System.out.println("commNO >>> : " + commNO);		// 0001	== commNO	
			
// (중요)		concat()에 대해서!
//			String 을 붙이는 방법은 크게 세가지. (프로젝트에서 다 사용되어짐)

//			1. + 연산자 	
//			"안녕"+"하세요" 처럼 + 를 이용해 붙임		>> 예) CodeUtil 에  if(("0" + i).equals(hobbyNum))

//			2. concat()
//			result = text1.concat(text2)		>> 예) 아랫줄 BIZ_GUBUN_B(=B임).concat(commNO);
			
//			3. StringBuffer 에서 append()			>> 예) Sql 클래스 내의 쿼리문 함수
					
			commNO = CsiBoardChabun.BIZ_GUBUN_B.concat(commNO);	// B0001 == commNO
			System.out.println("commNO >>> : " + commNO);
			CsiConnProperty.conClose(conn, pstmt, rsRs);	
			
		}catch(Exception e) {
			System.out.println("CsiMemberChabun gubunNum 디비 에러 >>> : " + e.getMessage());
		}finally {
			CsiConnProperty.conClose(conn, pstmt, rsRs);
		}

//		결과적으로 디비연결 쿼리로 채번 후 네자리로 만들고 분류 알파벳 (B: board) 뒤에 채번 붙여서 반환		
		return commNO;
	}

	public static void main(String[] args) {
		
		String commNO = CsiBoardChabun.gubunNum();
		System.out.println("main :: commNO >>> : " + commNO);
	}
}
