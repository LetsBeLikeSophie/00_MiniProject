package com.kosmo.csi.login.sql;

public abstract class CsiLoginQueryMap {
	
	// 로그인 확인
	public static String getcLoginCheckQuery() {
			
		StringBuffer sb = new StringBuffer();			
		sb.append(" SELECT 								\n");
		sb.append("       COUNT(A.CNUM)  NCNT 			\n");		
	    sb.append("	FROM 								\n");	    
	    sb.append("		  CSI_MEMBER 	A 				\n");
	    sb.append("	WHERE A.DELETEYN 	= 'Y'			\n");	    
	    sb.append("	AND   A.CID 	  	= ?				\n");
	    sb.append("	AND   A.CPW  		= ?   			\n");

	    return sb.toString();
	}

}
