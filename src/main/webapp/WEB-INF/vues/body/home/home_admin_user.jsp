/Home
<%@page import="fr.encheres.bo.Category"%>
<%@page import="fr.encheres.bo.Article"%>
<%@page import="java.util.List"%>
<%
List<Article> articles = (List<Article>) request.getAttribute("articlesCourants");
List<Category> categories = (List<Category>) session.getAttribute("categories");
%>
<style>
.picture {
	float: right;
	height: 300px;
}
</style>
<form class=" img-thumbnail form-group  container mt-5 mx-auto p-5"
	action="homeAdminUserServlet" method="post">

	<div class="row">
		<label class="mr-2">Category : </label> <select name="idCategory"
			class=" col-lg-3 col-sm-12 form-control">
			<option value="0">-- Select category --</option>
			<%
			for (Category category : categories) {
			%>
			<option value="<%=category.getIdCategory()%>"><%=category.getLibelle()%></option>
			<%
			}
			%>
		</select> <input class=" col-lg-3 col-sm-12  form-control offset-lg-1"
			type="text" name="key" placeholder="Name of the article contains... ">
	</div>
	<div class="row mt-3">
		<label class="mr-2">My purchases : </label> <select name="achat"
			class=" col-lg-3 col-sm-12 form-control">
			<option value="none">-- Select --</option>
			<option value="ouverte">open auction</option>
			<option value="encours">my current auction</option>
			<option value="remportes">my auctions won</option>
		</select> <label class="ml-5 mr-2">My sales : </label> <select name="vente"
			class=" col-lg-3 col-sm-12 form-control">
			<option value="none">-- Select --</option>
			<option value="encours">Current sales</option>
			<option value="nondebutes">Non started sales</option>
			<option value="termines">Completed sales</option>

		</select>
		<button
			class="offset-lg-1 btn btn-primary btn-user btn-block col-lg-2 col-sm-6 "
			type="submit" id="btnRegister">Search</button>
	</div>
</form>

<div class="row img-thumbnail form-group  container mt-5 mx-auto p-5">

	<div class="row img-thumbnail form-group col-lg-10 col-sm-10 offset-1 ">
		<%
		for (Article article : articles) {
		%>

		<div class="row col-lg-4 img-thumbnail form-group mx-auto mt-2">
			<img class=" picture img-thumbnail mx-auto mt-2"
				src="displayImage?image=<%=article.getImage()%>">
			<div class="mx-auto mt-2">
				<form action="homeAdminUserServlet" method="post" id="myform">
					<input type="hidden" name="selectArticle"
						value="<%=article.getIdArticle()%>" />

					<button type="submit" class="btn btn-link">
						<h3 style="color: blue;">
							<%
							out.print(article.getNomArticle().toUpperCase());
							%>
						</h3>
					</button>

				</form>

				<%
				out.print(article.getDescription().toUpperCase());
				%>
				<hr>
				<label style="color: blue;">Price:</label>
				<%
				out.print(article.getPrix_de_vente());
				%><br> <label style="color: blue;">End of the auction:</label>
				<%
				out.print(article.getFinEnchere());
				%><br> <label style="color: blue;">Seller :</label>
				<%
				out.print(article.getPseudo().toUpperCase());
				%>

				<br>
			</div>
		</div>
		<%
		}
		%>
	</div>
</div>