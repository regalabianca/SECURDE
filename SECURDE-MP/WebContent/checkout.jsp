<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>s
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>I-wear</title>
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
							        <li><a href="#"><i class="glyphicon glyphicon-user" class="men"> </i><c:out value="${a.username}"/></a></li>
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
					<h1><a href="HomeServlet">I-<span>wear</span></a></h1>
				</div>
				
		 
			<div class="top-nav">
				<ul class="memenu skyblue"><li><a href="HomeServlet">Home</a></li>
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
						<a href="ViewCartServlet">
						<h3> <div class="total">	
							<span class="simpleCart_total"> </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> </span>)</div>
							<img src="images/cart2-2.png" alt=""/></h3>
						</a>
						<form action="EmptyCartServlet">
						<input type="hidden" name ="hidebtn" value="checkout.jsp"></input> 
						<p><input type="submit" id="emptycart" name="ec" href="javascript:;" class="simpleCart_empty" value="Empty Cart"></input></p>
						</form>
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
				
				<div class="check-out">	 
					
				 <div class=" cart-items">
					 <h3>My Shopping Bag</h3>
						<script>$(document).ready(function(c) {
							$('.close1').on('click', function(c){
								$('.cart-header').fadeOut('slow', function(c){
									$('.cart-header').remove();
								});
								});	  
							});
					   </script>
					<script>$(document).ready(function(c) {
							$('.close2').on('click', function(c){
								$('.cart-header1').fadeOut('slow', function(c){
									$('.cart-header1').remove();
								});
								});	  
							});
					   </script>
						
					
					<div class="in-check" >
					<form action="CheckoutServlet" method="post">
					  <ul class="unit">
						<li><span>Item</span></li>
						<li><span>Product Name</span></li>		
						<li><span>Unit Price</span></li>
						<li> </li>
						<div class="clearfix"> </div>
					  </ul>
					  <c:forEach var="p" items="${cart}" varStatus="counter"> 
					  <ul class="cart-header">
					   <div class="close1"> </div>
					   
						<li class="ring-in"><a href="single.jsp" ><img src="images/f1.jpg" class="img-responsive" alt=""></a>
						</li>
						<li><span><c:out value="${p.description}"/></span></li>
						<li><span><c:out value="${p.price}"/></span></li>
						<div class="clearfix"> </div>
						</ul>
					</c:forEach>
						<input type ="submit" id="checkout" value="Check Out"></input>
						</form>
						</div>
					 </div>
		 		</div>	
		 			
				</div>
				<div class="clearfix"> </div>
			</div>
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
		function payFunction(){
			alert('Hi');
			if($.session.get('account')!=null)
				$('#pay').submit();
			else
				alert("Pls login first");
		}
		
});
</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!----> 
<!---->
</body>
</html>