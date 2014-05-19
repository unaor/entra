<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 450px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" style="font-size: 11px;" id="myModalLabel">
						<spring:message code="home.page.modal.facebook.publish" />
					</h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<img src="http://placehold.it/400x250" alt="Third slide">
						</div>
						<div class="col-md-12">
							<span id="modal-description" style="text-align: center;"><h3
									style="color: green;">Dos sabanas por el precio de uno</h3></span><br />
							<div class="col-md-12" style="text-align: center;">Food,
								celebration, and Peruvian music are all on the schedule at
								Amazon Peru Expo's celebration of Fiesta de San Juan. Sponsored
								by the Taste of Peru Festival, this annual event makes it's
								debut at a new venue—Pinto's Farm, in front of Monkey Jungle.
								Headlining the event is Ana Kohler, the lead singer of the
								legendary cumbia outfit Euforia. While in attendance, guests
								will sample traditional Peruvian dishes while enjoying a
								tropical paradise.</div>

							<div class="col-md-12">
								<table class="table table-hover">
									<tr>
										<td><spring:message code="coupon.detail.original.price"/></td>
										<td class="coupon-detail-before-price">24.000</td>
									</tr>
									<tr>
										<td><spring:message code="coupon.detail.new.price"/></td>
										<td class="coupon-detail-after-price">16.000</td>
									</tr>
									<tr>
										<td><spring:message code="coupon.detail.coupon.value"/></td>
										<td>8.000</td>
									</tr>
									<tr>
										<td><spring:message code="coupon.detail.coupon.validity"/></td>
										<td>12-julio 2014</td>
									</tr>
									<tr>
										<td><spring:message code="coupon.detail.coupon.quantity"/></td>
										<td>12</td>
									</tr>
									<tr>
										<td><button type="button"
												class="btn btn-success btn-lg btn-sms" data-toggle="modal"
												data-target="#myModal" data-id="coupon-id:1">
												<span class="glyphicon glyphicon-earphone sms-glyphicon">
												</span>
												<spring:message code="home.coupon.detail.send.sms.button" />
											</button></td>

										<td style="padding-top: 12px;"><button type="button"
												class="btn btn-danger" data-dismiss="modal">
												<span class="glyphicon glyphicon-remove-sign sms-glyphicon">
												</span><spring:message code="home.coupon.detail.close.modal.button" />
											</button></td>

									</tr>
								</table>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>