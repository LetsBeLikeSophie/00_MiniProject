package com.kosmo.csi.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosmo.common.CsiConnProperty;
import com.kosmo.csi.login.sql.CsiLoginQueryMap;
import com.kosmo.csi.member.vo.CsiMemberVO;



public class CsiLoginDAOImpl implements CsiLoginDAO {

	@Override
	public int cLoginCheck(CsiMemberVO cvo) {
		// TODO Auto-generated method stub
		System.out.println("HbeLoginDAOImpl cLoginCheck() 함수 진입 >>> : ");		
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기 
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rsRs = null;
		int nCnt = 0;
		
		try{
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiLoginQueryMap.getcLoginCheckQuery());
			System.out.println("로그인 체크  :: \n" + CsiLoginQueryMap.getcLoginCheckQuery());
			
			pstmt.clearParameters();
			pstmt.setString(1, cvo.getCid());
			pstmt.setString(2, cvo.getCpw());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null){	
				while (rsRs.next()){
					nCnt = rsRs.getInt(1);
				}
			}
			
			CsiConnProperty.conClose(conn, pstmt, rsRs);
		}catch (Exception sq){
			System.out.println(" 로그인체크 DB 에러 " + sq.getMessage());
			System.out.println(" 에러 :: " + sq);
		}finally{
			CsiConnProperty.conClose(conn, pstmt, rsRs);	
		}
		
		return nCnt;
	}
}
