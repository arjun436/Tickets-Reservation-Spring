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
  <!-- jQuery -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script> 

<!-- bootstrap -->
 <link href="<c:url value="/resources/bootstrap-3.3.6-dist/css/bootstrap.min.css" />" rel="stylesheet">
 <script src="<c:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap.min.js" />"></script>
 <script src="<c:url value="/resources/bootstrap-3.3.6-dist/js/bootstrap-datepicker.js" />"></script>
  
 <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
   
  <!-- Datepicker -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
  <!-- Clockpicker -->
  <link href="<c:url value="/resources/clockpicker/dist/bootstrap-clockpicker.min.css" />" rel="stylesheet" type="text/css">
  <script src="<c:url value="/resources/clockpicker/dist/bootstrap-clockpicker.min.js" />"></script>
  

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
        <li><a href="http://localhost:8080/myapp/"><spring:message code="label.navbar.home" /></a></li>
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
    <div class="col-sm-9 text-left"> 
      <h1>Book plane Tickets</h1>
      
		 <table class="table table-bordered">
		    <thead>
		      <tr>
		        <th><spring:message code="label.ticket.train.transitNumber"/></th>
		        <th><spring:message code="label.ticket.train.transitName"/></th>
		        <th><spring:message code="label.ticket.train.transitFrom"/></th>
		        <th><spring:message code="label.ticket.train.transitTo"/></th>
		        <th><spring:message code="label.ticket.train.transitDateStart"/></th>
		        <th><spring:message code="label.ticket.train.transitHourStart"/></th>
		        <th><spring:message code="label.ticket.train.transitDateStop"/></th>
		        <th><spring:message code="label.ticket.train.transitHourStop"/></th>
		        <th><spring:message code="label.ticket.train.transitPrice"/> <spring:message code="label.ticket.plane.flightPrice.currency"/></th>
		        <th><spring:message code="label.ticket.actions"/></th>
		        
		      </tr>
			</thead>

			    			    <tbody>
			<c:forEach items="${trainTicketList}" var="trainTicket">
				<tr>
					
					<td>${trainTicket.transitNumber}</td>
					<td>${trainTicket.transitName}</td>
					<td>${trainTicket.transitFrom}</td>
					<td>${trainTicket.transitTo}</td>
					<td>${trainTicket.transitDateStart}</td>
					<td>${trainTicket.transitHourStart}</td>
					<td>${trainTicket.transitDateStop}</td>
					<td>${trainTicket.transitHourStop}</td>
					<td>${trainTicket.transitPrice}</td>
					
									 
					<td><a href="trainTicketsListBookOrder.html?trainTicketId=${trainTicket.id}" class="btn btn-info btn-xs" role="button">BOOK</a></td>
	

			</c:forEach>
			    </tbody>
 		 </table>


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
    //walek
    	if(url == "http://localhost:8080/myapp/addPlaneTicket.html"){
    		$('ul.nav a[href="planeTickets.html"]').parent().addClass('active');
    	}
    });


    $(document).ready(function() {
    	
    	var d = new Date();//from today
    	
       $(".date")
            .datepicker({
                format: 'mm/dd/yyyy',
                startDate: d,
                endDate: '12/30/2020',
                autoclose: true
            })
            .on('changeDate', function(e) {
                $(".date").datepicker('hide');
            }); 


        
        
    });
  /*/
    var clocktype;
    if(locLang == "en"){
    	clocktype = true;
    } else clocktype = false;*/
    $('.clockpicker').clockpicker({
    	placement: 'top', // clock popover placement
    	align: 'right',       // popover arrow align
    	donetext: 'OK',     // done button text
    	autoclose: false,    // auto close when minute is selected
        twelvehour: false        // vibrate the device when dragging clock hand


    	});
    var url = window.location;
    // Will only work if string in href matches with location
        $('ul.nav a[href="' + url + '"]').parent().addClass('active');

    // Will also work for relative and absolute hrefs
        $('ul.nav a').filter(function () {
            return this.href == url;
        }).parent().addClass('active').parent().parent().addClass('active');
    

  
</script>


</body>
</html>
