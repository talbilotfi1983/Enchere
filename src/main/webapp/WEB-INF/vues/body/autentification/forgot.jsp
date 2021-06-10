/Forgot password
<form class="needs-validation row container img-thumbnail offset-3 mt-5  col-lg-6" novalidate 
	action="register" method="post">



	<div class="col-lg-6 p-3">


		<img src="resources/img/autentification/forgot_.png"
			class="img-fluid img-thumbnail">





	</div>
	<div class="col-lg-6 p-3">
		<div class="text-center">
			<p class="mb-4">We get it, stuff happens. Just enter your email
				address below and we'll send you a link to reset your password!</p>
		</div>



		<div class="form-group row ">
			
				<input type="email" class="form-control " id="email"
					placeholder="Email Address" name="email" required>
				<div class="invalid-feedback">Sorry, email format like
					xxxx@xxxx</div>


		</div>

		<div class="form-group row">
		
				<button class="btn btn-primary btn-user btn-block" type="submit"
					id="btnRegister">Reset password</button>
			

		</div>

		<hr>

		<div class="text-center ">
			<a class="small" href="loginServlet">Already have an account? Login!</a>
		</div>
		<div class="text-center ">
			<a class="small " href="registerServlet">Create an Account!</a>
		</div>

	</div>
</form>
<script src="resources/js/validation_register.js"></script>




