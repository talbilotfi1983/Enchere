<li class="nav-item dropdown no-arrow"><a
	class="nav-link dropdown-toggle" href="#" id="userDropdown"
	role="button" data-toggle="dropdown" aria-haspopup="true"
	aria-expanded="false"> <span
		class="mr-2 d-none d-lg-inline text-gray-600 small"> <%
 out.print("Transactions");
 %>
	</span>
</a> <!-- Dropdown - User Information -->
	<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
		aria-8labelledby="userDropdown">
		<a class="dropdown-item" href="sellProduct"> <i
			class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> 
Sell a product
		</a> <a class="dropdown-item" href="#"> <i
			class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>Bid on a product
		</a> </a>


	</div></li>


<div class="topbar-divider d-none d-sm-block"></div>





<%@page import="fr.encheres.bo.User"%>

<li class="nav-item dropdown no-arrow"><a
	class="nav-link dropdown-toggle" href="#" id="userDropdown"
	role="button" data-toggle="dropdown" aria-haspopup="true"
	aria-expanded="false"> <span
		class="mr-2 d-none d-lg-inline text-gray-600 small"> <%
 User admin = (User) session.getAttribute("userSuccess");
 String pseudo = admin.getPseudo();
 StringBuilder stringBuilder = new StringBuilder(pseudo.substring(0,1).toUpperCase());
 stringBuilder.append(pseudo.substring(1, pseudo.length()).toLowerCase());
 out.print(stringBuilder.toString());
 StringBuilder img = new StringBuilder("resources/img/autentification/");
 if (admin.getCivilite().equals("Mr")) {
 	img.append("profilMal.png");
 } else {
 	img.append("profilFemel.png");
 }
 %>
	</span> <img class="img-profile rounded-circle" src="<%=img.toString()%>">
</a> <!-- Dropdown - User Information -->
	<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
		aria-8labelledby="userDropdown">
		<a class="dropdown-item" href="profilServlet"> <i
			class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
		</a> <a class="dropdown-item" href="manageUsersServlet"> <%
 if (admin.isAdmin()) {
 %> <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Manage
			users
		</a> </a> <a class="dropdown-item" href="manageCategoryServlet"> <i
			class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Manage
			category
		</a>
		<div class="dropdown-divider"></div>
		<%
		}
		%>
		<a class="dropdown-item" href="logoutServlet" data-toggle="modal"
			data-target="#logoutModal"> <i
			class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
			Logout
		</a>
	</div></li>



