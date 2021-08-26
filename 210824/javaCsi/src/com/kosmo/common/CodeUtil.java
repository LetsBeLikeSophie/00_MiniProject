package com.kosmo.common;

public abstract class CodeUtil {
	
	public static final String[] member_value = { "회원번호", "회원이름", "아이디", "패스워드", "생년월일", 
			                                      "성별", "전화번호", "휴대폰번호", "이메일", "주소", 
			                                      "취미",  "사진", "특기", "직업", "삭제여부", 
			                                      "등록일", "수정일"};	

	public static final String[] gender_value = {"여자","남자"};
	
	public static final String[] tel_value = {"02","031","032"};
	
	public static final String[] hp_value = {"010","011","017"};
	
	public static final String[] hobby_lavel = {"게임", "음악감상", "운동", "독서", "영화", "명상"};
	public static final String[] hobby_value = {"01", "02", "03", "04", "05", "06"};
	
	public static final String[] job_lavel = {"회사원", "자영업", "학생", "주부", "무직", "시인"};
	public static final String[] job_value = {"01", "02", "03", "04", "05", "06"};
	
//  회원조회  --------------------------------------------------------------------------------------------
	
	public static final String[] combo_cpation = {"----------", "전체", "이름", "아이디"};
	public static final String[] jbtn_cpation = {"회원등록", "수정", "삭제", "회원목록"};
	
//  게시판  ---------------------------------------------------------------------------------------------

	public static final String[] board_label = {"글제목", "작성자", "비밀번호", "글내용"};
	
	
//  1. Birth : 각각 채번 >> 년/월/일로 분리
	public static String birth(String dateOfBirth) {

		String year = "";
		String month = "";
		String date = "";
		String dob = "";
		
		if (dateOfBirth !=null && dateOfBirth.length() > 0){			
			int lengthOfString = dateOfBirth.length();		
			
			if (8 == lengthOfString) {
				year = dateOfBirth.substring(0, 4);
				month = dateOfBirth.substring(4, 6);
				date = dateOfBirth.substring(6);				
				dob = year + "-" + month + "-" + date;
			}
		}		
		return dob;
	}

//  2. Gender : 번호에 따른 분류 >> 01 여자, 02 남자	
	public static String gender(String genderType) {
		
		String genderReturn = "";	
		
		if (genderType !=null && genderType.length() > 0){
			
			if ("01".equals(genderType)) {
				genderReturn = "여자";
				
			}else if ("02".equals(genderType)){
				genderReturn = "남자";
			}			
		}			
		return genderReturn;
	}
	
//  3. Tel : 일반 전화번호 >> 10자리일 경우, 11자리일 경우 
	public static String tel(String telNum) {

		String tel1 = "";
		String tel2 = "";
		String tel3 = "";
		String telReturn = "";
		
		if (telNum !=null && telNum.length() > 0){			
			int lengthOfTelNum = telNum.length();	
			
			if (10 == lengthOfTelNum) {
				tel1 = telNum.substring(0, 2);
				tel2 = telNum.substring(2, 6);
				tel3 = telNum.substring(6);
				telReturn = tel1 + "-" + tel2 + "-" + tel3;
			}		
			
			if (11 == lengthOfTelNum) {
				tel1 = telNum.substring(0, 3);
				tel2 = telNum.substring(3, 7);
				tel3 = telNum.substring(7);
				telReturn = tel1 + "-" + tel2 + "-" + tel3;
			}
		}
		return telReturn;
	}
	
//  4. Hp : 핸드폰 번호 >> 10자리일 경우, 11자리일 경우
	public static String hp(String phoneNum) {

		String phoneNum1 = "";
		String phoneNum2 = "";
		String phoneNum3 = "";
		String phoneNumReturn = "";
		
		if (phoneNum !=null && phoneNum.length() > 0){		
			
			int lengthOfPhoneNum = phoneNum.length();	
			
// (추가)		위에 일반전화번호 처럼 추가함 혹시 10자리일 경우			
			if (10 == lengthOfPhoneNum) {
				phoneNum1 = phoneNum.substring(0, 2);
				phoneNum2 = phoneNum.substring(2, 6);
				phoneNum3 = phoneNum.substring(6);
				phoneNumReturn = phoneNum1 + "-" + phoneNum2 + "-" + phoneNum3;
			}
			
			if (11 == lengthOfPhoneNum) {
				phoneNum1 = phoneNum.substring(0, 3);
				phoneNum2 = phoneNum.substring(3, 7);
				phoneNum3 = phoneNum.substring(7);
				phoneNumReturn = phoneNum1 + "-" + phoneNum2 + "-" + phoneNum3;
			}
		}		
		return phoneNumReturn;
	}

//  5-1. 취미번호 (01,02,..) 받아서 취미명 (게임,음악감상,..) 을 돌려줌 	
	public static String hobby(String hobbyNum) {
		
		String selectedHobby = "";				
		if (hobbyNum !=null && hobbyNum.length() > 0){		
			
//			hobby 종류가 들어있는 배열 hobby_lavel 만큼 for 돌기
			for (int i=1; i < hobby_lavel.length; i++) {	

//				아니 이게 됨.."0" + i => String+int=>String으로 잘 나옴
				if (("0" + i).equals(hobbyNum)) {
					selectedHobby = CodeUtil.hobby_lavel[i-1];
				}
			}			
		}		
		return selectedHobby;
	}
	
//  5-2. 취미명 (게임,음악감상,..) 을 취미번호 (01,02,..) 로 변환하기
	public static String setHobby(String selectedhobby) {
		
		String hobbyNum = "";		
		
		for (int i=0; i < CodeUtil.hobby_lavel.length; i++) {	
			
			if (CodeUtil.hobby_lavel[i].equals(selectedhobby)) {
				hobbyNum = CodeUtil.hobby_value[i];
			}			
		}		
		return hobbyNum;
	}
	
//  6-1. 직업명 (회사원,자영업,..) 을 직업번호 (01,02,..) 로 변환하기
	public static String job(String selectedJob) {
		
		String jobNum = "";	
		
		if (selectedJob !=null && selectedJob.length() > 0){	
			
			for (int i=1; i < job_lavel.length; i++) {	
				
				if (("0" + i).equals(selectedJob)) {
					jobNum = CodeUtil.job_lavel[i-1];
				}
			}		
		}		
		return jobNum;
	}
	
//  6-2. 직업번호 (01,02,..) 를 받아서 직업명 (회사원,자영업,..) 으로 돌려줌
	public static String setJob(String jobNum) {
		
		String selectedJob = "";
		
		for (int i=0; i < CodeUtil.job_lavel.length; i++) {			
			
			if (CodeUtil.job_lavel[i].equals(jobNum)) {
				selectedJob = CodeUtil.job_value[i];
			}			
		}	
		return selectedJob;
	}
	
// 	추가로 0001 자리수 채우는 함수,  회원번호 (cnum)의 채번의 수 보고 0 붙여서 채우기 
//	근데 아직 사용하지 않았음 (0824 기준)
//  숫자 채우는 관련 함수가 있음 : 예) String addZero = String.format("%02d", numbers[n]);
//  % 명령기호, 0 채울 문자, 2 자릿수, d 10진수 	
	public static String numPad(String cnum) {
		
		int lengthOfCnum = cnum.length();		
		
		for (int i=lengthOfCnum; i < 4; i++) {
			cnum = "0" + cnum;
		}		
		return cnum;
	}

//  확인!	
	public static void main(String args[]) {
		
		// 생년월일
		String birth = CodeUtil.birth("20210801");		
		System.out.println("birth >>> : " + birth);
		
		// 전화번호
		String tel = CodeUtil.tel("03212341234");		
		System.out.println("tel >>> : " + tel);
		
		// 핸드폰
		String hp = CodeUtil.tel("01012341234");		
		System.out.println("hp >>> : " + hp);		
		
		// 성별
		String gender = CodeUtil.gender("02");
		System.out.println("gender >>> : " + gender);
		// 취미
		String hobby = CodeUtil.hobby("02");
		System.out.println("hobby >>> : " + hobby);
		// 직업
		String job = CodeUtil.job("02");
		System.out.println("job >>> : " + job);
	}
}
