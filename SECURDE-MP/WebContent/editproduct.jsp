<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Montez' rel='stylesheet' type='text/css'>
<!--//fonts-->
<!-- start menu -->
<!-- start menu -->
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!-- /start menu -->
<!--//slider-script-->
<script src="js/main.js"></script> <!-- Resource jQuery -->
<script>
	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  	(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  	})(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  	ga('create', 'UA-48014931-1', 'codyhouse.co');
  	ga('send', 'pageview');

  	jQuery(document).ready(function($){
  		$('.close-carbon-adv').on('click', function(){
  			$('#carbonads-container').hide();
  		});
  	});
</script>	
<script src="js/simpleCart.min.js"> </script>
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
<!---->
<div class="back">
	<h2>Product Details</h2>
</div>
		<!---->
		<div class="product">
			<div class="container">
				<div class="col-md-3 product-price">
				<!--initiate accordion-->
		<script type="text/javascript">
			$(function() {
			    var menu_ul = $('.menu > li > ul'),
			           menu_a  = $('.menu > li > a');
			    menu_ul.hide();
			    menu_a.click(function(e) {
			        e.preventDefault();
			        if(!$(this).hasClass('active')) {
			            menu_a.removeClass('active');
			            menu_ul.filter(':visible').slideUp('normal');
			            $(this).addClass('active').next().stop(true,true).slideDown('normal');
			        } else {
			            $(this).removeClass('active');
			            $(this).next().stop(true,true).slideUp('normal');
			        }
			    });
			
			});
		</script>
				<!---->
				<div class="product-bottom">
					<div class="of-left-in">
							</div>
					<div class="product-go">

								
							</div>
				</div>
				</div>
				<!---->
				<div class="col-md-9 product-price1">
				<div class="col-md-5 single-top">	




						<div class="flexslider">
							<ul class="slides">
								<li data-thumb="images/si.jpg">
									<img src="images/si3.jpeg" />
								</li>
								<li data-thumb="images/s2.jpg">
									<img src="images/si1.jpeg" />
								</li>
								<li data-thumb="images/s3.jpeg">
									<img src="images/si2.jpeg" />
								</li>
								<li data-thumb="images/s1.jpg">
									<img src="images/s12.jpeg" />
								</li>
							</ul>
						</div>
<!-- FlexSlider -->
  <script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

	<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>

					</div>	
					<div class="col-md-7 single-top-in simpleCart_shelfItem">
						<div class="single-para ">
						<form method = "post" action ="DeleteProductServlet">
						<c:set var="p" value="${product}" scope="request"></c:set>
						<input type="hidden" id="productId" name="productId" value="<c:out value="${p.productId}"/>"></input>
						<h4 id="description"><c:out value="${p.description}"/></h4>
						<input id="editDesc" type="text" style="display:none;">
							<div class="star-on">
								<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
								<div class="review">
								<p id="category"><c:out value="${category}"/></p>
								<select id="editCateg" style="display:none;">
  									<c:choose>
    									<c:when test="${p.categoryId == 1}">
        									<option selected value="1">Boots</option>
 											<option value="2">Shoes</option>
 											<option value="3">Sandals</option>
 											<option value="4">Slippers</option>
    									</c:when>
    									<c:when test="${p.categoryId == 2}">
        									<option value="1">Boots</option>
 											<option selected value="2">Shoes</option>
 											<option value="3">Sandals</option>
 											<option value="4">Slippers</option>
    									</c:when>
    									<c:when test="${p.categoryId == 3}">
        									<option value="1">Boots</option>
 											<option value="2">Shoes</option>
 											<option selected value="3">Sandals</option>
 											<option value="4">Slippers</option>
    									</c:when>
    									<c:when test="${p.categoryId == 4}">
        									<option value="1">Boots</option>
 											<option value="2">Shoes</option>
 											<option value="3">Sandals</option>
 											<option selected value="4">Slippers</option>
    									</c:when>    
									</c:choose>
								</select>
									<br>
									<a href="#"> 1 customer review </a>
								</div>
							<div class="clearfix"> </div>
							</div>
							
							<div>
								<h5 class="item_price" style="display:inline-block;">P</h5>
								<h5 id="price" class="item_price" style="display:inline-block;"> <c:out value="${p.price}"/></h5>
								<input id="editPrice" type="text" style="display:none;">
							</div>
						
							<a href="#" id="btnEdit" class="add-cart item_add">EDIT PRODUCT INFORMATION</a>
							
								<input href="#" id="btnDelete" type="submit" class="add-cart item_add" value="DELETE PRODUCT"></input>
							</form>
							</div>
							<a href="#" id="btnSave" type="submit" style="display:none;" class="add-cart item_add">SAVE</a>
							<a href="#" id="btnCancel" style="display:none;" class="add-cart item_add">CANCEL</a>

						
					</div>
				<div class="clearfix"> </div>
			<!---->

		<div class="comments-top-top">
				<div class="top-comment-left">
					<img class="img-responsive" src="images/co.png" alt="">
				</div>
				<div class="top-comment-right">
					<h6><a href="#">Hendri</a> - September 3, 2014</h6>
					<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									<p>Wow nice!</p>
				</div>
				<div class="clearfix"> </div>
				<a class="add-re" href="#">ADD REVIEW</a>
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
		
		$("#btnDelete").click(function(){
			var params = {
					productId: document.getElementById('productId').value,
				};
				
				$.post("DeleteProductServlet", $.param(params), function(response){
				});
		});
		
		$("#btnEdit").click(function(){
			var text = $('#description').text();
			var textbox = document.getElementById('editDesc');
			textbox.value=text;
			$('#editDesc').show();
			$('#description').hide();
			//$('#editDesc').text('').append(input);
			
			//var text1 = $('#category').text();
			//var textbox1 = document.getElementById('editCateg');
			//textbox1.value=text1;
			$('#editCateg').show();
			$('#category').hide();
			//$('#editCateg').text('').append(input);
			
			var text2 = $('#price').text();
			var textbox2 = document.getElementById('editPrice');
			textbox2.value=text2;
			$('#editPrice').show();
			$('#price').hide();
			//$('#editPrice').text('').append(input);
			
			$("#btnEdit").hide();
			$("#btnSave").show();
			$("#btnCancel").show();
			
			$("#btnSave").click(function(){
				
				
				
				var params = {
					productId: document.getElementById('productId').value,
					categoryId: document.getElementById('editCateg').value,
					description: document.getElementById('editDesc').value,
					price: document.getElementById('editPrice').value
				};
				
				$.post("UpdateProductServlet", $.param(params), function(response){
					 $('#description').show();
					 $('#description').text('').append(textbox.value);
					 $('#editDesc').hide();
					 
					 var c = document.getElementById('editCateg').value;
					 var ct = "";
					 
					 if (c == 1) 		ct = "Boots";
					 else if (c == 2)	ct = "Shoes";
					 else if (c == 3)	ct = "Sandals";
					 else if (c == 4)	ct = "Slippers";
					 
					 $('#category').show();
					 $('#category').text('').append(ct);
					 //$('#category').text('').append(textbox1.value);
					 $('#editCateg').hide();
					 
					 $('#price').show();
					 $('#price').text('').append(textbox2.value);
					 $('#editPrice').hide();
					
					$("#btnEdit").show();
					$("#btnSave").hide();
					$("#btnCancel").hide();
				});
		    }); 
			$("#btnCancel").click(function(){
				 $('#description').show();
				 //$('#description').text('').append(textbox.value);
				 $('#editDesc').hide();

				 $('#category').show();
				 //$('#category').text('').append(textbox1.value);
				 $('#editCateg').hide();
				 
				 $('#price').show();
				 //$('#price').text('').append(textbox2.value);
				 $('#editPrice').hide();
				
				$("#btnEdit").show();
				$("#btnSave").hide();
				$("#btnCancel").hide();
		    }); 
	    }); 
		
		
		
</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!----> 
<!---->
</body>
</html>