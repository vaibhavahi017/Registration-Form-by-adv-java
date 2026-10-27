<%@page import="com.E.bean.ProductBean"%>
<%@page import="com.E.bean.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
	<h1>
	
	<%
	AdminBean abean =(AdminBean)session.getAttribute("abean");
	ProductBean pb=(ProductBean)request.getAttribute("productBean");
	out.println("Hello "+abean.getaFNAME()+" Please Edit!!!<br><br>");
	
	
	%>
	<form action="update" method="post">
	Product Price <input type="text" name="pPrice" value="<%=pb.getpPrice()%>"><br><br>
	Product Quantity <input type="text" name="pQty" value="<%=pb.getpQty()%>"><br><br>
	
	<input type="hidden" name="pcode" value="<%=pb.getpCode()%>">
	<input type="submit" value="Update">
	
	</form>
	
	</h1>
	
	</center>
</body>
</html>