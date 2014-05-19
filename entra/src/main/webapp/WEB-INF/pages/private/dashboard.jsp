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

<title><spring:message code="dashboard.page.title" /></title>

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
	<jsp:include page="../header.jsp"/>



<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-md-6" style="padding: 10px;">
				<div class="col-md-12" style="padding-left: 8px;">
					<img src="http://placehold.it/400x250" alt="Third slide">
				</div>
				<div class="col-md-12" style="text-align: center;">
					<h3 style="color: green;">Dos sabanas por el precio de uno</h3>
				</div>
				<div class="col-md-12" style="text-align: center;">
					<span>Telas la sanaba</span>
				</div>
				<div class="col-md-12">
					<span class="before-price">150,000</span><span class="after-price">
						100,000</span>
				</div>
				<div class="col-md-12" style="text-align: center; margin-top: 10px;">
					<button type="button" class="btn btn-primary btn-lg btn-sms"
						data-toggle="modal" data-target="#myModal" data-id="coupon-id:1">
						<span class="glyphicon glyphicon-search sms-glyphicon"> </span>
						<spring:message code="home.page.learn.more.button" />
					</button>
				</div>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-md-6" style="padding: 10px;">
				<div class="col-md-12" style="padding-left: 8px;">
					<img src="http://placehold.it/400x250" alt="Third slide">
				</div>
				<div class="col-md-12" style="text-align: center;">
					<h3 style="color: green;">Dos sabanas por el precio de uno</h3>
				</div>
				<div class="col-md-12" style="text-align: center;">
					<span>Telas la sanaba</span>
				</div>
				<div class="col-md-12">
					<span class="before-price">150,000</span><span class="after-price">
						100,000</span>
				</div>
				<div class="col-md-12" style="text-align: center; margin-top: 10px;">
					<button type="button" class="btn btn-primary btn-lg btn-sms"
						data-toggle="modal" data-target="#myModal" data-id="coupon-id:2">
						<span class="glyphicon glyphicon-search sms-glyphicon"> </span>
						<spring:message code="home.page.learn.more.button" />
					</button>
				</div>
			</div>
			<!-- /.col-lg-4 -->

			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->


		<!-- FOOTER -->
		<footer>
			<p class="pull-right">
				<a href="#">Back to top</a>
			</p>
			<p>
				&copy; 2014 Company, Inc. &middot; <a href="#">Privacy</a> &middot;
				<a href="#">Terms</a>
			</p>
		</footer>

	</div>

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


</body>
</html>
