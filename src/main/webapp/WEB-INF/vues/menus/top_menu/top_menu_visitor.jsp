<!-- Nav Item - User Information -->

<%@page import="fr.encheres.bo.User"%>

<li class="nav-item dropdown no-arrow"><a
	class="nav-link dropdown-toggle" href="#" id="userDropdown"
	role="button" data-toggle="dropdown" aria-haspopup="true"
	aria-expanded="false"> <span
		class="mr-2 d-none d-lg-inline text-gray-600 small"> 
Visitor
	</span> <img class="img-profile rounded-circle"
		src="resources/img/autentification/visiteur_.png">
</a> <!-- Dropdown - User Information -->
	<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
		aria-labelledby="userDropdown">
		
		<a class="dropdown-item" href="registerServlet"> <i
			class="fas fa-user-plus fa-sm fa-fw mr-2 text-gray-400"></i>Create an
			Account!

		<div class="dropdown-divider"></div>
		<a class="dropdown-item" href="loginServlet" 
			> <i
			class="fas fa-sign-in-alt fa-sm fa-fw mr-2 text-gray-400"></i>
			Login
		</a>
	</div></li>