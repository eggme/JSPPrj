<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String temp = request.getParameter("cnt");
int cnt = 10;
if(temp != null){
	cnt = Integer.parseInt(temp);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
for(int i=0;i<cnt;i++){
%>
안녕 JSP!, i = <%=i %><br />
<%}%>
</body>
</html>