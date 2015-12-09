<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
        <li><a href="home.html"><spring:message code="label.navbar.home" /></a></li>
        <li><a href="about.html"><spring:message code="label.navbar.about" /></a></li>
        <li><a href="contact.html"><spring:message code="label.navbar.contact" /></a></li>
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
			 <li><a href="planeTickets.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.addPlane" /></a></li>
			  <li><a href="trainTickets.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.addTrain" /></a></li>
			 <li><a href="planeTicketsList.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.planeTicketsList" /></a></li>
			<li><a href="trainTicketsList.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.trainTicketsList" /></a></li>
			<li><a href="planeTicketsListBook.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.planeTicketsListBook" /></a></li>
						<li><a href="planeOrdersList.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.planeOrdersList" /></a></li>
									<li><a href="trainTicketsListBook.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.trainTicketsListBook" /></a></li>
									<li><a href="trainOrdersList.html"><span class="glyphicon glyphicon-chevron-right"></span> <spring:message code="label.sidenav.trainOrdersList" /></a></li>
			
			</ul>
    
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>About us</h1>
			<p> TickTwo. You know who we are. You know what we do. You know that when you travel with TickTwo you’ll get where you want to go cheaply, reliably and without any fuss.</p>
			<p> Our no frills, low cost model revolutionized the air travel industry and opened up Europe to the masses. And we continue to lead the way in great value travel, doing whatever it takes to guarantee that our fares are the lowest out there.</p>
			<p> But our fares aren’t the only thing that sets us apart. We can also boast the most on-time flights of any airline in Europe, an industry leading 30-year safety record, first class punctuality, near perfect baggage handling and an innovative, cutting edge green policy.</p>
			<p> Want the cold hard facts? Take a look at the numbers:</p>
					<ul >			
						<li><p> 1,600 flights daily</p></li>
						<li><p> 185 destinations</p></li>
						<li><p> 300 new Boeing 737-800 in operation</p></li>
						<li><p> 283 new Boeing 737 on order</p></li>
						<li><p> 9,500 aviation professionals employed.</p></li>
						<li><p> 103,000,000 customers this year.</p></li>
						<li><p> A projected 160,000,000 passengers in 2024</p></li>
					</ul>
			<p>But let’s face it, at the end of the day, the only number that really matters is the fare price and one thing’s for certain, TickTwo’s will always be the lowest out there.</p>
			
		
			
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

</script>

</body>
</html>
