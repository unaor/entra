<%@ include file="/WEB-INF/pages/head.jsp" %>

<!-- NAVBAR
================================================== -->
<body>
	<%@ include file="/WEB-INF/pages/header.jsp" %>


	<div class="container registery">
	
	<form:form modelAttribute="user" method="post" action ="${registerURL}" cssClass="form-horizontal">
			
			<div class="form-group">
				<label for="userName" class="col-md-3 control-label">nombres tama&ntilde;o</label>
				<div class="col-sm-9">
				<form:input cssClass="form-control input-sm" path="firstName"/> <form:errors path="firstName" cssClass="alert-danger" />
				</div>
			</div>
			<div class="form-group">
				<label for="userPassword" class="col-md-3 control-label">appellidos tamaño</label>
				<div class="col-sm-9">
					<form:input cssClass="form-control input-sm" path="lastName"/> <form:errors path="lastName" cssClass="alert-danger" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-3 control-label">email</label>
				<div class="col-sm-9">
					<form:input cssClass="form-control input-sm" path="email"/><form:errors path="email" cssClass="alert-danger" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-3 control-label">password</label>
				<div class="col-sm-9">
					<form:password cssClass="form-control input-sm" path="password"/><form:errors path="password" cssClass="alert-danger" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-3 control-label">confirmar password</label>
				<div class="col-sm-9">
					<form:input cssClass="form-control input-sm" path="passwordConfirmation"/>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-9">
					<div class="checkbox">
						<label> <form:checkbox path="acceptedTos"/> estoy de acuerdo con los condiciones de entra<br/><form:errors path="acceptedTos" cssClass="alert-danger" />
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-8">
					<button type="submit" class="btn btn-primary" id="loginBtn">Registrar</button>
				</div>
			</div>
		</form:form>


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
	<jsp:include page="scripts.jsp"/>

</body>
</html>
