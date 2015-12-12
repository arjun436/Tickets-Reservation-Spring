<%@tag description="Extended input tag to allow for sophisticated errors" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@attribute name="type" required="false" type="java.lang.String"%>
<%@attribute name="value" required="false" type="java.lang.String"%>

<%@attribute name="name" required="false" type="java.lang.String"%>
<%@attribute name="path" required="false" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="required" required="false" type="java.lang.Boolean"%>
<c:if test="${empty label}">
    <c:set var="label" value="${fn:toUpperCase(fn:substring(path, 0, 1))}${fn:toLowerCase(fn:substring(path, 1,fn:length(path)))}" />
</c:if>
<spring:bind path="${path}">
    <div class="control-group ${status.error ? 'error' : '' }">
        <label class="control-label" for="${path}"><spring:message code = "${label}"/><c:if test="${required}"><span class="required">*</span></c:if></label>
        <div class="controls" >
            <form:input path="${path}" cssClass="${empty cssClass ? 'form-control' : cssClass}" value="${value}"/>
            
            <c:if test="${status.error}">
                     <span class="help-inline">${status.errorMessage}</span>
            </c:if>
        </div>
    </div>
    

    
</spring:bind>