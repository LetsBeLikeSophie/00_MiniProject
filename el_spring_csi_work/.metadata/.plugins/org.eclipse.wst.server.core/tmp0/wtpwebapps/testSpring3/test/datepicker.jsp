<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	.bg-small {
    width: 20px; height: 20px;    
    background-size: contain;
}


</style>
<link rel="stylesheet" href="/testSpring3/common/datepiker/jquery-ui-1.12.1/jquery-ui.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="/testSpring3/common/datepiker/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script src="/testSpring3/common/datepiker/jquery-ui-1.12.1/datepicker-ko.js"></script>

<script type="text/javascript">
$(function(){
	$("#date1").datepicker();
	
	$("#startdate").datepicker({
		showOn: "button",
		buttonImage: "/testSpring3/img/cal_0.gif",
		buttonImageOnly: false,
		buttonText: "Select date"
	});
	
	$("#enddate").datepicker({
		showOn: "button",
        buttonImage: "/testSpring3/img/cal_0.gif",
	    buttonImageOnly: false,
		buttonText: "Select date"
	});
	
	$("#date3").datepicker({
		onSelect:function(dateText, inst) {
			console.log(dateText);
			console.log(inst);
		}
	});
});

</script>
</head>
<body>
<p>
<input type="text" name="date" id="startdate" size="12" />
~ <input type="text" name="date" id="enddate" size="12" />

</p>

</body>
</html>