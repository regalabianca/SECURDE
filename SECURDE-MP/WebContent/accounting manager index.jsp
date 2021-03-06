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
<link href="css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<META HTTP-EQUIV="refresh" CONTENT="<%= session.getMaxInactiveInterval() %>; URL=account.jsp" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="I wear Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/datatable-manager.js"></script>
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
							        <li><a href="#"><i class="glyphicon glyphicon-user" class="men"> </i><c:out value="${a.username}"/></a></li>
							        <li><a href="LogOutServlet"><i class="glyphicon glyphicon-user" class="men"> </i>Logout</a></li>
							    </c:otherwise>
							</c:choose>				
						</ul>
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>	
<div class="header">
	<div class="header-top">

			<div class="header-bottom">
			<div class="container">			
				<div class="logo">
					<h1><a href="HomeServlet">I-<span>wear</span></a></h1>
				</div>

				<!-- <div class="clearfix"> </div>
					<table id="acc-man-table" class="display" cellspacing="0" width="100%">
					</table>
					
				</div> -->
			<div class="clearfix"> </div>
		</div>
		</div>
	</div>
	
	<form action="SearchPurchaseServlet" method="post">
		Search By: 
		<select id="target" class="target" name="target" onchange="targetchange()">
			<option value = "1">Product Description</option>
			<option value = "2">Category</option>
		</select>
		<select id="editCateg" name ="editCateg"style="display:none;">
			<option selected value="1">Boots</option>
			<option value="2">Shoes</option>
			<option value="3">Sandals</option>
			<option value="4">Slippers</option>
		</select>
		<input id="searchString" type="text" name="searchString"></input>
		<input type="submit" value="Go"></input>
	</form>
	<div class="clearfix"></div>
		<c:forEach var="p" items="${purchases}" varStatus="counter">
					<table class="display" cellspacing="0" width="100%">
					<tr>
					    <th>Product ID</th>
					    <th>Description</th>
					    <th>Category ID</th> 
					    <th>Unit Price</th>
					    <th>Quantity</th>
					    <th>Total Price</th>
					</tr>
					<tr>
					    <td>${p.productId}</td>
					    <td>${p.description}</td>
					    <td>${p.categoryId}</td> 
					    <td>${p.unitPrice}</td>
					    <td>${p.quantity}</td>
					    <td>${p.totalPrice}</td>
					</tr>
					</table>
		</c:forEach>
 	</div>	
		<div class="clearfix"> </div>	
	</div>

<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>

<script>
$(function() {
	console.log("hi");
});
function targetchange()
{
	var x = document.getElementById("target").value;
	if(x == 1){
		$('#editCateg').hide();
		$('#searchString').show();
	}
	else if(x == 2){
		$('#editCateg').show();
		$('#searchString').hide();
	}
}


</script>

</body>
</html>