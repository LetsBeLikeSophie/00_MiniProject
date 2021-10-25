<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="a.b.c.com.board.vo.BoardVO" %> 
<%@ page import="java.util.List" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ��� ���</title>
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
			CSS ������ �켱���� ����
			��������  : styl='' : 1000 �� 
			id : #sbnum : 100��
			class : .sbnum : 10��
			�Ӽ� : [name="sbnum"] : 10��
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
			
		// �˻���ư
		//  U
		$(document).on("click", "#searchBtn", function(){
			alert("searchBtn >>> : ");			
			$("#boardList").attr({ "method":"GET"
				                  ,"action":"boardSelectAll.h"}).submit();
		});
		// datepicker : from ~ to �Ⱓ��ȸ
		$("#startdate").datepicker({		
			showOn: "button",    // �޷��� ǥ���� Ÿ�̹� (both: focus or button)
			buttonImage: "/testSpring3/img/cal_0.gif", 
			buttonImageOnly : true,            
			buttonText: "��¥����",             
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
			buttonText: "��¥����",
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
				alert("������ �۹�ȣ �ϳ��� �����ϼ���!!");
				return;
			}
			 $("#boardList").attr({ "method":"POST"
				                   ,"action":"boardSelect.h"}).submit();
		});
		//  D
		$(document).on("click", "#D", function(){
			//alert("D >>> : ");	
			if ($('.sbnum:checked').length == 0){
				alert("������ �۹�ȣ �ϳ��� �����ϼ���!!");
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
		<h2>�Խ���</h2>
	</td>
</tr>
<tr>
<td  colspan="10" align="left">
<select id="keyfilter" name="keyfilter">
	<option value="key1">����</option>
	<option value="key2">����</option>
	<option value="key3">����+����</option>
	<option value="key4">�ۼ���</option>
	<option value="key5">�۹�ȣ</option>
</select>
<input type="text" id="keyword" name="keyword" placeholder="�˻��� �Է�"><br>
<input type="text" id="startdate" name="startdate" size="12" placeholder="������ ">
~ <input type="text" id="enddate" name="enddate" size="12" placeholder="������">
<button type="button" id="searchBtn">�˻�</button>
</td>
</tr>
<tr>
	<td class="tt">üũ</td>
	<td class="tt">�۹�ȣ</td>
	<td class="tt">����</td>
	<td class="tt">�̸�</td>		
	<td class="tt">����</td>
	<td class="tt">�����ۼ���</td>
	<td class="tt">����</td>
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
		<input type="button" value="�۾���" id='I'>	
		<input type="button" value="�ۼ���" id='U'>
		<input type="button" value="�ۻ���" id='D'>							
	</td>
</tr>
<tr>
</tbody>			
</table>
</form>			
</body>
</html>