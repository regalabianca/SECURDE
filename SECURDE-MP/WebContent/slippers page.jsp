<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h2>Slippers</h2>
</div>
		<!---->
		<div class="product">
			<div class="container">
				<div class="col-md-3 product-price">
					  <div class="price-grid">
					    <div class="of-left">
						<h3 class="cate cate-on">SEARCH</h3>
						<input placeholder="Search" type="text"></input>
						<a  class="go" href="single.jsp">GO</a>
					</div>
	  <!-- <ul class="dropdown-menu1">
            <li><a href="#">
                <p>
                      <label for="amount" class="amount">Range:</label>
                     <input type="text" id="amount" style="border: 0; color: #ff5d56; font-weight: bold;" />
						  </p>
                
                   <div id="slider-range"></div>
                </a></li>
				
          </ul> -->
		  	<div class="clearfix"> </div>
<!---->
 <script type="text/javascript" src="js/jquery-ui.min.js"></script>

      <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">

<script type='text/javascript'>//<![CDATA[ 
$(window).load(function(){
 $( "#slider-range" ).slider({
            range: true,
            min: 0,
            max: 500,
            values: [ 100, 400 ],
            slide: function( event, ui ) {  $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
            }
 });
$( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) + " - $" + $( "#slider-range" ).slider( "values", 1 ) );

});//]]>  

</script>


<!---->
		</div>
				<div class=" rsidebar span_1_of_left">
					</div>
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
				<!---->
	</div>
				
				<div class="col-md-9 product-price1">
					<div class="mens-toolbar">
						<p class="showing">Showing 1–9 of 21 results</p>
	                 <div class="sort">
			            <select>
			                  <option value=""> Sorting By Rate</option>
			                    <option value="">Sorting By Color </option>
			                    <option value="">Sorting By Price </option>
			            </select>
			          
	    		     </div>
    	      
                	<div class="clearfix"></div>		
		        </div>
		        <div class="product-right-top">
		        	<div class="top-product">
		        		<div class="col-md-4 chain-grid  simpleCart_shelfItem">
		        			<div class="grid-span-1">
	   		     		<a  href="single.jsp"><img class="img-responsive " src="images/n1.jpg" alt=" ">
	   		     			<div class="link">
	   		     			<ul >
										<li><i class="glyphicon glyphicon-search"> </i></li>
										
							</ul>
	   		     		</div>
	   		     		</a>
	   		     	</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<a href="single.jsp">Sun Glasses #1</a>
	   		     			<div class="star-price">
	   		     				<div class="price-at">
		   		     				<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									</div>
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
								<a class="add2" href="#"><i class="glyphicon glyphicon-heart-empty"> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     		
	   		     	</div>
	   		     	<div class="col-md-4 chain-grid simpleCart_shelfItem">
					<div class="grid-span-1">
	   		     		<a href="single.jsp"><img class="img-responsive " src="images/n2.jpg" alt=" ">
						<div class="link">
	   		     			<ul >
										<li><i class="glyphicon glyphicon-search"> </i></li>
										
							</ul>
	   		     		</div></a>
	   		     		</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<a href="single.jsp">Sun Glasses #1</a>
	   		     			<div class="star-price">
	   		     				<div class="price-at">
		   		     				<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									</div>
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
							<a class="add2" href="#"><i class="glyphicon glyphicon-heart-empty"> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     	</div>
	   		     	<div class="col-md-4 chain-grid simpleCart_shelfItem">
					<div class="grid-span-1">
	   		     		<a href="single.jsp"><img class="img-responsive " src="images/n3.jpg" alt=" ">
						<div class="link">
	   		     			<ul >
										<li><i class="glyphicon glyphicon-search"> </i></li>
										
							</ul>
	   		     		</div></a>
	   		     		</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<a href="single.jsp">Sun Glasses #1</a>
	   		     			<div class="star-price">
	   		     				<div class="price-at">
		   		     				<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									</div>
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
								<a class="add2" href="#"><i class="glyphicon glyphicon-heart-empty"> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     	</div>
	   		     	<div class="clearfix"> </div>
		        	</div>
		        	<div class="top-product">
					
		        		<div class="col-md-4 chain-grid simpleCart_shelfItem">
						<div class="grid-span-1">
	   		     		<a href="single.jsp"><img class="img-responsive " src="images/n4.jpg" alt=" ">
						<div class="link">
	   		     			<ul >
										<li><i class="glyphicon glyphicon-search"> </i></li>
										
							</ul>
	   		     		</div><span>NEW</span></a>
	   		     		</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<a href="single.jsp">Sun Glasses #1</a>
	   		     			<div class="star-price">
	   		     				<div class="price-at">
		   		     				<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									</div>
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
								<a class="add2" href="#"><i class="glyphicon glyphicon-heart-empty"> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     	</div>
	   		     	<div class="col-md-4 chain-grid simpleCart_shelfItem">
					
					<div class="grid-span-1">
	   		     		<a href="single.jsp"><img class="img-responsive " src="images/n5.jpg" alt=" ">
						<div class="link">
	   		     			<ul >
										<li><i class="glyphicon glyphicon-search"> </i></li>
										
							</ul>
	   		     		</div></a>
	   		     		</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<a href="single.jsp">Sun Glasses #1</a>
	   		     			<div class="star-price">
	   		     				<div class="price-at">
		   		     				<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									</div>
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
								<a class="add2" href="#"><i class="glyphicon glyphicon-heart-empty"> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     	</div>
	   		     	<div class="col-md-4 chain-grid simpleCart_shelfItem">
					<div class="grid-span-1">
	   		     		<a href="single.jsp"><img class="img-responsive " src="images/n6.jpg" alt=" ">
						<div class="link">
	   		     			<ul >
										<li><i class="glyphicon glyphicon-search"> </i></li>
										
							</ul>
	   		     		</div></a>
	   		     		</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<a href="single.jsp">Sun Glasses #1</a>
	   		     			<div class="star-price">
	   		     				<div class="price-at">
		   		     				<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									</div>
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
								<a class="add2" href="#"><i class="glyphicon glyphicon-heart-empty"> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     	</div>
	   		     	<div class="clearfix"> </div>
		        	</div>
		        	<div class="top-product">
				
		        		<div class="col-md-4 chain-grid simpleCart_shelfItem">
						<div class="grid-span-1">
	   		     		<a href="single.jsp"><img class="img-responsive " src="images/n7.jpg" alt=" ">
						<div class="link">
	   		     			<ul >
										<li><i class="glyphicon glyphicon-search"> </i></li>
										
							</ul>
	   		     		</div><span>NEW</span></a>
	   		     		</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<a href="single.jsp">Sun Glasses #1</a>
	   		     			<div class="star-price">
	   		     				<div class="price-at">
		   		     				<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									</div>
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
								<a class="add2" href="#"><i class="glyphicon glyphicon-heart-empty"> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     	</div>
	   		     	<div class="col-md-4 chain-grid simpleCart_shelfItem">
					<div class="grid-span-1">
	   		     		<a href="single.jsp"><img class="img-responsive " src="images/n8.jpg" alt=" ">
						<div class="link">
	   		     			<ul >
										<li><i class="glyphicon glyphicon-search"> </i></li>
										
							</ul>
	   		     		</div>
						<span>NEW</span></a>
	   		     		</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<a href="single.jsp">Sun Glasses #1</a>
	   		     			<div class="star-price">
	   		     				<div class="price-at">
		   		     				<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									</div>
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
							<a class="add2" href="#"><i class="glyphicon glyphicon-heart-empty"> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     	</div>
	   		     	<div class="col-md-4 chain-grid simpleCart_shelfItem">
					<div class="grid-span-1">
	   		     		<a href="single.jsp"><img class="img-responsive " src="images/n1.jpg" alt=" ">
						<div class="link">
	   		     			<ul >
										<li><i class="glyphicon glyphicon-search"> </i></li>
										
							</ul>
	   		     		</div>
						<span>NEW</span></a>
	   		     		</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<a href="single.jsp">Sun Glasses #1</a>
	   		     			<div class="star-price">
	   		     				<div class="price-at">
		   		     				<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
									</div>
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
								<a class="add2" href="#"><i class="glyphicon glyphicon-heart-empty"> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     	</div>
	   		     	<div class="clearfix"> </div>
		        	</div>
		        </div>
		        <ul class="start">
					<li><a href="#"><i> </i></a></li>
					<li><span>1</span></li>
					<li class="arrow"><a href="#">2</a></li>
					<li class="arrow"><a href="#">3</a></li>
					
					
					<li><a href="#"><i class="next"> </i></a></li>
				</ul>
				<div class="clearfix"> </div>
				</div>
					
				</div>

<script src="js/simpleCart.min.js"> </script>
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
</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!----> 
<!---->
</body>
</html>