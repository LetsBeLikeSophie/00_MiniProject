<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.board.vo.BoardVO" %> 
<%@ page import="java.util.List" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판 목록</title>
<style type="text/css">
	.tt{
		text-align: center;
		font-weight: bold;
	}
</style> 
<!-- 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
 -->
<link rel="stylesheet" href="/testSpring3/common/datepiker/jquery-ui-1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/testSpring3/common/datepiker/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){			
		/*
			CSS 선택자 우선순위 점수
			직접기입  : styl='' : 1000 점 
			id : #sbnum : 100점
			class : .sbnum : 10점
			속성 : [name="sbnum"] : 10점
		*/
		// sbnum
		$(document).on("click", "#sbnum", function(){
			//alert("chkInSbnum >>> : ");		
			if($(this).prop('checked')){			 
				//$('input[type="checkbox"][name="sbnum"]').prop('checked',false);
				$('.sbnum').prop('checked',false);
				$(this).prop('checked',true);
			}
		});
			
		// 검색버튼
		//  U
		$(document).on("click", "#searchBtn", function(){
			alert("searchBtn >>> : ");			
			$("#boardList").attr({ "method":"GET"
				                  ,"action":"boardSelectAll.h"}).submit();
		});
		// datepicker : from ~ to 기간조회
		$("#startdate").datepicker({		
			showOn: "button",    // 달력을 표시할 타이밍 (both: focus or button)
			buttonImage: "/testSpring3/img/cal_0.gif", 
			buttonImageOnly : true,            
			buttonText: "날짜선택",             
			dateFormat: "yy-mm-dd",             
			changeMonth: true,                  			
			onClose: function(selectedDate) {    
				$("#enddate").datepicker("option", "minDate", selectedDate);
			}                
		});		
		$("#enddate").datepicker({
			showOn: "button", 
			buttonImage: "/testSpring3/img/cal_0.gif", 
			buttonImageOnly : true,
			buttonText: "날짜선택",
			dateFormat: "yy-mm-dd",
			changeMonth: true,			
			onClose: function(selectedDate) {	
				$("#startdate").datepicker("option", "maxDate", selectedDate);
			}               
		});			
		
		//  I
		$(document).on("click", "#I", function(){
			//alert("I >>> : ");
			location.href="boardForm.h";
		});
		//  U
		$(document).on("click", "#U", function(){
			// alert("U >>> : ");	
			if ($('.sbnum:checked').length == 0){
				alert("수정할 글번호 하나를 선택하세요!!");
				return;
			}
			 $("#boardList").attr({ "method":"POST"
				                   ,"action":"boardSelect.h"}).submit();
		});
		//  D
		$(document).on("click", "#D", function(){
			//alert("D >>> : ");	
			if ($('.sbnum:checked').length == 0){
				alert("삭제할 글번호 하나를 선택하세요!!");
				return;
			}
			$("#boardList").attr({ "method":"POST"
				                  ,"action":"boardSelect.h"}).submit();
		});
	});

</script>	
</head>
<body>
<% request.setCharacterEncoding("EUC-KR");%> 
<%
	Object obj = request.getAttribute("listAll");
	List<BoardVO> list = (List)obj;
	
	int nCnt = list.size();
	System.out.println("nCnt >>> : " + nCnt);	
%>
<form name="boardList" id="boardList">
<table border="1" align="center">
<thead>
<tr>
	<td colspan="10" align="center">
		<h2>게시판</h2>
	</td>
</tr>
<tr>
<td  colspan="10" align="left">
<select id="keyfilter" name="keyfilter">
	<option value="key1">제목</option>
	<option value="key2">내용</option>
	<option value="key3">제목+내용</option>
	<option value="key4">작성자</option>
	<option value="key5">글번호</option>
</select>
<input type="text" id="keyword" name="keyword" placeholder="검색어 입력"><br>
<input type="text" id="startdate" name="startdate" size="12" placeholder="시작일 ">
~ <input type="text" id="enddate" name="enddate" size="12" placeholder="종료일">
<button type="button" id="searchBtn">검색</button>
</td>
</tr>
<tr>
	<td class="tt">체크</td>
	<td class="tt">글번호</td>
	<td class="tt">제목</td>
	<td class="tt">이름</td>		
	<td class="tt">내용</td>
	<td class="tt">최종작성일</td>
	<td class="tt">사진</td>
</tr>
</thead>
<%
for(int i=0; i<nCnt; i++){		
	BoardVO bvo = list.get(i);	
%>					
<tbody>
<tr>
	<td align="center">
		<input type="checkbox" name="sbnum" id="sbnum" class="sbnum" value=<%= bvo.getSbnum() %> >
	</td>		
	<td class="tt"><%= bvo.getSbnum() %> </td>
	<td class="tt"><%= bvo.getSbsubject() %> </td>
	<td class="tt"><%= bvo.getSbname() %> </td>
	<td class="tt"><%= bvo.getSbcontent() %> </td>
	<td class="tt"><%= bvo.getSbupdatedate() %> </td>
	<td class="tt"><img src="/testSpring3/imgupload/sm_<%= bvo.getSbfile() %>"> </td>	
</tr>	
<%
}//end of for
%>						
<tr>
	<td colspan="7" align="right">		
		<input type="button" value="글쓰기" id='I'>	
		<input type="button" value="글수정" id='U'>
		<input type="button" value="글삭제" id='D'>							
	</td>
</tr>
<tr>
</tbody>			
</table>
</form>			
</body>
</html>