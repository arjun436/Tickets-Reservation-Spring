<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" action="addUserRole.html" commandName="userRole">
    <table>
    <tr>
        <td><form:hidden path="id"/>
    </tr>
    <tr>
        <td><form:label path="role"><spring:message code="label.role"/></form:label></td>
        <td><form:input path="role" /></td>
        <td><form:errors path="role"/></td>
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="<spring:message code="label.addUserRole"/>"/>
        </td>
    </tr>
</table> 
</form:form>
</body>
</html>