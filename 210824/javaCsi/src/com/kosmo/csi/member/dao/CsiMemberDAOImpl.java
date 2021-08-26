package com.kosmo.csi.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kosmo.common.CsiConnProperty;
import com.kosmo.csi.member.sql.CsiMemberSqlMap;
import com.kosmo.csi.member.vo.CsiMemberVO;

// * [CsiMemberDAO]
//	 [CsiMemberDAOImpl] 				 : 	Interface + Implement 
//										 : 	Interface 와 Implement 의 역할이 그렇듯, Interface 엔 뭘 어떻게 사용할건지만 정의
//										 : 	Implement 에 안을 구성해주면 됨.
//										 :	DAO 세트는 Service 세트 와 분리 되어 나누어지고, Service 에서 그대로 넘겨온 왔기 때문에 내용을 정의 해줘야 함.

// 1. CsiMemberDAO 의 Implement 
// 2. CsiMemberDAO(인터페이스)의 구성		 : 	[4개의 ArrayList 타입의 Methods] : (1개만 with no argument : selectAll 시 입력값 없음)
//							  			 :	[3개의 boolean 타입의 Methods]   

// 3. Implement의 함수(경고)에 관하여			 : 	@Override 안하면 어짜피 Override 하라고 계속 경고
//										 : 	interface 함수 내에 정의 되어 있는 methods 가 하나라도 없으면 경고 나오기도 함
// 4. (중요) 표시는 그 전에 잘 몰랐던것

public class CsiMemberDAOImpl implements CsiMemberDAO {

//	전체 선택 : SelectAll
	@Override
	public ArrayList<CsiMemberVO> cmemSelectAll() {

// 		함수진입 로그
		System.out.println("CsiMemberDAOImpl.cmemSelectAll() 함수 진입 ");

// 		사용할 변수 초기화 (디비 연결 할 3종 셋트 + ArrayList (저장값) 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;		
		ArrayList<CsiMemberVO> aList = null;

// 		try/catch 구문 (어짜피 안쓰면 또 경고 나옴 => Exception 때문에)
		try {

//   	 	디비 연결부분 
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberSelectAllQuery());
			System.out.println("전체조회 \n" + CsiMemberSqlMap.getCsiMemberSelectAllQuery());			
			rsRs = pstmt.executeQuery();			

// 			if ResultSet 에 값이 있으면 => 쿼리를 보낼 경우 오라클에서 반환되는 값이 있음. 없으면 실행하지 말아라!
			if (rsRs !=null) {
				
//				ArryList 도 지정해줌 				
				aList = new ArrayList<CsiMemberVO>();

// 				while ResultSet 이 끝날 때까지 계속 돌아라!				
				while (rsRs.next()) {
					
					CsiMemberVO cvo = new CsiMemberVO();
					
//					ResultSet에 있는 1번 인덱스 값을 String으로 가져와서 cvo 의 setter를 통해 전역변수로(Global variable로)변환					
					cvo.setCnum(rsRs.getString(1)); 
					cvo.setCname(rsRs.getString(2)); 
					cvo.setCid(rsRs.getString(3));
					cvo.setCpw(rsRs.getString(4));
					cvo.setCbirth(rsRs.getString(5));
					cvo.setCgender(rsRs.getString(6));
					cvo.setCtel(rsRs.getString(7));
					cvo.setChp(rsRs.getString(8));
					cvo.setCemail(rsRs.getString(9));
					cvo.setCaddr(rsRs.getString(10));
					cvo.setChobby(rsRs.getString(11));
					cvo.setCphoto(rsRs.getString(12));
					cvo.setCskill(rsRs.getString(13));
					cvo.setCjob(rsRs.getString(14));
					cvo.setDeleteyn(rsRs.getString(15));
					cvo.setInsertdate(rsRs.getString(16));
					cvo.setUpdatedate(rsRs.getString(17));
					
//					다하고 ArrayList에 예쁘게 저장 (ArrayList는 가변배열, 더하면 더하는데로 차곡차곡 넣음) 					
					aList.add(cvo);
				}				
			}
			
// 		에러-예외-가 생겼을 시 어디에서 생긴 건지 무엇인지를 메시지로 표현			
		}catch(Exception e) {
			System.out.println("cmemSelectAll() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
		}
		return aList;
	}

	
//---------------------------------아래부터 위와 중복되는 주석은 생략 또는 간략히 적음---------------------------------
	
// 	부분 선택 : Select 
	@Override
	public ArrayList<CsiMemberVO> cmemSelect(CsiMemberVO cvo) {

		System.out.println("CsiMemberDAOImpl.cmemSelect() 함수 진입 ");
		CsiMemberVO.printlnCsiMemberVO(cvo);

// 		변수 초기화
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<CsiMemberVO> aList = null;

//		try/catch 구문		
		try {
			
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberSelectQuery());
			System.out.println("조건조회 \n" + CsiMemberSqlMap.getCsiMemberSelectQuery());

// (중요)		statement 를 clear  			
			pstmt.clearParameters();
// 			parameter 설정해줌 
// (중요)		parameter 란 함수에 붙여서 보내는 것. 어디선 argument 랑 같다고 설명하는데, 더 찾아보니 차이점이 있음.
//			둘다 값으로 들어가는데 함수 이름(요기) parameter 는 값으로 이미 정해져 있는 애들, argument 는 내가 정의할 수 있는거라 마음대로 (형식만 맞으면)  
//			statement 에 setString 이라는 함수 자체가 특정 짓는 역할을 하는듯.
			pstmt.setString(1, cvo.getCnum());
//			선택한 1번 number만 statement 에 붙이고 그 값만 ResultSet에 넘겨줌
			rsRs = pstmt.executeQuery();			
						
			if (rsRs !=null) {
				
				aList = new ArrayList<CsiMemberVO>();

//				ResultSet 에 담은 내용 출력 부분
				while (rsRs.next()) {
					
					CsiMemberVO _cvo = new CsiMemberVO();
					
					_cvo.setCnum(rsRs.getString(1)); 
					_cvo.setCname(rsRs.getString(2)); 
					_cvo.setCid(rsRs.getString(3));
					_cvo.setCpw(rsRs.getString(4));
					_cvo.setCbirth(rsRs.getString(5));
					_cvo.setCgender(rsRs.getString(6));
					_cvo.setCtel(rsRs.getString(7));
					_cvo.setChp(rsRs.getString(8));
					_cvo.setCemail(rsRs.getString(9));
					_cvo.setCaddr(rsRs.getString(10));
					_cvo.setChobby(rsRs.getString(11));
					_cvo.setCphoto(rsRs.getString(12));
					_cvo.setCskill(rsRs.getString(13));
					_cvo.setCjob(rsRs.getString(14));
					_cvo.setDeleteyn(rsRs.getString(15));
					_cvo.setInsertdate(rsRs.getString(16));
					_cvo.setUpdatedate(rsRs.getString(17));
										
					aList.add(_cvo);
				}				
			}
		}catch(Exception e) {
			System.out.println("cmemSelect() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
		}
		
		return aList;
	}

//  조건 검색, 이름으로 	
	@Override
	public ArrayList<CsiMemberVO> cmemSelectName(CsiMemberVO cvo) {

//		로그
		System.out.println("CsiMemberDAOImpl.cmemSelectName() 함수 진입 ");
		CsiMemberVO.printlnCsiMemberVO(cvo);

//		디비연결 셋트 + 결과값 담을 ArryaList 선언 및 조기화		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<CsiMemberVO> aList = null;
		
//		try/catch 구문		
		try {
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberSelectNameQuery());
			System.out.println("조건조회 :: 회원이름 :: \n" + CsiMemberSqlMap.getCsiMemberSelectNameQuery());
			
// 			parameter = cname			
			pstmt.clearParameters();
			pstmt.setString(1, cvo.getCname());
			rsRs = pstmt.executeQuery();			
						
			if (rsRs !=null) {
				
				aList = new ArrayList<CsiMemberVO>();

//				ResultSet 출력 부분				
				while (rsRs.next()) {
					
					CsiMemberVO _cvo = new CsiMemberVO();
					_cvo.setCnum(rsRs.getString(1)); 
					_cvo.setCname(rsRs.getString(2)); 
					_cvo.setCid(rsRs.getString(3));
					_cvo.setCpw(rsRs.getString(4));
					_cvo.setCbirth(rsRs.getString(5));
					_cvo.setCgender(rsRs.getString(6));
					_cvo.setCtel(rsRs.getString(7));
					_cvo.setChp(rsRs.getString(8));
					_cvo.setCemail(rsRs.getString(9));
					_cvo.setCaddr(rsRs.getString(10));
					_cvo.setChobby(rsRs.getString(11));
					_cvo.setCphoto(rsRs.getString(12));
					_cvo.setCskill(rsRs.getString(13));
					_cvo.setCjob(rsRs.getString(14));
					_cvo.setDeleteyn(rsRs.getString(15));
					_cvo.setInsertdate(rsRs.getString(16));
					_cvo.setUpdatedate(rsRs.getString(17));
										
					aList.add(_cvo);
										
				}				
			}
		}catch(Exception e) {
			System.out.println("cmemSelectName() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
		}
		
		return aList;
	}

//  조건 검색, 아이디로	
	@Override
	public ArrayList<CsiMemberVO> cmemSelectId(CsiMemberVO cvo) {

//		로그		
		System.out.println("CsiMemberDAOImpl.cmemSelectId() 함수 진입 ");
		CsiMemberVO.printlnCsiMemberVO(cvo);

//		디비연결 셋트 + 결과값 담을 ArryaList 선언 및 조기화		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		
		ArrayList<CsiMemberVO> aList = null;
		
		try {
			conn = CsiConnProperty.getConnection();
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberSelectNameQuery());
			System.out.println("조건조회 :: 회원이름 :: \n" + CsiMemberSqlMap.getCsiMemberSelectNameQuery());
			
//			parameter = cid			
			pstmt.clearParameters();
			pstmt.setString(1, cvo.getCid());
			rsRs = pstmt.executeQuery();			
						
			if (rsRs !=null) {
				
				aList = new ArrayList<CsiMemberVO>();
				
//				ResultSet 출력 부분						
				while (rsRs.next()) {
					
					CsiMemberVO _cvo = new CsiMemberVO();
					_cvo.setCnum(rsRs.getString(1)); 
					_cvo.setCname(rsRs.getString(2)); 
					_cvo.setCid(rsRs.getString(3));
					_cvo.setCpw(rsRs.getString(4));
					_cvo.setCbirth(rsRs.getString(5));
					_cvo.setCgender(rsRs.getString(6));
					_cvo.setCtel(rsRs.getString(7));
					_cvo.setChp(rsRs.getString(8));
					_cvo.setCemail(rsRs.getString(9));
					_cvo.setCaddr(rsRs.getString(10));
					_cvo.setChobby(rsRs.getString(11));
					_cvo.setCphoto(rsRs.getString(12));
					_cvo.setCskill(rsRs.getString(13));
					_cvo.setCjob(rsRs.getString(14));
					_cvo.setDeleteyn(rsRs.getString(15));
					_cvo.setInsertdate(rsRs.getString(16));
					_cvo.setUpdatedate(rsRs.getString(17));
										
					aList.add(_cvo);
				}				
			}
		}catch(Exception e) {
			System.out.println("cmemSelectId() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
		}
		
		return aList;
	}	
	
// 삽입 : Insert	
	@Override
	public boolean cmemInsert(CsiMemberVO cvo) {
		
		System.out.println("CsiMemberDAOImpl cmemInsert() 함수 진입 >>> : ");
		CsiMemberVO.printlnCsiMemberVO(cvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {			
			conn = CsiConnProperty.getConnection();
			
// (중요)		conn.getAutoCommit() => AutoCommit 모드로 설정해줌
//			아마도 커밋해주기 위한 사전작업 같음 데이터를 넣어야하기 때문
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberInsertQuery());
			System.out.println("입력하기 >>> : \n"+ CsiMemberSqlMap.getCsiMemberInsertQuery());
  			
			pstmt.clearParameters();
			
			pstmt.setString(1, cvo.getCnum()); 
			pstmt.setString(2, cvo.getCname()); 
			pstmt.setString(3, cvo.getCid());   
			pstmt.setString(4, cvo.getCpw());
			pstmt.setString(5, cvo.getCbirth());
			pstmt.setString(6, cvo.getCgender());
			pstmt.setString(7, cvo.getCtel());
			pstmt.setString(8, cvo.getChp());			
			pstmt.setString(9, cvo.getCemail());
			pstmt.setString(10, cvo.getCaddr());
			pstmt.setString(11, cvo.getChobby());
			pstmt.setString(12, cvo.getCphoto());
			pstmt.setString(13, cvo.getCskill());
			pstmt.setString(14, cvo.getCjob());

// (중요)		statement 를 	: 1. execute 		>> 결과 값 boolean execute 여부만 알려줌
//							  2. executeQuery  	>> 결과 값 ResultSet 에 내용 담음 			
//												   SELECT 구문에서 사용!!!!!
// 							  3. executeUpdate 	>> 결과 값 int							
//												   INSERT / DELETE / UPDATE 관련 구문에서는 반영된 레코드의 건수를 반환!!
//												   CREATE / DROP 관련 구문에서는 -1 을 반환!!
//												   SELECT 구문 제외한 구문에서 사용!!!!!
			nCnt = pstmt.executeUpdate();		
			
			if (!conn.getAutoCommit()) { conn.commit(); }			
			
			System.out.println("nCnt >>> : " + nCnt + " 건 등록 되었음 ");
			
//			위의 주석 때문에 숫자를 count 하고 업데이트 되면 bool 을 true 로 바꾸어서 표시해줌
			if (nCnt > 0) { bool = true; }
			
			CsiConnProperty.conClose(conn, pstmt);
		}catch(Exception e) {
			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
		}finally {
			try {
				CsiConnProperty.conClose(conn, pstmt);				
			}catch(Exception e2) {}
		}
				
		return bool;
	}

//  수정 : Update
	@Override
	public boolean cmemUpdate(CsiMemberVO cvo) {

//		로그		
		System.out.println("CsiMemberDAOImpl cmemUpdate() 함수 진입 >>> : ");
		CsiMemberVO.printlnCsiMemberVO(cvo);

//		디비연결 셋트 + 결과값 담을 ArryaList 선언 및 조기화				
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {			
			conn = CsiConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberUpdateQuery());
			System.out.println("수정하기 >>> : \n"+ CsiMemberSqlMap.getCsiMemberUpdateQuery());

			pstmt.clearParameters();
//			after parameter cleared, cvo의 정보를 statement에 저장 			
			pstmt.setString(1, cvo.getCemail());
			pstmt.setString(2, cvo.getCaddr());
			pstmt.setString(3, cvo.getChobby());			
			pstmt.setString(4, cvo.getCjob());
			pstmt.setString(5, cvo.getCnum()); 

//			commit이 되었는지 (!conn.getAutoCommit()), commit 수 확인 ((nCnt > 0)일때 bool=true) 하여 출력
			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) { conn.commit(); }			
			
			System.out.println("nCnt >>> : " + nCnt + " 건 수정 되었음 ");
			
			if (nCnt > 0) { bool = true; }

			CsiConnProperty.conClose(conn, pstmt);
			
		}catch(Exception e) {
			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
			
		}finally {
			try {
				CsiConnProperty.conClose(conn, pstmt);
				
			}catch(Exception e2) {}
		}
				
		return bool;
	}

//  삭제 : Delete
	@Override
	public boolean cmemDelete(CsiMemberVO cvo) {

//		로그
		System.out.println("CsiMemberDAOImpl cmemDelete() 함수 진입 >>> : ");
		CsiMemberVO.printlnCsiMemberVO(cvo);

//		디비연결 셋트 + 결과값 담을 ArryaList 선언 및 조기화				
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;

//		try/catch 구문		
		try {
			conn = CsiConnProperty.getConnection();
			System.out.println("conn.getAutoCommit() >>> : " + conn.getAutoCommit());
			
			pstmt = conn.prepareStatement(CsiMemberSqlMap.getCsiMemberDeleteQuery());
			System.out.println("삭제하기 >>> : \n"+ CsiMemberSqlMap.getCsiMemberDeleteQuery());
  			

			pstmt.clearParameters();
			pstmt.setString(1, cvo.getCnum()); 

			nCnt = pstmt.executeUpdate();						
			if (!conn.getAutoCommit()) { conn.commit();	}		
			
			System.out.println("nCnt >>> : " + nCnt + " 건 삭제 되었음 ");
			
			if (nCnt > 0) { bool = true; }
			
			CsiConnProperty.conClose(conn, pstmt);
			
		}catch(Exception e) {
			System.out.println("입력 디비연동에 문제가 생겼습니다. >>> : " + e);
			
		}finally {
			try {
				CsiConnProperty.conClose(conn, pstmt);
				
			}catch(Exception e2) {}
		}
				
		return bool;	
	}
	
}
