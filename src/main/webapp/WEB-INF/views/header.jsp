<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h1><spring:message code="label.header"/></h1>
	<span style="float: right">
    	<a href="?lang=pl">pl</a> | <a href="?lang=en">en</a> | <a href="?lang=de">de</a> | <a href="?lang=ja">ja</a>
	</span>
		</div>
	
	

</body>
</html>