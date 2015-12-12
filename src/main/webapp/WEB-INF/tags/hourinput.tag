<%@tag description="Extended input tag to allow for sophisticated errors" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@attribute name="path" required="true" type="java.lang.String"%>
<%@attribute name="cssClass" required="false" type="java.lang.String"%>
<%@attribute name="label" required="false" type="java.lang.String"%>
<%@attribute name="required" required="false" type="java.lang.Boolean"%>
<%@attribute name="id" required="false" type="java.lang.String"%>

<c:if test="${empty label}">
    <c:set var="label" value="${fn:toUpperCase(fn:substring(path, 0, 1))}${fn:toLowerCase(fn:substring(path, 1,fn:length(path)))}" />
</c:if>
<spring:bind path="${path}">

 <!--    <div class="control-group ${status.error ? 'error' : '' }">
        <label class="control-label" for="${path}"><spring:message code = "${label}"/><c:if test="${required}"><span class="required">*</span></c:if></label>
			<div  class="input-group input-append date"  >

                
             <form:input  type="text" path="${path}" class="form-control" name="date" id="dateRangePicker2"/>
                  <span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
             
            <c:if test="${status.error}">
                <span class="help-inline">${status.errorMessage}</span>
            </c:if>
            </div>
    </div>  --> 
    
    <div class="control-group <c:if test="${status.error}">has-error</c:if>">
        <label class="control-label" for="${path}"><spring:message code = "${label}"/><c:if test="${required}"><span class="required">*</span></c:if></label>
			<div  class="input-group input-append clockpicker" id="${id}">

                
             <form:input  type="text" path="${path}" class="form-control" name="clock" />
                  <span class="input-group-addon "><span class="glyphicon glyphicon-time"></span></span>
             

            </div>
            
            <c:if test="${status.error}">
                     <span class="help-inline" style="color: #a94442" >${status.errorMessage}</span>
            </c:if>
     </div>
     
     

</spring:bind>