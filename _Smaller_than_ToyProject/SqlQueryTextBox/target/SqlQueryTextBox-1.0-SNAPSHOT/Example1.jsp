<%--
  Created by IntelliJ IDEA.
  User: kosmo
  Date: 2021-09-21
  Time: 오전 2:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Example 01</title>

</head>
<body>
<form id="my_form" action="/Example1" method="post">


    <table>
        <tr>
            <td>
             <textarea name="input" style="width: 500px; height: 500px;">
             </textarea>
            </td>
        </tr>
        <tr>
            <td>
                <button type="submit" id="enter">Enter</button>
            </td>
        </tr>
    </table>
</form>



<!---

<script>
    document.forms[0].submit();
    // 위와 아래 중 택1
    // document.querySelector("#my_form").submit();
</script>

--->
</body>
</html>
