<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="<c:url value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
  
  <script src="<c:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js" />"></script>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</head>
<body>

<nav id="myNav" class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a href="#" class="pull-left"><img src=<c:url value="/resources/images/logo.png" />></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#"><spring:message code="label.navbar.home" /></a></li>
        <li><a href="#"><spring:message code="label.navbar.about" /></a></li>
        <li><a href="#"><spring:message code="label.navbar.contact" /></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> <spring:message code="label.navbar.login" /></a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
  			<ul class="nav nav-pills nav-stacked">
			  <li><a href="planeTickets.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.addplane" /></a></li>
			  <li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.addtrain" /></a></li>
			</ul>
    
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Define new plane ticket</h1>
      
			<form:form method="post" class="form-horizontal" action="addPlaneTicket.html" commandName="planeTicket">
			   <fieldset>
			      <t:input path="flightNumber" label="label.ticket.plane.flightNumber"/>
			      <t:input path="flightFrom" label="label.ticket.plane.flightFrom"/>
			      <t:input path="flightTo" label="label.ticket.plane.flightTo"/>
			      <t:input path="flightDateStart" label="label.ticket.plane.flightDateStart"/>
			      <t:input path="flightHourStart" label="label.ticket.plane.flightHourStart"/>
			      <t:input path="flightDateStop" label="label.ticket.plane.flightDateStop"/>
			      <t:input path="flightHourStop" label="label.ticket.plane.flightHourStop"/>
			      <t:input path="flightPrice" label="label.ticket.plane.flightPrice"/>

			     
			      
			    </fieldset>
			    <div class="myButton">
			      <input type="submit" class="btn btn-info btn-block" value="<spring:message code="label.button.submit"/> ">
			    </div>
			    
			 
			</form:form>  
			


    </div>
    <div class="col-sm-2 sidenav">

    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
