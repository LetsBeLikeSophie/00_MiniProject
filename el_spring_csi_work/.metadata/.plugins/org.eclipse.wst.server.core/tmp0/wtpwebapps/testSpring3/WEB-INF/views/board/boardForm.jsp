<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>BOARD : �Խ��� : �۾��� </title>
<!-- nhn ��������  -->
<script type="text/javascript" src="/testSpring3/common/webedit/dist/js/service/HuskyEZCreator.js" charset="EUC-KR"></script>
	
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	$(document).ready(function(){	
		// nhn �������� : ���� ������� �־ ���� ����ؾ� ��
		var oEditors = {};
		$(function(){
			nhn.husky.EZCreator.createInIFrame({
				oAppRef : oEditors,
				elPlaceHolder : "sbcontent", // textarea id 				
				sSkinURI : "/testSpring3/common/webedit/dist/SmartEditor2Skin.html", // SmartEditor2Skin.html ������ ��Ų 				
				fCreator : "createSEditor2"
			});
		});
					
		$(document).on("click", "#sbbtn", function(){
			console.log("sbbtn >>> : ");	
			oEditors.getById["sbcontent"].exec("UPDATE_CONTENTS_FIELD", []);					
			$('#boardForm').attr({
				'action':'boardInsert.h',
				'method':'POST',
				'enctype':'multipart/form-data'
			}).submit();
		});
	});
</script>
</head>
<body>
<form name="boardForm" id="boardForm">
<table border="1" align="center">
	<tr>
		<td colspan="2" align="center">�Խ��� �۾���</td>				
	</tr>
	<tr>
		<td align="center">�۹�ȣ</td>
		<!-- readonly�� ����ؼ� sbnum�� ����� �� ���� �����.-->
		<td><input type="text" name="sbnum" id="sbnum" size="20" readonly></td>
	</tr>
	<tr>
		<td align="center">����</td>
		<td><input type="text" name="sbsubject" id="sbsubject" size="53"></td>
	</tr>
	<tr>
		<td  align="center">�̸�</td>.
		<td><input type="text" name="sbname" id="sbname" size="53"></td>
	</tr>
	<tr>
		<td  align="center">��й�ȣ</td>
		<td><input type="password" name="sbpw" id="sbpw" size="20"></td>
	</tr>
<!-- 
	<tr>
		<td  align="center">�Է���</td>
		<td><input type="text" name="sbinsertdate" size="20" disabled></td>
	</tr>
	<tr>
		<td  align="center">������</td>
		<td><input type="text" name="sbupdatedate" size="20" disabled></td>
	</tr>
 -->	
	<tr>
		<td  align="center">����</td>
		<td>
		<textarea name="sbcontent" id="sbcontent" cols="50" rows="10"></textarea>
	</td>
	</tr>
	<tr>
		<td  align="center">����</td>
		<td>
		<input type="file" name="sbfile" id="sbfile">
	</td>
	</tr>
	<tr>
		<td colspan="2" align="right">				
		<input type="button" value="�۾���" id="sbbtn">		
	</td>				
	</tr>
</table>
</form>
</body>
</html>