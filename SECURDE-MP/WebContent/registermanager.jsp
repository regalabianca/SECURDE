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
		
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--//fonts-->
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
							        <li><a href="account.jsp"><i class="glyphicon glyphicon-user" class="men"> </i><c:out value="${a.username}"/></a></li>
							        <li><a href="LogOutServlet"><i class="glyphicon glyphicon-user" class="men"> </i>Logout</a></li>	
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
					<h1><a href="HomeServlet">I-<span>wear</span></a></h1>
				</div>
		 <!---->
		 
			<div class="top-nav">
				<div class="clearfix"> </div>
			</div>
					<!---->
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
							<input type="text" class="form-control" name="first_name" required pattern="[A-z ]+" maxlength="45" data-pattern-error="Please enter text with A-z."></input>
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<span>Middle Initial</span>
							<input type="text" class="form-control" name="middle_initial" required pattern="[A-z ]+" maxlength="45" data-pattern-error="Please enter text with A-z."></input>
							<div class="help-block with-errors"></div>
						</div>
						<div class="form-group">
							<span>Last Name</span>
							<input type="text" class="form-control" name="last_name" required pattern="[A-z ]+"maxlength="45" data-pattern-error="Please enter text with A-z."></input>
							<div class="help-block with-errors"></div>
						 </div>
						 <div class="form-group">
							 <span>Email Address</span>
							 <input type="text" class="form-control" name="email" required pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$" maxlength="45" data-pattern-error="Please enter correct email format. Ex. maria_christine@gmail.com"></input>
							<div class="help-block with-errors"></div>
						</div>
						<h3>ACCOUNT DETAILS</h3>
						<div class="form-group">
							<span>Username</span>
							<input type="text" class="form-control" name="username" required pattern="[A-z ]+" maxlength="45" data-pattern-error="Please enter text with A-z."></input>
							<div class="help-block with-errors"></div>					 
						</div>
						<div class="form-group">
							<span>Password</span>
							<input type="password" class="form-control" name="password" required pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,}" maxlength="30" id="password" data-pattern-error="Note that a password is at least 8 characters long. Has at least 1 of each: uppercase letter, 1 lowercase letter, number and special symbol."></input>
							<div class="help-block with-errors"></div>					 
						</div>
						<div class="form-group">
							<span>Confirm Password</span>
							<input type="password" class="form-control" name="confirmPass" required data-match="#password" data-match-error="Whoops, these don't match."></input>
							<div class="help-block with-errors"></div>						 
						</div>
						<div>
							<span>Type</span>
							<select name="type">
  								<option value="2">Product Manager</option>
 								<option value="3">Accounting Manager</option>
							</select>					 
						</div>
					 </div>
				     <input type="submit" value="submit">
				</form>
	</div>
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