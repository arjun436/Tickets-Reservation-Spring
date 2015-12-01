<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h2>
		<spring:message code="label.addressPage" />
	</h2>
	<form:form method="post" action="addAddress.html" commandName="address">

		<table>
			<tr>
				<td><form:hidden path="id" />
			</tr>
			<tr>
				<td><form:label path="country">
						<spring:message code="label.country" />
					</form:label> <form:input path="country"></form:input></td>
				<td><form:errors path="country" /></td>

			</tr>
			<tr>
				<td><form:label path="state">
						<spring:message code="label.state" />
					</form:label> <form:input path="state"></form:input></td>
				<td><form:errors path="state" /></td>

			</tr>
			<tr>
				<td><form:label path="zip">
						<spring:message code="label.zip" />
					</form:label> <form:input path="zip"></form:input></td>
				<td><form:errors path="zip" /></td>

			</tr>
			<tr>
				<td><form:label path="city">
						<spring:message code="label.city" />
					</form:label> <form:input path="city"></form:input></td>
				<td><form:errors path="city" /></td>

			</tr>
			<tr>
				<td><form:label path="street">
						<spring:message code="label.street" />
					</form:label> <form:input path="street"></form:input></td>
				<td><form:errors path="street" /></td>

			</tr>


			<tr>
				<td colspan="2"><c:if test="${address.id==0}">
						<input type="submit"
							value="<spring:message code="label.addAddress"/>" />
					</c:if> <c:if test="${address.id!=0}">
						<input type="submit"
							value="<spring:message code="label.editAddress"/>" />
					</c:if></td>
			</tr>

		</table>

	</form:form>
	<h3>
		<spring:message code="label.addressList" />
	</h3>
	<!--  -->
	<c:if test="${!empty addressList}">
		<table class="data">
			<tr>
				<th><spring:message code="label.country" /></th>
				<th><spring:message code="label.state" /></th>
				<th><spring:message code="label.zip" /></th>
				<th><spring:message code="label.city" /></th>
				<th><spring:message code="label.street" /></th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${addressList}" var="address">
				<tr>
					<td>${address.country}</td>
					<td>${address.state}</td>
					<td>${address.zip}</td>
					<td>${address.city}</td>
					<td>${address.street}</td>
					<td><a href="delete_address/${address.id}.html">delete</a></td>
					<td><a href="addresses.html?addressId=${address.id}">edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>