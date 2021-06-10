\Product
<%@page import="fr.encheres.bo.Article"%>
<%Article article = (Article)request.getAttribute("articleEncours"); %>
<div class="row col-lg-4 img-thumbnail form-group mx-auto mt-2">
		<img class=" picture img-thumbnail mx-auto mt-2"
			src="displayImage?image=<%=article.getImage()%>">
		<div class="mx-auto mt-2">
			<form method="post" action="homeAdminUserServlet" id="myform">
				<input type="hidden" name="idArticle"
					value="<%=article.getIdArticle()%>"> 
					<a href="#" onclick="document.getElementById('myform').submit()">
					<h3 style="color: blue;">
						<%
						out.print(article.getNomArticle().toUpperCase());
						%>
					</h3>
				</a>
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
			%><br>
			
			<div class="form-group row ">
			<div class="col-sm-6 offset-3">
				<a class="btn btn-success btn-block" id="btnUpdate"
					href="updateProfilServlet">Update product</a>
			</div>

		</div>

		<hr>

		<div class="text-center">

			<a href="homeAdminUserServlet">&larr; Back to Home</a>
		</div>
		</div>
		
	</div>