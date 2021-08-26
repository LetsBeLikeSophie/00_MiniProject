package com.kosmo;

import com.kosmo.common.CodeUtil;
import com.kosmo.common.DateUtil;

public class Test {

	public static final String[] hobby_lavel = {"게임", "음악감상", "운동", "독서", "영화", "명상"};
	
	public static void main(String[] args) {
		
//		StringBuffer stringBuffer = new StringBuffer();
		
//		String whatever = "0123456789";
//		
//		System.out.println(whatever);
//		System.out.println(stringBuffer.toString());

//		System.out.println(whatever.substring(6));
		
//		
//		String string = "0";
//		int i = 1;
//		String a = "0"+i;
//		
//		System.out.println("0"+i);
//		System.out.println(a);
		
		int currentYear = Integer.parseInt(DateUtil.yyyy());
		System.out.println(currentYear);
		int firstYear = 1900;
		System.out.println(currentYear - firstYear + 2);
		
		}
		
		
}