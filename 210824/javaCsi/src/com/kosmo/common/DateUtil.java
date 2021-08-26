package com.kosmo.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {

// 	날짜 형식 만들어 놓기	
	public static String yyyymmdd() {		
		return new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
	}
		
	public static String yyyymm() {		
		return new SimpleDateFormat("yyyyMM").format(new Date()).toString();
	}
	
	public static String yyyy() {		
		return new SimpleDateFormat("yyyy").format(new Date()).toString();
	}

//  잘은 모르겠으나	
	public static String cTime(){
		
		long time = System.currentTimeMillis();	
		
//		강사님 주석 옮김		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
//		String cTime = sdf.format(new java.util.Date(time));
//		return cTime;
		
		return new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date(time)).toString();
	}

//  여기서 부터 combo 년, 월, 일 함수
//	그 클릭했을 때 아래로 펼쳐지면서 선택하나 하게끔 만드는게 목적.
//	배열로 각 숫자들을 입력해줌
	
	public static String[] comboYear(){
		
		int currentYear = Integer.parseInt(DateUtil.yyyy());
		int firstYear = 1900;
		
//		2021 - 1900 => 121 + 2 => 123 
//		???????? 왜 123년도 만큼 뽑으려 하시는지는 잘 이해가 안감. 빼고 그냥 2칸 여유있게? 라고 추측
//		어쨌든 배열의 크기는 123		
		String[] years = new String[currentYear - firstYear + 2];
//		첫번째에는 "년도"가 들어감  >> 그 쭈욱 밑으로 여러개 같이 나오는 거 생각하면 됨
//		두번째부터 각 년도 출력, currentYear-- 내림차순 (아래로 갈 수록 오래된 년도 /적은 숫자)		
		years[0] = "년도";
		
		for (int i=1; i < years.length; i++ ){
			years[i] = String.valueOf(currentYear--);
		}
		return years;
	}
	
	public static String[] comboMonth(){
		
// 		위와 같은 방식 월 표시하기		
		String[] months = new String[13];
		months[0] = "월";
		
		for (int i=1; i < months.length; i++ ){		
			months[i] = String.valueOf(i);

//			월의 자릿수가 1자리면 0붙여줌 (아 이 방법이 있네!)			
			if (1 == months[i].length()) {
				months[i] = "0" + i;
			}
		}
		return months;
	}

	public static String[] comboDay(){
		
		String[] days = new String[32];
		days[0] = "일";
		
		for (int i=1; i <days.length; i++ ){
			days[i] = String.valueOf(i);
			
			if (1 == days[i].length()) {
				days[i] = "0" + i;
			}
		}
		return days;
	}		
	
	public static void main(String args[]) {
		String d = DateUtil.yyyymmdd();
		System.out.println("d >>> : " + d); 					// 20210824
		System.out.println("dt >>> : " + DateUtil.cTime());		// 20210824 18:14:20 
//		Month 배열 출력 
		String m[] = DateUtil.comboMonth();						
		for (int i=0; i < m.length; i++) {
			System.out.println("m["+i+"] >>> : " + m[i]);
		}
	}
}
