<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
	    							<li><a href="register.jsp"><i class="glyphicon glyphicon-lock" class="tele"> </i>Create an Account</a></li>	
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
						<a href="${pageContext.request.contextPath}/ViewCartServlet">
						<h3> <div class="total">
							<span class="simpleCart_total"> </span> (<span id="simpleCart_quantity" class="simpleCart_quantity"> </span>)</div>
							<img src="images/cart2-2.png" alt=""/></h3>
						</a>
						<form action="EmptyCartServlet">
						<input type="hidden" name ="hidebtn" value="single.jsp"></input> 
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
						<form action ="AddCartServlet"> 
						<c:set var="p" value="${product}" scope="request"></c:set>
						<h4><c:out value="${p.description}"/></h4>
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
									<br>
									<a href="#"> <c:out value="${fn:length(reviews)}"/> customer review(s) </a>
									<!-- <a href="#"> ${fn:length(reviews)} customer review(s) </a> -->
									
								</div>
							<div class="clearfix"> </div>
							</div>
							<h5 class="item_price">P <c:out value="${p.price}"/></h5>
							<div class="available">
						</div>
							<div class="cart-add">
								<input type = "submit" class="add1 item_add" value ="ADD TO CART">
								<div class="clearfix"> </div>
							</div>
							</form>
						</div>
					</div>
				<div class="clearfix"> </div>
			<!---->
					<div class="cd-tabs">
			<nav>
				<ul class="cd-tabs-navigation">
					<li><a data-content="add-review"  href="#0">Add Review </a></li>
					<li><a data-content="view-reviews" href="#0" class="selected ">Reviews (<c:out value="${fn:length(reviews)}"/>)</a></li>
					<!-- <li><a data-content="view-reviews" href="#0" class="selected ">Reviews (${fn:length(reviews)})</a></li> -->
					
				</ul> 
			</nav>
	<ul class="cd-tabs-content">
		<li data-content="add-review" >
		<!-- <form action="AddReviewServlet" method="post">
							<textarea name="reviewDesc" class="add-re" cols="80" rows="10" value="" onfocus="this.value='';" 
								onblur="if(this.value == '') {this.value='ENTER YOUR MESSAGE*';}"> 
								ENTER YOUR REVIEW*
							</textarea>
							<input type="submit" value="submit">   
						</form>-->
			<c:choose>
				<c:when test="${canReview}">
					<div id="canReview" class="facts">
						<form action="AddReviewServlet" method="post">
							<textarea name="reviewDesc" class="add-re" cols="80" rows="10" value="" onfocus="this.value='';" 
								onblur="if(this.value == '') {this.value='ENTER YOUR MESSAGE*';}"> 
								ENTER YOUR REVIEW*
							</textarea>
							<input type="submit" value="submit">   
						</form>
					</div>	
				</c:when>
				<c:otherwise>
					<div id=cannotReview>
						<br>Sorry. You have to purchase this product first before you can submit a review.
						<br><br><br>
					</div>
				</c:otherwise>
			</c:choose>
		</li> <!-- add-review -->

	<li data-content="view-reviews" class="selected">
		<c:choose>
			<c:when test="${fn:length(reviews) gt 0}">
				<div class="comments-top-top">
					<c:forEach var="r" items="${reviews}" varStatus="counter">
						<div class="top-comment-left">
							<img class="img-responsive" src="images/co.png" alt="">
						</div>
						<div class="top-comment-right" style="margin-bottom:10px;margin-left:0px;">
							<h5 style="color:red;"><c:out value="${r.username}"/></h5>
							<h4><c:out value="${r.description}"/></h4>
						</div>
					</c:forEach>
					<div class="clearfix"> </div>
				</div>
			</c:when>
			<c:otherwise>
				<br>Sorry. There are no reviews yet for this product.
				<br><br><br>
			</c:otherwise>
		</c:choose>	
	</li>
<div class="clearfix"></div>
	</ul> 
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