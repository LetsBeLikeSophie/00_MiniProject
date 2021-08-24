package com.kosmo.csi.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kosmo.common.CsiConnProperty;
import com.kosmo.csi.board.sql.CsiBoardSqlMap;
import com.kosmo.csi.board.vo.CsiBoardVO;

public class CsiBoardDAOImpl implements CsiBoardDAO {

	@Override
	public ArrayList<CsiBoardVO> cboardSelectAll() {
		
		System.out.println("CsiBoardDAOImpl cboardSelectAll() 함수 진입 >>> : ");		
		
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rsRs = null;
		
		ArrayList<CsiBoardVO> aList = null;
		
		try{
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiBoardSqlMap.getCboardSelectAllQueryMap());
			System.out.println("전체조회 :: \n" + CsiBoardSqlMap.getCboardSelectAllQueryMap());
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null){	
				aList = new ArrayList<CsiBoardVO>();
			
				while (rsRs.next()){
					
					CsiBoardVO _cvo = new CsiBoardVO();
					_cvo.setBnum(rsRs.getString(1));
					_cvo.setBsubject(rsRs.getString(2));
					_cvo.setBwriter(rsRs.getString(3));
					_cvo.setBcontents(rsRs.getString(4));
					_cvo.setBpw(rsRs.getString(5));					
					_cvo.setDeleteyn(rsRs.getString(6));
					_cvo.setInsertdate(rsRs.getString(7));
					_cvo.setUpdatedate(rsRs.getString(8));
					
					aList.add(_cvo);
				}
			}
			CsiConnProperty.conClose(conn, pstmt, rsRs);
			
		}catch (Exception sq) {
			
			System.out.println(" 전체조회 DB 에러 " + sq.getMessage());
			System.out.println(" 에러 :: " + sq);
			
		}finally{
			
			CsiConnProperty.conClose(conn, pstmt, rsRs);	
		}
		
		return aList;
	}	

	@Override
	public ArrayList<CsiBoardVO> cboardSelect(CsiBoardVO cvo) {

		System.out.println("CsiBoardDAOImpl cboardSelect() 함수 진입 >>> : ");		
		
		Connection        conn = null;
		PreparedStatement pstmt = null;
		ResultSet         rsRs = null;
		
		ArrayList<CsiBoardVO> aList = null;
		
		try{
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiBoardSqlMap.getCboardSelectQueryMap());
			System.out.println("조건조회 :: \n" + CsiBoardSqlMap.getCboardSelectQueryMap());
			
			pstmt.clearParameters();
			pstmt.setString(1, cvo.getBnum());
			rsRs = pstmt.executeQuery();
			
			if (rsRs !=null){	
				aList = new ArrayList<CsiBoardVO>();
			
				while (rsRs.next()){
					
					CsiBoardVO _cvo = new CsiBoardVO();
					_cvo.setBnum(rsRs.getString(1));
					_cvo.setBsubject(rsRs.getString(2));
					_cvo.setBwriter(rsRs.getString(3));
					_cvo.setBcontents(rsRs.getString(4));
					_cvo.setBpw(rsRs.getString(5));					
					_cvo.setDeleteyn(rsRs.getString(6));
					_cvo.setInsertdate(rsRs.getString(7));
					_cvo.setUpdatedate(rsRs.getString(8));
					
					aList.add(_cvo);
				}
			}
			
			CsiConnProperty.conClose(conn, pstmt, rsRs);
			
		}catch (Exception sq){
			
			System.out.println(" 전체조회 DB 에러 " + sq.getMessage());
			System.out.println(" 에러 :: " + sq);
			
		}finally{
			
			CsiConnProperty.conClose(conn, pstmt, rsRs);	
		}
		return aList;
	}

	@Override
	public int cboardInsert(CsiBoardVO cvo) {

		System.out.println("CsiBoardDAOImpl cboardInsert() 함수 진입 >>> : ");

		Connection        conn = null;
		PreparedStatement pstmt = null;		
		int nCnt = 0;
		
		try{
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiBoardSqlMap.getCboardInsertQueryMap());
			System.out.println("인서트 :: \n" + CsiBoardSqlMap.getCboardInsertQueryMap());
			
			pstmt.clearParameters();
			pstmt.setString(1, cvo.getBnum());
			pstmt.setString(2, cvo.getBsubject());
			pstmt.setString(3, cvo.getBwriter());
			pstmt.setString(4, cvo.getBcontents());	
			pstmt.setString(5, cvo.getBpw());			
								
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();						
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");			
			
			CsiConnProperty.conClose(conn, pstmt);
			
		}catch (Exception sq){
			
			System.out.println(" 인서트 DB 에러 " + sq.getMessage());
			System.out.println(" 에러 :: " + sq);
			
		}finally{
			
			CsiConnProperty.conClose(conn, pstmt);	
		}
		return nCnt;
	}

	public int cboardUpdate(CsiBoardVO cvo) {

		System.out.println("CsiBoardDAOImpl cboardUpdate() 함수 진입 >>> : ");
		
		Connection        conn = null;
		PreparedStatement pstmt = null;		
		int nCnt = 0;
		
		try{
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiBoardSqlMap.getCboardUpdateQueryMap());
			System.out.println("업데이트 :: \n" + CsiBoardSqlMap.getCboardUpdateQueryMap());
			
			pstmt.clearParameters();
			pstmt.clearParameters();
			pstmt.setString(1, cvo.getBsubject());
			pstmt.setString(2, cvo.getBcontents());
			pstmt.setString(3, cvo.getBnum());						
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();						
			System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음 ");			
			
			CsiConnProperty.conClose(conn, pstmt);
		}catch (Exception sq){
			System.out.println(" 업데이트 DB 에러 " + sq.getMessage());
			System.out.println(" 에러 :: " + sq);
		}finally{
			CsiConnProperty.conClose(conn, pstmt);	
		}
		
		return nCnt;
	}

	public int cboardDelete(CsiBoardVO cvo) {

		System.out.println("CsiBoardDAOImpl cboardDelete() 함수 진입 >>> : ");
		
		Connection        conn = null;
		PreparedStatement pstmt = null;		
		int nCnt = 0;
		
		try{
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiBoardSqlMap.getCboardDeleteQueryMap());
			System.out.println("딜리트 :: \n" + CsiBoardSqlMap.getCboardDeleteQueryMap());
			
			pstmt.clearParameters();
			pstmt.setString(1, cvo.getBnum());						
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();						
			System.out.println("nCnt >>> : " + nCnt + " 건 삭제 되었음 ");			
			
			CsiConnProperty.conClose(conn, pstmt);
		}catch (Exception sq){
			System.out.println(" 딜리트 DB 에러 " + sq.getMessage());
			System.out.println(" 에러 :: " + sq);
		}finally{
			CsiConnProperty.conClose(conn, pstmt);	
		}
		
		return nCnt;
	}



}
