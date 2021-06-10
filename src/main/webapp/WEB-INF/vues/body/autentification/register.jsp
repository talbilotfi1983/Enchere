/Register
<%@page import="fr.encheres.bo.User"%>
<%
User user9 = (User) session.getAttribute("userSuccess");
if (user9 != null) {
	request.getRequestDispatcher("skeleton?body=1").forward(request,response);

}
%>


<link href="resources/css/validation_register.css" rel="stylesheet">

<form class="needs-validation row container img-thumbnail offset-1 mt-5 col-lg-10" novalidate
	action="registerServlet" method="post"
	oninput='confirmPassword.setCustomValidity(password.value != confirmPassword.value ? "Passwords do not match." : "")'>



	<div class="col-lg-3 p-3">


		<img src="resources/img/autentification/add.png"
			class="img-fluid img-thumbnail">


	</div>
	<div class="col-lg-9 p-3">
		<div class="form-group row">
			<div class="col-sm-3">
				<select name="civilite" aria-controls="dataTable"
					class=" form-control ">
					<option value="Mr">Mr</option>
					<option value="Mrs">Mrs</option>
				</select>
			</div>
			<div class="col-sm-9">
				<abbr>*</abbr> <input type="text" class="form-control " id="pseudo"
					placeholder="Pseudo" name="pseudo"
					title="Accepted characters : a-zA-Z0-9-_\. "
					pattern="^[a-zA-Z][a-zA-Z0-9-_\. @$!?]{4,30}$" required
					maxlength="30">

				<div class="invalid-feedback">Sorry, your pseudo must start
					with an alphabitic letter and be between 4 and 30 characters long</div>


			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-6">
				<abbr>*</abbr><input type="text" class="form-control " id="nom"
					name="nom" placeholder="First Name" required
					pattern="[A-Za-z._- ]{4,30}$">
				<div class="invalid-feedback">Sorry, first name must between 4
					and 30 alphabitic characters long</div>
			</div>
			<div class="col-sm-6">
				<abbr>*</abbr><input type="text" class="form-control " id="prenom"
					placeholder="Last Name" name="prenom" pattern="[A-Za-z._- ]{4,30}$"
					required>
				<div class="invalid-feedback">Sorry, last name must between 4
					and 30 alphabitic characters long</div>
			</div>
		</div>

		<hr>



		<div class="form-group row ">
			<div class="col-sm-6  ">
				<abbr>*</abbr><input type="email" class="form-control " id="email"
					placeholder="Email Address" name="email" required>
				<div class="invalid-feedback">Sorry, email format like
					xxxx@xxxx</div>


			</div>
			<div class="col-sm-6">
				<abbr>*</abbr><input type="text" class="form-control "
					id="telephone" name="telephone" placeholder="Phone number"
					maxlength="10" pattern="0[1-9][0-9]{8}" required>
				<div class="invalid-feedback">Sorry, phone format: 0123456789</div>
			</div>
		</div>
		<hr>
		<div class="form-group row ">
			<div class="col-sm-3">
				<abbr>*</abbr><input type="text" class="form-control " id="numero"
					name="numero" placeholder="N°" required>
				<div class="invalid-feedback">Sorry, adress number not found</div>
			</div>

			<div class="col-sm-9">
				<abbr>*</abbr><input type="text" class="form-control  " id="adresse"
					name="adresse" placeholder="Adress" required>
				<div id="selection" style="display: none;" class="dropdown1">

				</div>
			</div>
		</div>



		<div class="form-group row">
			<div class="col-sm-6 ">
				<abbr>*</abbr><input type="text" class="form-control "
					id="codePostal" name="codePostal" placeholder="ZIP code"
					pattern="\b[0-9]{5}\b" required>
			</div>
			<div class="col-sm-6">
				<abbr>*</abbr><input type="text" class="form-control " id="ville"
					name="ville" placeholder="City" required>

			</div>
		</div>
		<hr>

		<div class="form-group row ">
			<div class="col-sm-6 ">
				<abbr>*</abbr><input type="password" name="password"
					class="form-control  " id="password" placeholder="Password"
					required pattern="^[a-zA-Z0-9-_\.@$!?]{8,30}$">
				<div class="invalid-feedback">Sorry, invalid password</div>
			</div>
			<div class="col-sm-6">
				<abbr>*</abbr><input type="password" class="form-control "
					id="confirmPassword" placeholder="Repeat Password" required>
				<div class="invalid-feedback">Sorry, invalid password
					confirmation</div>

			</div>
		</div>
		<div class="form-group row ">
			<div class="col-sm-6 ">
				<button class="btn btn-primary btn-user btn-block" type="submit"
					id="btnRegister">Register</button>
			</div>
			<div class="col-sm-6">
				<a href="home" class="btn btn-secondary btn-user btn-block">
					Cancel </a>
			</div>
		</div>

		<hr>

		<div class="text-center ">
			<a class="small" href="forgotServlet">Forgot Password?</a>
		</div>
		<div class="text-center ">
			<a class="small " href=loginServlet>Already have an account?
				Login!</a>
		</div>

	</div>
</form>


<script src="resources/js/autoComplite.js"></script>
<script src="resources/js/validation_register.js"></script>




