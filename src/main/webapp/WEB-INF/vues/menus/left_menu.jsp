<%@page import="fr.encheres.bo.User"%>
<%
User user1 = (User) session.getAttribute("userSuccess");
String profil = null;
String color = "gold";
if (user1 == null) {
	profil = "Not connect";
	color = "red";

} else if (user1.isAdmin()) {
	profil = "Admin - logout";

} else {
	profil = "User - logout";
}
%>



<!-- Nav Item - Dashboard -->
<li class="nav-item"><a class=" nav-link " href="logout"
	
	<%if (user1 != null) {%>
	data-toggle="modal" data-target="#logoutModal" <%}%>> <i style=color:<%=color%>
		class="fas fa-fw fa-tachometer-alt"></i> <span> <%
 out.print(profil);
 %>
	</span></a></li>
<%
if (user1 != null) {
%>
<!-- Divider -->
<hr class="sidebar-divider">

<!-- Heading -->
<div class="sidebar-heading red_">Interface</div>

<!-- Nav Item - Pages Collapse Menu -->
<li class="nav-item"><a class="nav-link collapsed" href="#"
	data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
	aria-controls="collapseTwo"> <i class="fas fa-fw fa-cog"></i> <span>Transactions</span>
</a>
	<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
		data-parent="#accordionSidebar">
		<div class="bg-white py-2 collapse-inner rounded">
			<h6 class="collapse-header">Custom Components:</h6>
			<a class="collapse-item" href="sellProduct">Sell product</a> <a
				class="collapse-item" href="bidProduct">Bid on a product</a>
		</div>
	</div></li>
<%
if (user1.isAdmin()) {
%>

<li class="nav-item"><a class="nav-link collapsed" href="#"
	data-toggle="collapse" data-target="#collapseUtilities"
	aria-expanded="true" aria-controls="collapseUtilities"> <i
		class="fas fa-fw fa-wrench"></i> <span>Admin</span>
		
		
		
		
</a>
	<div id="collapseUtilities" class="collapse"
		aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
		<div class="bg-white py-2 collapse-inner rounded">
			<h6 class="collapse-header">Custom Utilities:</h6>
			<a class="collapse-item" href="skeleton?body=6">Profil</a> <a
				class="collapse-item" href="manageUsersServlet">Manage users</a> <a
				class="collapse-item" href="manageCategoryServlet">Manage category</a>
		</div>
	</div></li>

<%
}
}
%>
<hr class="sidebar-divider d-none d-md-block">
<!-- Sidebar Toggler (Sidebar) -->
<div class="text-center d-none d-md-inline">
	<button class="rounded-circle border-0" id="sidebarToggle"></button>
</div>
