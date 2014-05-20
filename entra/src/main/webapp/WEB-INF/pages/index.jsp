<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.ico">

<title><spring:message code="home.page.title" /></title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="./dist/css/bootstrap.min.css">
<link rel="stylesheet" href="./dist/css/entra.css">
<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<!-- NAVBAR
================================================== -->
<body>
	<jsp:include page="header.jsp"/>


	<!-- Carousel
    ================================================== -->

	<jsp:include page="carousel.jsp"/>
	
	<!-- /.carousel -->



	<!-- coupons body
    ================================================== -->
	
<jsp:include page="coupons.jsp"/>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/js/bootstrap.min.js"></script>
	<script type='text/javascript'
		src="http://imsky.github.io/holder/holder.js"></script>
	<script type='text/javascript' src="./dist/js/entra/entra.js"></script>

<jsp:include page="coupon-detail.jsp"/>
<jsp:include page="login.jsp"/>

</body>
</html>
