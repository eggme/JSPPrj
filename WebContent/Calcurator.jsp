<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
input{
	width:50px;
	height:50px;
}
.output{
	text-align:right;
	height:50px;
	background: #e9e9e9;
	font-size: 18px;
	font-weight: bold;
	padding: 0 5px;
}
</style>
<body>
<%
	int x = 3;
	int y = 14;
%>
<form action="/calc2" method="post">
	<table>
		<tr>
			<td colspan="4" class="output"><%=x+y%></td> 
		</tr>
		<tr>
			<td><input type="button" value="CE" name="CE"/></td>
			<td><input type="button" value="C" name="C"/></td>
			<td><input type="button" value="BS" name="BS"/></td>
			<td><input type="button" value="÷" name="oper"/></td>
		</tr>
		<tr>
			<td><input type="button" value="7" name="value"/></td>
			<td><input type="button" value="8" name="value"/></td>
			<td><input type="button" value="9" name="value"/></td>
			<td><input type="button" value="*" name="oper"/></td>
		</tr>
		<tr>
			<td><input type="button" value="4" name="value"/></td>
			<td><input type="button" value="5" name="value"/></td>
			<td><input type="button" value="6" name="value"/></td>
			<td><input type="button" value="-" name="oper"/></td>
		</tr>
		<tr>
			<td><input type="button" value="1" name="value"/></td>
			<td><input type="button" value="2" name="value"/></td>
			<td><input type="button" value="3" name="value"/></td>
			<td><input type="button" value="+" name="oper"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="0" name="value" style="width:104px;"/></td>
			<td><input type="button" value="." name="."/></td>
			<td><input type="button" value="eq" name="eq"/></td>
		</tr>
	</table>
</form>
</body>
</html>