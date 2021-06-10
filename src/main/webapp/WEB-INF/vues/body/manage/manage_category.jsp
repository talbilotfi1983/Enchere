\Manage users
<%@page import="fr.encheres.bo.Category"%>
<%@page import="java.util.List"%>
<%
List<Category> categories = (List<Category>) session.getAttribute("categories");
%>
<div id="content" class="container-fluid row">
	<div class="mt-5 col-lg-6" >
		<div class=" shadow mb-4">

			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Lebelle</th>
								<th>Update</th>
								<th>Action</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Lebelle</th>
								<th>Update</th>
								<th>Action</th>
							</tr>
						</tfoot>
						
						<tbody>
						
							<%
							for (Category category : categories) {
							%>
							
							<tr>
							<form action="manageCategoryServlet" method="post">
								<td class="font-weight-bold" >
									<%
									out.print(category.getLibelle());
									%>
								</td>
								<td><input value=<%=category.getLibelle()%> name="libelle"></td>
									
								<td>
								<input type="hidden" name="idCategory" value="<%=category.getIdCategory()%>"/>
							<button type="submit" name="submit" value="update">
									<i  class="fa fa-save " style="color: green;" >
									</i>
							</button>
								&nbsp;|&nbsp;
								
								
								<button type="submit" name="submit" value="delete">
									<i class="fa fa-trash" style="color: red; ">
									</i>
								</button>
									</td>
								</form>
								<%
							}
							%>
								
							</tr>
							
						</tbody>
						
					</table>
				</div>
			</div>
		</div>
	</div>
	<form class=" offset-1  mt-5 col-lg-3  " action="manageCategoryServlet" method="post">
		<div class="col-lg-12 img-thumbnail">
			<div class="form-group mt-5">
				<input type="text" class="form-control" id="libelle"
					placeholder="Enter new category ..." name="libelle"
					title="Accepted characters : a-zA-Z" pattern="[a-zA-Z]{0,30}$" required
					maxlength="30">
				<div class="invalid-feedback">Sorry, error category !!</div>
			</div>
			<div class="col-lg-12 mb-5">
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
				<hr>
			</div>
		</div>
	</form>

</div>
<script>
	function confirmer() {
		var res = confirm("Are you sure you want to delete your category?");
		if (!res) {

		}
	}
</script>




