<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>I-wears</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
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
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Montez' rel='stylesheet' type='text/css'>
<!--//fonts-->	
<script src="js/simpleCart.min.js"> </script>
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!-- /start menu -->
		  		 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<!-- js -->
		 <script src="js/bootstrap.js"></script>
	<!-- js -->

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
							        <li><a href="account.jsp"><i class="glyphicon glyphicon-user" class="men"> </i>${a.username}</a></li>
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
				
				
				
		 
			<div class="top-nav">
				<ul class="memenu skyblue"><li><a href="index.jsp">Home</a></li>
					<li class="grid"><a href="ViewBootsServlet">Boots</a>
					</li>
					<li class="grid"><a href="ViewShoesServlet">Shoes</a>
					</li>
					<li class="grid"><a href="ViewSandalsServlet">Sandals</a>
					</li>
					<li class="grid"><a href="ViewSlippersServlet">Slippers</a>
					</li>
				</ul>
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
				
			</div>
			<div class="clearfix"> </div>
		</div>
		</div>
</div>
<!---->
<div class="back">
	<h2>Checkout</h2>
</div>
		<!---->
		<div class="product">
			<div class="container">
				<div class="col-md-3 product-price">
				<!---->
				
				</div>
				<!---->
				<div class="col-md-9 product-price1">
			
			 <h3>Payment Details</h3>
			 <div class="in-check" >
			   <form action="PaymentServlet" method="post"> 
			 	<div class="product-bottom">
					<p>Shipping Fee: </p>
					<div class="clearfix"> </div>
					<p>Total Price: </p>
					<input type="hidden" name="total_price" value ="${totalPrice}"></input>
					<!--<input type="hidden" name="purchase_list" value ="${purchaselist}"></input>-->
				</div>
				<br>
				  <div>
					<h4>Billing Address</h4>
					
						House # : <br>
						<input name="houseNum0" type ="text"><br>
						Street Name: <br>
						<input name="street0" type ="text"><br>
						Subdivision: <br>
						<input name="subdivision0" type ="text"><br>
						City: <br>
						<input name="city0" type ="text"><br>
						Postal Code: <br>
						<input name="postalCode0" type ="text"><br>
						Country: <br>
						<input name="country0" type ="text"><br>
					
				 </div>
				 <div>
					<h4>Shipping Address</h4>
					<input type="checkbox" id="same-check" name="same-check" />
					Same as billing address.
					<div id="shipping-ad-form">
						
							House # : <br>
							<input name="houseNum1" type ="text"><br>
							Street Name: <br>
							<input name="street1" type ="text"><br>
							Subdivision: <br>
							<input name="subdivision1" type ="text"><br>
							City: <br>
							<input name="city1" type ="text"><br>
							Postal Code: <br>
							<input name="postalCode1" type ="text"><br>
							Country: <br>
							<input name="country1" type ="text"><br>
						
					</div> <!--  shipping-ad-form -->
				 </div>	
				 <div>
				 	<h4>Credit Card Information</h4>
					
						Credit Card Name: <br>
						<input name="cardName" type ="text"><br>
						Credit Card Number: <br>
						<input name="cardNum" type="text"><br>	
				 </div>
				 	<input type="submit" value="CONFIRM PAYMENT">
			 	</form> 
				 <!--<a href="#" id="confirmPayment" type="submit" class="add-cart item_add">CONFIRM PAYMENT</a>-->
			</div>	
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
			<!---->
<!---->
	
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
	
	$("#same-check").click(function(){
		if(document.getElementById('same-check').checked) 
		    $("#shipping-ad-form").hide();
		else 
		    $("#shipping-ad-form").show();
	});
</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!----> 
<!---->
</body>
</html>