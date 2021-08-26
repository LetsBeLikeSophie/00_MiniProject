package com.kosmo.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosmo.csi.member.sql.CsiMemberSqlMap;

public class CsiMemberChabun {
	
	public static final String BIZ_GUBUN_M = "M"; 

	public static String ymdNum() {
		
// 		지역변수 선언 하고 초기화 하기 		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String commNO = "";

// 		try/catch 구문		
		try {
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberChabunQuery());
			System.out.println("회원채번 쿼리 >>> \n" + CsiMemberSqlMap.getCsiMemberChabunQuery());
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
			
//			로그시작

			System.out.println("commNO >>> : " + commNO);		// 1	

			//			자릿수만큼 0을 채워넣는 함수			
			commNO = CodeUtil.numPad(commNO);					
			System.out.println("commNO >>> : " + commNO);		// 0001

//			위와 같은 원리로 DateUtil에서 날짜형식 가져와서 commNO (현재 0001) 붙임			
			commNO = DateUtil.yyyymmdd().concat(commNO);
			System.out.println("commNO >>> : " + commNO);		// 202108240001

// 			업무구분 코드 붙이기 BIZ_GUBUN_M(=M임) 에 202108240001 붙임 
			commNO = CsiMemberChabun.BIZ_GUBUN_M.concat(commNO);
			System.out.println("commNO >>> : " + commNO);		// M202108240001
			
			CsiConnProperty.conClose(conn, pstmt, rsRs);			
			
		}catch(Exception e) {
			System.out.println("CsiMemberChabun ymdNum 디비 에러 >>> : " + e.getMessage());
			
		}finally {
			CsiConnProperty.conClose(conn, pstmt, rsRs);
			
		}
//		commNO == M202108240001 returned		
		return commNO;
	}

	public static void main(String[] args) {
		String commNO = CsiMemberChabun.ymdNum();
		System.out.println("main :: commNO >>> : " + commNO);
	}
}
