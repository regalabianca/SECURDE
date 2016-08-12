<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
							<li><a href="account.jsp"><i class="glyphicon glyphicon-user" class="men"> </i>Login</a></li>
							<li><a href="register.jsp"><i class="glyphicon glyphicon-lock" class="tele"> </i>Create an Account</a></li>			
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
					<li class="grid"><a href="boots page.jsp">Boots</a>
					</li>
					<li class="grid"><a href="shoes page.jsp">Shoes</a>
					</li>
					<li class="grid"><a href="sandals page.jsp">Sandals</a>
					</li>
					<li class="grid"><a href="slippers page.jsp">Slippers</a>
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
				<div class="product-bottom">
					<div class="of-left-in">
								<h3 class="best">Payment Details</h3>
					</div>
					<p>Shipping Fee: </p>
					<div class="clearfix"> </div>
					<p>Total Price: </p>
				</div>
				</div>
				<!---->
				<div class="col-md-9 product-price1">
				<div class="check-out">	 
			
		 <div class=" cart-items">
			 <h3>My Shopping Bag</h3>
			 <div class="in-check" >
				  <div>
					<h4>Billing Address</h4>
					<form>
						House # : <br>
						<input id="houseNum0" type ="text"><br>
						Street Name: <br>
						<input id="street0" type ="text"><br>
						Subdivision: <br>
						<input id="subdivision0" type ="text"><br>
						City: <br>
						<input id="city0" type ="text"><br>
						Postal Code: <br>
						<input id="postalCode0" type ="text"><br>
						Country: <br>
						<input id="country0" type ="text"><br>
					</form>
				 </div>
				 <div>
					<h4>Shipping Address</h4>
					<input type="checkbox" id="same-check" />
					Same as billing address.
					<div id="shipping-ad-form">
						<form>
							House # : <br>
							<input id="houseNum1" type ="text"><br>
							Street Name: <br>
							<input id="street1" type ="text"><br>
							Subdivision: <br>
							<input id="subdivision1" type ="text"><br>
							City: <br>
							<input id="city1" type ="text"><br>
							Postal Code: <br>
							<input id="postalCode1" type ="text"><br>
							Country: <br>
							<input id="country1" type ="text"><br>
						</form>
					</div> <!--  shipping-ad-form -->
				 </div>	
				 <div>
					<h4>Credit Card Information</h4>
					<form>
						Credit Card Name: <br>
						<input id="cardName" type ="text"><br>
						Credit Card Number: <br>
						<input id="cardNum" type="text"><br>
					</form>
				 </div>	
				 <a href="#" id="confirmPayment" type="submit" class="add-cart item_add">CONFIRM PAYMENT</a>
			</div>
			 </div>
					  
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
	
	$("#confirmPayment").click(function(){
		
		var cardName = document.getElementById('cardName').value;
		var cardNum = document.getElementById('cardNum').value;
		
		var houseNum0 = document.getElementById('houseNum0').value;
		var street0 = document.getElementById('street0').value;
		var subdivision0 = document.getElementById('subdivision0').value;
		var city0 = document.getElementById('city0').value;
		var postalCode0 = document.getElementById('postalCode0').value;
		var country0 = document.getElementById('country0').value;
		
		var houseNum1;
		var street1;
		var subdivision1;
		var city1;
		var postalCode1;
		var country1;
		
		if(document.getElementById('same-check').checked) {
			houseNum1 = houseNum0;
			street1 = street0;
			subdivision1 = subdivision0;
			city1 = city0;
			postalCode1 = postalCode0;
			country1 = country0;
		}
		else{ 
			houseNum1 = document.getElementById('houseNum1').value;
			street1 = document.getElementById('street1').value;
			subdivision1 = document.getElementById('subdivision1').value;
			city1 = document.getElementById('city1').value;
			postalCode1 = document.getElementById('postalCode1').value;
			country1 = document.getElementById('country1').value;
		}
		
		var params = {
			cardName: cardName,
			cardNum: cardNum,
			b_houseNum: houseNum0,
			b_street: street0,
			b_subdivision: subdivision0,
			b_city: city0,
			b_postalCode: postalCode0,
			b_country: country0,
			s_houseNum: houseNum1,
			s_street: street1,
			s_subdivision: subdivision1,
			s_city: city1,
			s_postalCode: postalCode1,
			s_country: country1
		};
			
		$.post("PaymentServlet", $.param(params), function(response){
			alert("done with servlet");
		});
	});
</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!----> 
<!---->
</body>
</html>