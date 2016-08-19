<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>I-wear</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery-1.11.3.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval() %>; URL=account.jsp" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="I-wear Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>

		<!-- BOOTSTRAP -->
		<link rel="stylesheet" href="library/bootstrap/css/bootstrap.min.css"/>
		<script src="library/bootstrap/js/bootstrap.min.js"></script>
		<script src="library/bootstrap/js/validator.js"></script>
		<!-- PNOTIFY -->
		<link rel="stylesheet" type="text/css" href="library/pnotify/pnotify.custom.min.css"/>
		<script src="library/pnotify/pnotify.custom.min.js"></script>
		
<!--//fonts-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- start menu -->

<!--//slider-script-->

<script src="js/easyResponsiveTabs.js" type="text/javascript"></script>
		    <script type="text/javascript">
			    $(document).ready(function () {
			        $('#horizontalTab').easyResponsiveTabs({
			            type: 'default', //Types: default, vertical, accordion           
			            width: 'auto', //auto or any width like 600px
			            fit: true   // 100% fit in a container
			        });
			    });
				
</script>	
		  		 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<!-- js -->
		 <script src="js/bootstrap.js"></script>
	<!-- js -->

<script src="js/simpleCart.min.js"> </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!-- /start menu -->
</head>
<body> 
<!--header-->
		<div class="header-info">
			<div class="container">
					<div class="header-top-in">
						<ul class=" support-right">
							<c:set var="a" value="${account}" scope="request"></c:set>
							<c:choose>
	    						<c:when test="${empty account}">
	    							<li><a href="account.jsp"><i class="glyphicon glyphicon-user" class="men"> </i>Login</a></li>
	    						</c:when>
	    						<c:otherwise>
							        <li><a href="account.jsp"><i class="glyphicon glyphicon-user" class="men"> </i><c:out value="${a.username}"/></a></li>
							        <li><a href="LogOutServlet"><i class="glyphicon glyphicon-user" class="men"> </i>Logout</a></li>
							    </c:otherwise>
							</c:choose>			
						</ul>
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>		
<div class="header header5">
	<div class="header-top">

			<div class="header-bottom">
			<div class="container">			
				<div class="logo">
					<h1><a href="index.jsp">I-<span>wear</span></a></h1>
				</div>
		 <!---->
		 
			<div class="top-nav">
				<ul class="memenu skyblue"><li  class="active"><a href="HomeServlet">Home</a></li>
					<li class="grid"><a href="ViewBootsServlet">Boots</a>
					</li>
					<li class="grid"><a href="ViewShoesServlet">Shoes</a>
					</li>
					<li class="grid"><a href="ViewSandalsServlet">Sandals</a>
					</li>
					<li class="grid"><a href="ViewSlippersServlet">Slippers</a>
					</li>
				</ul>
				<div class="clearfix"> </div>
			</div>
					<!---->
					<div class="cart box_1">
						<a href="checkout.jsp">
						<h3> <div class="total">
							<span class="simpleCart_total"> </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> </span>)</div>
							<img src="images/cart2-2.png" alt=""/></h3>
						</a>
						<p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
						<div class="clearfix"> </div>
					</div>

<div class="clearfix"> </div>
					<!---->
				</div>
			<div class="clearfix"> </div>
		</div>
		</div>	
 				<div class="clearfix"> </div>	
			</div>
<!---->
<div class="back">
	<h2>Register</h2>
</div>
		<!---->
		<div class="container">
		<div class="register">
		<h3>PERSONAL INFORMATION</h3>
		  	  <form action="SignUpServlet" method="post" class="form-horizontal" role="form" data-toggle="validator"> 
					<div class="mation">
						<div class="form-group">
							<span>First Name</span> 
							<input type="text" class="form-control" name="first_name" required pattern="[A-z ]+" data-error="Please enter text with A-z."></input>
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<span>Middle Initial</span>
							<input type="text" class="form-control" name="middle_initial" required pattern="[A-z ]+" data-error="Please enter text with A-z."></input>
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<span>Last Name</span>
							<input type="text" class="form-control" name="last_name" required pattern="[A-z ]+" data-error="Please enter text with A-z."></input>
							<div class="help-block with-errors"></div>
						 </div>
						 <div class="form-group">
							 <span>Email Address</span>
							<input type="text" class="form-control" name="email" required pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$" data-error="Please enter correct email format. Ex. maria_christine@gmail.com"></input>
							<div class="help-block with-errors"></div>
						</div>
						<h3>ACCOUNT DETAILS</h3>
						<div class="form-group">
							<span>Username</span>
							<input type="text" class="form-control" name="username" required pattern="[A-z ]+" data-error="Please enter text with A-z."></input>
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<span>Password</span> 
							<input type="password" class="form-control" name="password" required pattern="[A-z ]+" id="password" data-error="Please enter text with A-z."></input>
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<span>Confirm Password</span>
							<input type="password" class="form-control" name="confirmPass" required pattern="[A-z ]+" data-match="#password" data-match-error="Whoops, these don't match."></input>
							<div class="help-block with-errors"></div>
						</div>
						<div>
							<input type="hidden" name="type" value="0">		 
						</div>
					 </div>
				     <input type="submit" value="submit">
				</form>
				 <!---->
<script type="text/javascript">
		$(document).ready(function() {
				/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
				*/
		$().UItoTop({ easingType: 'easeOutQuart' });
});
</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!----> 
<!---->
</body>
</html>