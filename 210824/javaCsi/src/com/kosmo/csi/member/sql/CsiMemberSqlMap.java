package com.kosmo.csi.member.sql;


// sql 에서는(또는 문자열을 나열하는 경우에는) StringBuffer를 이용해서 append 함 (계속 붙여줌)

// StringBuffer => java.lang.StringBuffer

// 				=> [delete(index, index) first index to second [index - 1]
//				=> [deleteChatAt(index)]
//				=> [append()]
//				=> [reverse()] 		: 영구히 reverse 다시 바꾸지 않는한, 사용시 index 조심
//				=> [toString()]		: 말그대로 StringBuffer 내에 있는 문자열을 표현해줌


// SqlMap Class 에서는 말 그대로 StringBuffer로 query문을 만들어준다.
public abstract class CsiMemberSqlMap {
	
// 채번쿼리 뒷자리 숫자 4개를 선택함 : 회원 번호 형식이 날짜+숫자이기 때문 & PK
	public static String getCsiMemberChabunQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT  											\n");
		sb.append("         NVL(MAX(SUBSTR(A.HNUM, -4)), 0) + 1 COMMNO	\n");
		sb.append(" FROM    CSI_MEMBER A 								\n");	   	  

	    return sb.toString();
	}
	
// 전체선택 쿼리 : Select all :  : WHERE DELETEYN이 Y
	public static String getCsiMemberSelectAllQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.CNUM 		CNUM 			\n");
		sb.append("		,A.CNAME  		CNAME 			\n");
		sb.append("		,A.CID  		CID 			\n");
	    sb.append("		,A.CPW  		CPW   			\n");
	    sb.append("		,A.CBIRTH  		CBIRTH 			\n");
		sb.append("		,A.CGENDER  	CGENDER 		\n");
	    sb.append("		,A.CTEL  		CTEL   			\n");
	    sb.append("		,A.CHP  		CHP 			\n");
		sb.append("		,A.CEMAIL  		CEMAIL 			\n");		
	    sb.append("		,A.CADDR  		CADDR   		\n");
	    sb.append("		,A.CHOBBY  		CHOBBY 			\n");
	    sb.append("		,A.CPHOTO  		CPHOTO 			\n");
		sb.append("		,A.CSKILL  		CSKILL 			\n");
	    sb.append("		,A.CJOB  		CJOB   			\n");
	    sb.append("		,A.DELETEYN 	DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 CSI_MEMBER A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	ORDER BY 1 DESC						\n");

	    return sb.toString();
	}
	
// 부분선택 쿼리 : Select : WHERE DELETEYN이 Y, CNAME이 ? : CNAME 에 placeholder 를 두어 나중에 값을 지정하게 함
	public static String getCsiMemberSelectQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.CNUM 		CNUM 			\n");
		sb.append("		,A.CNAME  		CNAME 			\n");
		sb.append("		,A.CID  		CID 			\n");
	    sb.append("		,A.CPW  		CPW   			\n");
	    sb.append("		,A.CBIRTH  		CBIRTH 			\n");
		sb.append("		,A.CGENDER  	CGENDER 		\n");
	    sb.append("		,A.CTEL  		CTEL   			\n");
	    sb.append("		,A.CHP  		CHP 			\n");
		sb.append("		,A.CEMAIL  		CEMAIL 			\n");		
	    sb.append("		,A.CADDR  		CADDR   		\n");
	    sb.append("		,A.CHOBBY  		CHOBBY 			\n");
	    sb.append("		,A.CPHOTO  		CPHOTO 			\n");
		sb.append("		,A.CSKILL  		CSKILL 			\n");
	    sb.append("		,A.CJOB  		CJOB   			\n");
	    sb.append("		,A.DELETEYN 	DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	
	    sb.append("	FROM 								\n");
	    sb.append("		 CSI_MEMBER A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.CNUM   = ?					\n"); 

	    return sb.toString();
	}
	
// 삽입 쿼리 : Insert : VALUES 안 값들을 PLACEHOLDER 로 지정 >> 나중에 추가 할 수 있게 함
	public static String getCsiMemberInsertQuery() {
 
		StringBuffer sb = new StringBuffer();			
		sb.append("	INSERT INTO 						\n");	
		sb.append("		CSI_MEMBER 				    	\n");
		sb.append("		          (			    		\n");
		sb.append("      			 CNUM 				\n"); 
		sb.append("					,CNAME 				\n"); 
		sb.append("					,CID 				\n"); 
	    sb.append("					,CPW   				\n");
	    sb.append("					,CBIRTH				\n");     
	    sb.append("					,CGENDER 			\n");     
	    sb.append("					,CTEL   			\n");     
	    sb.append("					,CHP 				\n");     	    
	    sb.append("					,CEMAIL				\n"); 
	    sb.append("					,CADDR 				\n");   	    
	    sb.append("					,CHOBBY				\n"); 
	    sb.append("					,CPHOTO 			\n"); 
	    sb.append("					,CSKILL				\n"); 
	    sb.append("					,CJOB				\n"); 	    	  
	    sb.append("					,DELETEYN			\n"); 
	    sb.append("					,INSERTDATE			\n"); 
	    sb.append("					,UPDATEDATE			\n"); 
		sb.append("			      )						\n");
		sb.append("	       VALUES   					\n");
		sb.append("	       		 (  					\n");
		sb.append("     				 ? 				\n"); 
		sb.append("						,? 				\n"); 
	    sb.append("						,?   			\n"); 
	    sb.append("						,?   			\n"); 
	    sb.append("						,? 				\n"); 
	    sb.append("						,? 				\n"); 
	    sb.append("						,?				\n"); 
	    sb.append("						,?				\n"); 
	    sb.append("						,?				\n"); 
	    sb.append("						,?   			\n"); 
	    sb.append("						,? 				\n"); 
	    sb.append("						,? 				\n"); 
	    sb.append("						,?				\n"); 
	    sb.append("						,?				\n"); 
	    sb.append("						,'Y'			\n"); 
	    sb.append("						,SYSDATE 		\n"); 
	    sb.append("						,SYSDATE 		\n"); 
		sb.append("	              )						\n");		
		
		return sb.toString();
	}
	
// 수정 쿼리 : Update : WHERE DELETEYN이 Y, CNUM이 ? : CNUM 에 placeholder 를 두어 나중에 값을 지정하게 함
	public static String getCsiMemberUpdateQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   	 CSI_MEMBER 			    \n");	
		sb.append("	SET  								\n");		
		sb.append("			 CEMAIL 		= ?			\n"); 	    	    
		sb.append("			,CADDR			= ?			\n");	    
		sb.append("			,CHOBBY 		= ? 		\n");
		sb.append("			,CJOB   		= ?			\n");        		
	    sb.append("		  	,UPDATEDATE 	= SYSDATE	\n");
		sb.append("	WHERE  	 CNUM 			= ?			\n"); 	    
		sb.append("	AND    	 DELETEYN 		= 'Y'  		\n");		
					
		return sb.toString();
	}	
	
// 삭제 쿼리 : Delete	
	public static String getCsiMemberDeleteQuery() {
		
		StringBuffer sb = new StringBuffer();			
		sb.append("	UPDATE  							\n");	
		sb.append("		   CSI_MEMBER 			    	\n");	
		sb.append("	SET  								\n");
	    sb.append("		   DELETEYN 	= 'N'			\n");	    	   
	    sb.append("		  ,UPDATEDATE 	= SYSDATE		\n");
		sb.append("	WHERE  CNUM 		= ?				\n");	  	// placeholder
		sb.append("	AND    DELETEYN 	= 'Y'  			\n");		// 나중에 execute() 함수와
					
		return sb.toString();
	}	
	
// 이름 선택 쿼리  : WHERE DELETEYN이 Y, CNAME가 ? : CNAME 에 placeholder 를 두어 나중에 값을 지정하게 함
	public static String getCsiMemberSelectNameQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.CNUM 		CNUM 			\n");
		sb.append("		,A.CNAME  		CNAME 			\n");
		sb.append("		,A.CID  		CID 			\n");
	    sb.append("		,A.CPW  		CPW   			\n");
	    sb.append("		,A.CBIRTH  		CBIRTH 			\n");
		sb.append("		,A.CGENDER  	CGENDER 		\n");
	    sb.append("		,A.CTEL  		CTEL   			\n");
	    sb.append("		,A.CHP  		CHP 			\n");
		sb.append("		,A.CEMAIL  		CEMAIL 			\n");		
	    sb.append("		,A.CADDR  		CADDR   		\n");
	    sb.append("		,A.CHOBBY  		CHOBBY 			\n");
	    sb.append("		,A.CPHOTO  		CPHOTO 			\n");
		sb.append("		,A.CSKILL  		CSKILL 			\n");
	    sb.append("		,A.CJOB  		CJOB   			\n");
	    sb.append("		,A.DELETEYN 	DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 CSI_MEMBER A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.CNAME LIKE '%' || ? || '%' 	\n"); // placeholder 1

	    return sb.toString();
	}
	
// 아이디 선택 쿼리 : WHERE DELETEYN이 Y, CID가 ? : CID 에 placeholder 를 두어 나중에 값을 지정하게 함
	public static String getCsiMemberSelectIdQuery(){
		
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("      A.CNUM 		CNUM 			\n");
		sb.append("		,A.CNAME  		CNAME 			\n");
		sb.append("		,A.CID  		CID 			\n");
	    sb.append("		,A.CPW  		CPW   			\n");
	    sb.append("		,A.CBIRTH  		CBIRTH 			\n");
		sb.append("		,A.CGENDER  	CGENDER 		\n");
	    sb.append("		,A.CTEL  		CTEL   			\n");
	    sb.append("		,A.CHP  		CHP 			\n");
		sb.append("		,A.CEMAIL  		CEMAIL 			\n");		
	    sb.append("		,A.CADDR  		CADDR   		\n");
	    sb.append("		,A.CHOBBY  		CHOBBY 			\n");
	    sb.append("		,A.CPHOTO  		CPHOTO 			\n");
		sb.append("		,A.CSKILL  		CSKILL 			\n");
	    sb.append("		,A.CJOB  		CJOB   			\n");
	    sb.append("		,A.DELETEYN 	DELETEYN		\n");
	    sb.append("		,TO_CHAR(A.INSERTDATE, 'YYYY-MM-DD')  INSERTDATE	\n");
	    sb.append("		,TO_CHAR(A.UPDATEDATE, 'YYYY-MM-DD')  UPDATEDATE	\n");	    
	    sb.append("	FROM 								\n");
	    sb.append("		 CSI_MEMBER A 					\n");
	    sb.append("	WHERE DELETEYN = 'Y'				\n");
	    sb.append("	AND   A.CID LIKE '%' || ? || '%' 	\n");

	    return sb.toString();
	}	
}
