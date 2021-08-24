package com.kosmo.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public abstract class CsiConnProperty {

//  상수로 선언하기 나중에 수정하기 쉽고 가독성도 좋아짐!
//  드라이버 관련 에러가 날 수 있음 	>> .jar 안에 포함하고 있는지 프로젝트랑 잘 연결 되었는지 확인
//	경로 지정 에러가 날 수 있음		>> 포트나 sid 다르면 경로를 못 찾아갈 수 있음
	private static final String ORCL_JDBC_DIRVER = "oracle.jdbc.driver.OracleDriver";
	private static final String ORCL_URL = "jdbc:oracle:thin:@localhost:1521:orclKOSMO00";
	private static final String ORCL_USER = "csi00";
	private static final String ORCL_PASS = "csi1234";
	
//  connection 을 도와줄 함수 Connection 타입 선언하기 	
	public static Connection getConnection() {

//		선언 및 초기화		
		Connection conn = null;

//		try/catch 구문 		
		try {
			Class.forName(CsiConnProperty.ORCL_JDBC_DIRVER);	
			conn = DriverManager.getConnection( CsiConnProperty.ORCL_URL
					                           ,CsiConnProperty.ORCL_USER
					                           ,CsiConnProperty.ORCL_PASS);
			
		}catch (Exception e) {
			System.out.println(   "ConnProperty :: 데이터베이스를 연결하는데 \n"
					            + "드라이버 또는 연결 과정에서 문제가 생김 >>> : \n" 
								+ e.getMessage() + "\n");
		}
		return conn;
	}
	
//	connection 을 close 하는 함수 입력값으로 디비 연결 3종 셋트 넣음 => 리턴값 없음 		
	public static void conClose(Connection conn, PreparedStatement pstmt, ResultSet rsRs) {
		
		try{
			if (rsRs != null) try { rsRs.close(); rsRs = null; } catch(Exception ex){}
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
			
		}catch (Exception e2){}			
	}

//  하나 더 있음!!! 왜인지?! ResultSet 안쓰는 경우도 닫아야 하니까!
//  (추측) 아마 출력하는 함수에서는 ResultSet 이 필요하니 입력하는 함수에서 닫을 때 쓰일듯	
	public static void conClose(Connection conn, PreparedStatement pstmt) {
		
		try{			
			if (pstmt != null) try { pstmt.close(); pstmt = null; } catch(Exception ex){}
			if (conn != null) try { conn.close(); conn = null; } catch(Exception ex){}
			
		}catch (Exception e2){}			
	}	
}	
