<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" style="width: 350px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel"><spring:message code="login.modal.title"/></h4>
      </div>
      <div class="modal-body">
       
					<form class="form-horizontal" role="form" method="post" id="loginForm"
						action="${postLoginUrl}">
						<div class="form-group">
							<label for="userName" class="col-md-3 control-label">User
								name</label>
							<div class="col-sm-9">
								<input type="text" class="form-control input-sm" id="userName"
									name="j_username" placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<label for="userPassword" class="col-md-3 control-label">Password</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="userPassword"
									name="j_password" placeholder="Password">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-9">
								<div class="checkbox">
									<label> <input type="checkbox"
										name="_spring_security_remember_me"> Remember me
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
						<div  class="col-sm-offset-4 col-sm-8">
						<button type="reset" class="btn btn-primary" id="loginBtn">Submit</button>
						</div>
						</div>
					</form>


      </div> 
    </div>
  </div>
</div>
<script type='text/javascript' src="./dist/js/entra/login.js"></script>