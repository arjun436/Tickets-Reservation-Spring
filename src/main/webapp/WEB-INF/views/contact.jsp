<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="en">
<head>
  <title><spring:message code="label.title.contact" /></title>
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
        <li><a href="home.html"><spring:message code="label.navbar.home" /></a></li>
        <li><a href="about.html"><spring:message code="label.navbar.about" /></a></li>
        <li><a href="contact.html"><spring:message code="label.navbar.contact" /></a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<!-- csrt for log out-->
      	<c:url value="/j_spring_security_logout" var="logoutUrl" />
      
      	<c:if test="${pageContext.request.userPrincipal.name == null}">
        <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> <spring:message code="label.navbar.login" /></a></li>
        <li><a href="user.html"><span class="glyphicon glyphicon-user"></span> <spring:message code="label.navbar.singup" /></a></li>
        
      	</c:if>
      	<c:if test="${pageContext.request.userPrincipal.name != null}">
        <li><a href="javascript:formSubmit()"><span class="glyphicon glyphicon-log-out"></span> <spring:message code="label.navbar.logout" /></a></li>
      	</c:if> 
      </ul>
      	<form action="${logoutUrl}" method="post" id="logoutForm">
		  <input type="hidden" 
			name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		</form>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    	  	<sec:authorize access="hasAnyRole('ROLE_ADMIN')">    
  			<ul class="nav nav-pills nav-stacked">
					 <li><a href="planeTickets.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.addPlane" /></a></li>
					 <li><a href="trainTickets.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.addTrain" /> </a></li>
			</ul>
		    &nbsp;
		    
		    <ul class="nav nav-pills nav-stacked">			   			
					 <li><a href="planeTicketsList.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.planeTicketsList" /></a></li>
					  <li><a href="trainTicketsList.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.trainTicketsList" /></a></li>
			</ul>
			&nbsp;
		 	</sec:authorize>
			
			<ul class="nav nav-pills nav-stacked">					 
					 <li><a href="planeTicketsListBook.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.planeTicketsListBook" /></a></li>
				     <li><a href="trainTicketsListBook.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.trainTicketsListBook" /></a></li>
			</ul>
			&nbsp;
			 <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
			
			<ul class="nav nav-pills nav-stacked">		
					 <li><a href="planeOrdersList.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.planeOrdersList" /></a></li>
					 <li><a href="trainOrdersList.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.trainOrdersList" /></a></li>
			</ul>
			 &nbsp;
			<ul class="nav nav-pills nav-stacked">					 
					 <li><a href="userRole.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.userRole" /></a></li>
			         <li><a href="user.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.user" /></a></li>
    		</ul>
    		&nbsp;		
    		<ul class="nav nav-pills nav-stacked">					 
    		  	     <li><a href="usersList.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.usersList" /></a></li>
    		</ul>
    		</sec:authorize>
    	    		&nbsp;		
    		
    		<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">    		
    		<ul class="nav nav-pills nav-stacked">					 
	    			 <li><a href="myPlaneOrders.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.myPlaneOrders" /></a></li>
    		  	     <li><a href="myTrainOrders.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.myTrainOrders" /></a></li>
    		</ul>
    		</sec:authorize>		
    </div>
    <div class="col-sm-8 text-left"> 
      <h1><spring:message code="label.text.contact1"/></h1>
  <table class="table table-striped">
    <thead>
      <tr>
        <th><spring:message code="label.text.contact2"/></th>
        <th><spring:message code="label.text.contact3"/></th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><spring:message code="label.text.contact4"/></td>
        <td><spring:message code="label.text.contact5"/></td>
      </tr>
      <tr>
        <td><spring:message code="label.text.contact6"/></td>
        <td><spring:message code="label.text.contact7"/></td>
      </tr>
    </tbody>
  </table>
      <hr>

    </div>
    <div class="col-sm-2 sidenav">

    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p><spring:message code="footer" /></p>
</footer>


<script>/*

/*menu handler*/
    $(document).ready(function () {
        var url = window.location;
    // Will only work if string in href matches with location
        $('ul.nav a[href="' + url + '"]').parent().addClass('active');

    // Will also work for relative and absolute hrefs
        $('ul.nav a').filter(function () {
            return this.href == url;
        }).parent().addClass('active').parent().parent().addClass('active');
    });
  //login logout
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>

</body>
</html>
