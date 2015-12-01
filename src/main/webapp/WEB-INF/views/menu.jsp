<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3><spring:message code="label.menu"/></h3>

	<ul>
		<li><a href="http://localhost:8080/myapp/"><spring:message code="label.menu.home"/></a></li>
		<li><a href="hello.html"><spring:message code="label.menu.sayHello"/></a></li>
		<li><a href="users.html"><spring:message code="label.menu.userPage"/></a></li>
		<li><a href="addresses.html"><spring:message code="label.menu.addressPage"/></a></li>
		<li><a href="admin.html"><spring:message code="label.menu.admin"/></a></li>		
		<li><a href="userRole.html"><spring:message code="label.role"/></a></li>
	</ul>

</body>
</html>