/Sell product

<%@page import="fr.encheres.bo.User"%>
<%@page import="fr.encheres.bo.Category"%>
<%@page import="java.util.List"%>
<link href="resources/css/validation_register.css" rel="stylesheet">

<form
	class="needs-validation row container img-thumbnail offset-1 mt-5 col-lg-10"
	novalidate  action="sellProduct"
	method="post" enctype="multipart/form-data">

	<% if(session.getAttribute("userSuccess")==null)
		request.getRequestDispatcher("/loginServlet").forward(request, response);

	
	
	List<Category> categories = (List<Category>) request.getAttribute("categories");
	%>


	<div class="col-lg-12 p-3">
		<div class="form-group row">

			<div class="col-sm-6">
				<abbr>*</abbr> <input type="text" class="form-control "
					id="nom_article" placeholder="Product" name="nom_article"
					title="Accepted characters : a-zA-Z0-9-_\. "
					pattern="^[a-zA-Z][a-zA-Z0-9-_\. @$!?]{4,30}$" 
					maxlength="30">

				<div class="invalid-feedback">Sorry, product name must start
					with an alphabitic letter and be between 4 and 30 characters long</div>


			</div>
		</div>

		<div class="form-group row">
			<div class="col-sm-12">
				<abbr>*</abbr><input type="text" class="form-control "
					id="description" name="description" placeholder="Description"
					 pattern="a-zA-Z][a-zA-Z0-9-_\. @$!?]{4,50}$">
				<div class="invalid-feedback">Sorry, description must between
					4 and 50 alphabitic characters long</div>
			</div>

		</div>
		<div class="form-group row ">
			<label class="ml-3">Category : </label>
			<div class="col-sm-4  ">
				<select name="idCategorie" aria-controls="dataTable"
					class=" form-control ">
					<%
					for (Category category : categories) {
					%>
					<option value="<%=category.getIdCategory()%>"><%=category.getLibelle()%></option>
					<%
					}
					%>
				</select>
			</div>

			<label class="ml-3">Picture : </label>
			<div class="col-sm-5">
				<input class="form-control " type="file" name="multiPartServlet"
					accept="image/*" >

			</div>


		</div>

		<div class="form-group row ">
			<div class="col-sm-6 ">
				<abbr>*</abbr><input type="text" name="mise_a_prix"
					class="form-control  " id="mise_a_prix" placeholder="Price"
					 pattern="^[0-9]{1,10}$">
				<div class="invalid-feedback">Sorry, invalid price</div>
			</div>


		</div>
		
		<div class="form-group row"><label class="col-sm-6">Start of sale</label> <label class="col-sm-6">End of sale</label></div>
		<div class="form-group row">
			<div class="col-sm-6 ">
				 <abbr>*</abbr><input name="date_debut_enchere" type="date" ><abbr>*</abbr><input
					name="heure_debut_enchere" type="time" >
			</div>
			<div class="col-sm-6">

				<abbr>*</abbr><input name="date_fin_enchere" type="date" ><abbr>*</abbr><input
					name="heure_fin_enchere" type="time" >
			</div>
		</div>

		<hr>
		<div class="form-group row ">
			<div class="col-sm-3">
				<abbr>*</abbr><input type="text" class="form-control " id="numero"
					name="numero" placeholder="N°" >
				<div class="invalid-feedback">Sorry, adress number not found</div>
			</div>

			<div class="col-sm-9">
				<abbr>*</abbr><input type="text" class="form-control  " id="adresse"
					name="adresse" placeholder="Adress" >
				<div id="selection" style="display: none;" class="dropdown1">

				</div>
			</div>
		</div>



		<div class="form-group row">
			<div class="col-sm-6 ">
				<abbr>*</abbr><input type="text" class="form-control "
					id="codePostal" name="codePostal" placeholder="ZIP code"
					pattern="\b[0-9]{5}\b" >
			</div>
			<div class="col-sm-6">
				<abbr>*</abbr><input type="text" class="form-control " id="ville"
					name="ville" placeholder="City" >

			</div>
		</div>
		<hr>


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



	</div>
</form>


<script src="resources/js/autoComplite.js"></script>
<script src="resources/js/validation_register.js"></script>





