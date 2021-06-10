<!DOCTYPE html>
<%@page import="fr.encheres.bo.Routage"%>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">



<title>Login</title>

<link href="resources/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="resources/css/sb-admin-2.min.css" rel="stylesheet">

<style>
.error_connect{
color: red;
text-align: center;

}
</style>

    <!-- Custom styles for this page -->
    <link href="resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">


</head>

<body id="page-top">

	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="home">

				<div class="sidebar-brand-text mx-3">
					Auction <sup>sale</sup>
				</div>
			</a>

			<!-- *************** LEFT MENU *************** -->
			<hr class="sidebar-divider my-0">
			<%@ include file="/WEB-INF/vues/menus/left_menu.jsp"%>

		</ul>
		<div id="content-wrapper" class="d-flex flex-column">

			<div id="content">

				<!-- *************** TOP MENU *************** -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<%@ include file="/WEB-INF/vues/menus/top_menu/top_menu.jsp"%>
				</nav>
				<span class="offset-1">
				<%
				StringBuilder builder = new StringBuilder("@");
				if (user == null) {
					builder.append("Visitor");
				} else if (user.isAdmin()) {
					builder.append("Admin");
				} else {
					builder.append("User");
				}

				%>
		
						<%
						out.print(builder);
						%>
				</span>
					<%
					int body = Integer.parseInt((String) request.getParameter("body"));
					String route = Routage.getRoute(body);
					
					
					%>
					<%@page contentType="text/html" pageEncoding="UTF-8"%>
					<jsp:include  page="<%=route%>" />
					
				

				<div class="navbar shadow mt-2"></div>

			</div>
			

			<!-- *************** BOTTOM MENU *************** -->
			<footer class="sticky-footer bg-white">
				<%@ include file="/WEB-INF/vues/menus/bottom.jsp"%>
			</footer>

		</div>

	</div>

	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- *************** LOGOUT MODAL *************** -->
	<%@ include file="/WEB-INF/vues/menus/logout_modal.jsp"%>


	<!-- Bootstrap core JavaScript-->
	<script src="resources/vendor/jquery/jquery.min.js"></script>
	<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="resources/js/sb-admin-2.min.js"></script>
	    <!-- Bootstrap core JavaScript-->

    <!-- Core plugin JavaScript-->

    <!-- Custom scripts for all pages-->

    <!-- Page level plugins -->
    <script src="resources/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="resources/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="resources/js/demo/datatables-demo.js"></script>

</body>

</html>