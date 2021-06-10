/Credit

<form class="container img-thumbnail offset-4 mt-5  col-lg-4 "
	action="creditServlet" method="post">
	<div class="col-lg-12">
		<div class="form-group mt-3">
			<input type="text" class="form-control" id="credit"
				placeholder="Enter credit ..." name="credit"
				title="Accepted characters : 0-9" pattern="[0-9]{0,30}$" required
				maxlength="30">
			<div class="invalid-feedback">Sorry, error credit !!</div>


		</div>
	</div>
	<div class="col-lg-12 mt-3 ">
		<div class="row">
		
			<div class="col-sm-6 ">
				<button class="btn btn-primary btn-user btn-block" type="submit"
					id="btnRegister">Register</button>
			</div>
			<div class="col-sm-6">
				<a href="home" class="btn btn-secondary btn-user btn-block">
					Cancel </a>
			</div>
		</div>

	</div>
	<hr>
</form>


<script src="resources/js/validation_register.js"></script>