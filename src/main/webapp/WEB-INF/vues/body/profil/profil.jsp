/My profil
<%@page import="fr.encheres.bo.User"%>
<%@page import="java.util.List"%>

<%
User user2 = (User) session.getAttribute("userSuccess");
if (user2 == null) {
	request.getRequestDispatcher("skeleton?body=1").forward(request, response);
}
%>
<link href="resources/css/validation_register.css" rel="stylesheet">
<div
	class="needs-validation row container img-thumbnail offset-1 mt-5 col-lg-10 "
	novalidate action="blank" method="post"
	oninput='confirmPassword.setCustomValidity(password.value != confirmPassword.value ? "Passwords do not match." : "")'>



	<div class="col-lg-3 p-3">
		<%
		StringBuilder img = new StringBuilder("resources/img/autentification/");
		if (user2.getCivilite().equals("Mr")) {
			img.append("profilMal.png");
		} else {
			img.append("profilFemel.png");
		}
		%>

		<img src="<%=img.toString() %>"
			class="img-fluid img-thumbnail">





	</div>
	<div class="col-lg-9 p-3">
		<div class="form-group row">
			<div class="col-sm-3">
				<select name="civilite" value=<%=user2.getCivilite()%>
					aria-controls="dataTable" class=" form-control " disabled
					id="civilite">
					<option value="Mr">Mr</option>
					<option value="Mrs">Mrs</option>
				</select>
			</div>
			<div class="col-sm-9">
				<input type="text" disabled class="form-control " id="pseudo"
					placeholder="Pseudo" name="pseudo"
					title="Accepted characters : a-zA-Z0-9-_\. "
					pattern="^[a-zA-Z][a-zA-Z0-9-_\. @$!?]{4,30}$" required
					value=<%=user2.getPseudo()%> maxlength="30">

				<div class="invalid-feedback">Sorry, your pseudo must start
					with an alphabitic letter and be between 4 and 30 characters long</div>


			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-6">
				<input type="text" disabled value=<%=user2.getNom()%>
					class="form-control " id="nom" name="nom" placeholder="First Name"
					required pattern="[A-Za-z._- ]{4,30}$">
				<div class="invalid-feedback">Sorry, first name must between 4
					and 30 alphabitic characters long</div>
			</div>
			<div class="col-sm-6">
				<input type="text" disabled value=<%=user2.getPrenom()%>
					class="form-control " id="prenom" placeholder="Last Name"
					name="prenom" pattern="[A-Za-z._- ]{4,30}$" required>
				<div class="invalid-feedback">Sorry, last name must between 4
					and 30 alphabitic characters long</div>
			</div>
		</div>

		<hr>



		<div class="form-group row ">
			<div class="col-sm-6  ">
				<input type="email" disabled value=<%=user2.getEmail()%>
					class="form-control " id="email" placeholder="Email Address"
					name="email" required>
				<div class="invalid-feedback">Sorry, email format like
					xxxx@xxxx</div>


			</div>
			<div class="col-sm-6">
				<input type="text" disabled value=<%=user2.getTelephone()%>
					class="form-control " id="telephone" name="telephone"
					placeholder="Phone number" maxlength="10" pattern="0[1-9][0-9]{8}"
					required>
				<div class="invalid-feedback">Sorry, phone format: 0123456789</div>
			</div>
		</div>
		<hr>
		<div class="form-group row ">
			<div class="col-sm-3">
				<input type="text" disabled class="form-control " id="numero"
					value=<%=user2.getNumero()%> name="numero" placeholder="N°"
					required>
				<div class="invalid-feedback">Sorry, adress number not found</div>
			</div>

			<div class="col-sm-9">
				<input type="text" disabled class="form-control  " id="adresse"
					name="adresse" value=<%=user2.getAdresse()%> placeholder="Adress"
					required>
				<div id="selection" style="display: none;" class="dropdown1">

				</div>
			</div>
		</div>



		<div class="form-group row">
			<div class="col-sm-6 ">
				<input type="text" disabled value=<%=user2.getCodePostal()%>
					class="form-control " id="codePostal" name="codePostal"
					placeholder="ZIP code" pattern="\b[0-9]{5}\b" required disabled>
			</div>
			<div class="col-sm-6">
				<input type="text" disabled value=<%=user2.getVille()%>
					class="form-control " id="ville" name="ville" placeholder="City"
					disabled required>

			</div>
		</div>
		<hr>

		<div class="form-group row ">
			<div class="col-sm-6 ">
				<label for="credit" id="label">Credit</label> <input type="text"
					disabled class="form-control" id="credit" required name="credit"
					value=<%=user2.getCredit()%>>
				<div class="invalid-feedback">Sorry, invalid password</div>
			</div>
		
			
		</div><a href="creditServlet">BUY POINTS</a>
		<div class="form-group row ">
			<div class="col-sm-6 offset-3">
				<a class="btn btn-success btn-block" id="btnUpdate"
					href="updateProfilServlet">Update Account</a>
			</div>

		</div>

		<hr>

		<div class="text-center">

			<a href="homeAdminUserServlet">&larr; Back to Home</a>
		</div>

	</div>
</div>



<script src="resources/js/autoComplite.js"></script>
<script src="resources/js/validation_register.js"></script>



