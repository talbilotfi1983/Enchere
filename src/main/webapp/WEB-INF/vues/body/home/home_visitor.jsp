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
<form class="row img-thumbnail form-group  container mt-5 mx-auto p-5"
	action="homeVisitorServlet" method="post">
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
	<button
		class="offset-lg-1 btn btn-primary btn-user btn-block col-lg-2 col-sm-6 "
		type="submit" id="btnRegister">Search</button>
</form>

<div class="row img-thumbnail form-group col-lg-10 col-sm-10 offset-1 ">
	<%
	for (Article article : articles) {
	%>

	<div class="row col-lg-4 img-thumbnail form-group mx-auto mt-2">

		<img class=" picture img-thumbnail mx-auto mt-2"
			src="displayImage?image=<%=article.getImage()%>">
		<div class="mx-auto mt-2">
			<h3 style="color: blue;">
				<%
				out.print(article.getNomArticle().toUpperCase());
				%>
			</h3>
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
			%><br>
		</div>
	</div>
	<%
	}
	%>
</div>