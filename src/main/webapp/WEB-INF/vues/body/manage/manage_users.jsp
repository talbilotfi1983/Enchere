\Manage users
<%@page import="java.util.List"%>
<%@page import="fr.encheres.bo.User"%>
<%User user_ = (User)session.getAttribute("userSuccess");

if(user_==null||!user_.isAdmin()){
	request.getRequestDispatcher("skeleton?body=5").forward(request,response);
}
List<User> users = (List<User>)session.getAttribute("users");

%>

<div id="wrapper">


	<div id="content-wrapper" class="d-flex flex-column  mt-5 ">

		<!-- Main Content -->
		<div id="content">

			<!-- End of Topbar -->

			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->

				<!-- DataTales Example -->
				<div class="card shadow mb-4">

					<div class="card-body">
						<form class="table-responsive" action="post">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										
										<th>Pseudo</th>
										<th>Name</th>
										<th>Email</th>
										<th>Phone</th>
										<th>Adress</th>
										<th>Credit</th>
										<th>Admin</th>
										
										<th>Password</th>
										
										<th>Action</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										
										<th>Pseudo</th>
										<th>Name</th>
										<th>Email</th>
										<th>Phone</th>
										<th>Adress</th>
										<th>Credit</th>
										<th>Admin</th>
										<th>Password</th>
										
										<th>Action</th>
									</tr>
								</tfoot>
								<tbody>
								
								<%for(User user0:users){
									user0.getAdresse();
									System.out.print(user0);
									%>
								
									<tr>
										<td class="font-weight-bold"><%out.print(user0.getPseudo()); %></td>
										
										<td><%out.print(String.format("%s %s %s",user0.getCivilite(),user0.getNom().toUpperCase(),user0.getPrenom().toLowerCase())); %></td>
										<td><%out.print(user0.getEmail()); %></td>
										<td><%out.print(user0.getTelephone()); %></td>
										<td><%out.print(String.format("%s %s, %s,%s",user0.getNumero(),user0.getAdresse(),user0.getCodePostal(),user0.getVille())); %></td>
										<td><%out.print(user0.getCredit()); %></td>
										<td><%out.print(user0.isAdmin()); %></td>
										<td><%out.print(user0.getMotDePasse()); %></td>
										<td>
										<a href="activationUser?active=<%=user0.getIdUser()%>" ><i class="fa fa-user" style=color:<%=!user0.isActive()?"red":"green"%>></i></a>
										&nbsp;|&nbsp;
										<a href="deleteUser?delete=<%=user0.getIdUser()%>" onclick="confirmer()" type="button" ><i class="fa fa-trash" ></i></a>
										</td>
										
										
									</tr>
							<%} %>
								</tbody>
							</table>
						</form>
					</div>
				</div>

			</div>
			<!-- /.container-fluid -->

		</div>
		<!-- End of Main Content -->

		<!-- End of Footer -->

	</div>
	<!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top"> <i
	class="fas fa-angle-up"></i>
</a>
<script>
function confirmer(){
    var res = confirm("Are you sure you want to delete your account?");
    if(!res){
    	
    }
}

</script>




